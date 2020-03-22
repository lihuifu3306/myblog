package com.crazy.article.interceptor;

import com.crazy.article.listener.ContextListener;
import com.crazy.article.service.HistoryVisitService;
import com.crazy.core.util.DateHelper;
import com.crazy.core.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shiyi
 * @version 1.0
 * @date 2020-3-21 20:59
 * 用于历史访问量的拦截器
 * 实现思路：程序启动后，监听器负责读取数据库中的当前的访问量，保存起来
 *          1. 拦截器获取请求的ip地址，根据日期把ip地址存起来。key是日期，value是ip地址
 *          2. 同一个ip地址一天内访问算一次。当ip地址不存在时，则是新的访问量，当天的访问量+1、
 *          3. 启动定时任务，定时的把map中的统计写入到servletContext中。
 *          4. 启动异步定时任务，从servlet中拿到当天的访问量，然后更新数据库
 *          5. 当系统要销毁的时候，把当天的统计保存到数据库中
 *
 */
@Component
public class TotalVisitsInterceptor extends HandlerInterceptorAdapter {

    Logger logger = LoggerFactory.getLogger(ContextListener.class);

    @Autowired
    private ServletContext context;

    @Autowired
    private HistoryVisitService visitService;


    /**
     * key 日期   value ip地址
     */
    Map<String, Set<String>> map = new ConcurrentHashMap<>();
    Map<String, Integer> visitsMap = null;



    @SuppressWarnings("unchecked")
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        synchronized (TotalVisitsInterceptor.class) {
            if (visitsMap == null) {
                logger.info("初始化visitsMap");
                visitsMap = (Map<String, Integer>) context.getAttribute("map");
            }
        }
        return statistical(request);
    }

    /**
     * 每隔5隔小时执行一次
     */
    //    @Scheduled(cron = "0/1 * * * * ?")
    @Scheduled(cron = "0 55 0,5,10,15,20,23 * * ?")
    public void resetVisits() {
        logger.error("进入定时任务");
        if (visitsMap != null) {
            Integer integer = visitsMap.get(DateHelper.today());
            visitService.saveOrUpdateEntity(DateHelper.today(), integer);
        }
    }

    /**
     * 统计访问量
     * @param request 请求
     * @return boolean
     */
    private synchronized boolean statistical(HttpServletRequest request) {
        String addr = getIpAddr(request);
        logger.error(addr);
        String today = DateHelper.today();
        if (!StringHelper.isEmpty(addr)) {
            Set<String> ips = map.get(today);
            if (ips == null || ips.size() == 0) {
                ips = new HashSet<>();
                map.put(today, ips);
            }
            if (ips.add(addr)) {
                Integer count = visitsMap.get(today);
                if (count == null) {
                    count = 0;
                }
                count++;
                visitsMap.put(today, count);
            }
            if (map.size() > 200) {
                map.keySet().removeIf(next -> !next.equals(today));
            }
        }
        return true;
    }

    //获取客户端IP
    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
