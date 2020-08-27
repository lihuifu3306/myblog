package com.crazy.article.task;

import com.crazy.article.entity.FriendBirthdayEntity;
import com.crazy.article.service.FriendBirthdayService;
import com.crazy.article.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiyi
 * @version 1.0
 * @date 2020-7-18 17:14
 */
@Component
public class BirthdayTask {

    @Autowired
    private IMailService iMailService;

    @Autowired
    private FriendBirthdayService birthdayService;

    @Scheduled(cron = "0 15 10 ? * *")
    public void task() {
        List<FriendBirthdayEntity> entities = birthdayService.queryBirthday();
        Calendar calendar = Calendar.getInstance();

        if (entities != null && entities.size() > 0) {
            for (FriendBirthdayEntity entity : entities) {
                int dayDif = getDayDif(entity, calendar);
                if (dayDif >= 0) {
                    Map<String, Integer> map = getYear(entity, calendar);
                    iMailService.sendSimpleMail("1282760680@qq.com", "生日提醒", "您的好友" + entity.getName() +
                            "的生日还有" + dayDif +"天,他的出生日期是" + entity.getBirthday()+ "今年是他" + map.get("year") + "岁生日，他的生日是本月" + map.get("day") + "号");
                }
            }
        }
    }

    private Map<String, Integer> getYear(FriendBirthdayEntity entity, Calendar calendar) {
        Map<String, Integer> map = new HashMap<>();
        Calendar fCalendar = Calendar.getInstance();
        fCalendar.setTime(entity.getBirthday());
        int year = calendar.get(Calendar.YEAR);
        int difYear = year - fCalendar.get(Calendar.YEAR);
        int day = fCalendar.get(Calendar.DATE);
        map.put("year", difYear);
        map.put("day", day);
        return map;

    }

    private int getDayDif(FriendBirthdayEntity entity, Calendar calendar) {
 /*
                1。获取当前日期的年月日

                 */
        int year = calendar.get(Calendar.YEAR);

        Calendar fCalendar = Calendar.getInstance();
        fCalendar.setTime(entity.getBirthday());

        fCalendar.set(Calendar.YEAR, year);

        long l = (fCalendar.getTime().getTime() - calendar.getTime().getTime())/ (60*60*24*1000);

        if (l > 0 && l <= 7) {
            return (int) l;
        }
        return -1;
    }


}
