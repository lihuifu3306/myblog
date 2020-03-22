package com.crazy.article.listener;

import com.crazy.article.entity.HistoryVisitEntity;
import com.crazy.article.service.HistoryVisitService;
import com.crazy.article.task.UpdateVisitCountTask;
import com.crazy.core.util.DateHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shiyi
 * @version 1.0
 * @date 2020-3-21 19:43
 */
@WebListener
@Component
public class ContextListener implements ServletContextListener {

    Logger logger = LoggerFactory.getLogger(ContextListener.class);


    @Autowired
    private HistoryVisitService visitService;

    @Autowired
    private UpdateVisitCountTask task;

    Map<String, Integer> map = new ConcurrentHashMap<>();



    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("map = + 监听器启动" + map);
        ServletContext context = servletContextEvent.getServletContext();
        HistoryVisitEntity entity = visitService.queryByDay(DateHelper.today());
        Integer count = 0;
        if (entity != null) {
            count = entity.getCount();
        }
        map.put(DateHelper.today(), count);
        context.setAttribute("map", map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.error(" 系统正在销毁。。。。。。 ");
        task.task();
    }
}
