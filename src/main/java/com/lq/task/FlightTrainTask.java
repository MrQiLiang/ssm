package com.lq.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**  定时任务
 * Created by qi_liang on 2018/3/21.
 */
@Component
public class FlightTrainTask {


    @Scheduled(cron = "0 15 02 * * ? ")
    public  void taskcyle(){
        System.out.println("===========执行定时任务=======");
    }


}
