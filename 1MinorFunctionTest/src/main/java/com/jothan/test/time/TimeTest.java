/**
 * Aistarfish.com Inc.
 * Copyright (c) 2017-2021 All Rights Reserved.
 */
package
		com.jothan.test.time;

import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

import com.jothan.test.time.util.DateUtils;

/**
 * @author LanAn_Lee
 * Created by on 2021-06-09 13:36
 */
public class TimeTest {

	private final static String     SEARCH_TYPE_ALL   = "all";
	public static void main(String[] args) {
		long l = DateUtils.twoDateBetweenDays(new Date(), new Date());
		System.out.println("l = " + l);

		Date date = DateUtils.addDay(-214, new Date());
		System.out.println("date = " +DateUtils.parseTime(date));

		String endDateString = "2020-10"+ "-01 00:00:00";
		System.out.println("endDateString = " + endDateString);
		Date newDate = DateUtils.formatDate(endDateString);
		System.out.println("newDate = " + newDate);
		Date date1 = DateUtils.addMonth(1, newDate);
		System.out.println("date1 = " + date1);
		AtomicReference<Boolean> isZYMini = new AtomicReference<>(Boolean.FALSE);
		isZYMini.set(true);
		System.out.println("isZYMini = " + isZYMini.get());

		String a = "11111111111";
		System.out.println("SEARCH_TYPE_ALL"+a);



	}
}
