package cn.evendy.groupon.util;

import java.util.Calendar;

import cn.evendy.groupon.constans.Constants;

/**
 * @author: evendy
 * @time: 2015/5/19 23:05
 * @mail: 244085027@qq.com
 */
public class TimeUtils {
    private TimeUtils() {
        throw new RuntimeException("cannot init TimeUtils");
    }

    public static long getCountdownTime() {
        Calendar nowTime = Calendar.getInstance();
        long nowTimeSecond = nowTime.get(Calendar.HOUR_OF_DAY) * 60 * 60 + nowTime.get(Calendar.MINUTE) * 60 + nowTime.get(Calendar.SECOND);

        long lastTime;
        if (Constants.CLOCK_FEATURED > nowTimeSecond) {
            lastTime = Constants.CLOCK_FEATURED - nowTimeSecond;
        } else {
            lastTime = Constants.CLOCK_TWENTY_FOUR - nowTimeSecond + Constants.CLOCK_FEATURED;
        }
        return lastTime;
    }
}
