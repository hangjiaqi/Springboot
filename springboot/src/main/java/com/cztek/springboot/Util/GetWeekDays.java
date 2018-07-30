package com.cztek.springboot.Util;

import java.util.Calendar;
import java.util.Date;

public class GetWeekDays {
	public static int getWeekOfDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0) {
            w = 0;
        }
		return w;
	}
}
