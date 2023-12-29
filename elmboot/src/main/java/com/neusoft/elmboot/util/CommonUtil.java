package com.neusoft.elmboot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {

	public static String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
		String dataStr = formatter.format(date);
		return dataStr;
	}

}
