package cn.mytrip.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class MyTask {
    @Scheduled(cron = "0 38 10 * * ?")
    public static void show(){
        Date date = new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str=format.format(date);
        System.out.println("job at :"+str);
    }
}
