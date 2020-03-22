package com.crazy.article.task;

import com.crazy.article.service.HistoryVisitService;
import com.crazy.core.util.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.util.Map;

/**
 * @author shiyi
 * @version 1.0
 * @date 2020-3-22 11:25
 */
@Component
public class UpdateVisitCountTask {

    @Autowired
    private ServletContext context;

    @Autowired
    private HistoryVisitService visitService;

    /*@SuppressWarnings("unchecked")
    @Async
    @Scheduled(cron = "0 58 0,5,10,15,20,23 * * ?")
    public void task() {
        String today = DateHelper.today();
        Map<String, Integer> map = (Map<String, Integer>) context.getAttribute("visitsMap");
        if (map != null) {
            Integer integer = map.get(today);
            visitService.saveOrUpdateEntity(today, integer);
        }
    }*/
}
