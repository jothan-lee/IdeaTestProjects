/**
 * Aistarfish.com Inc.
 * Copyright (c) 2017-2021 All Rights Reserved.
 */
package
		com.jothan.test.time;

import java.util.Date;

import com.jothan.test.time.util.DateUtils;

/**
 * @author LanAn_Lee
 * Created by on 2021-06-09 13:36
 */
public class TimeTest {

	public static void main(String[] args) {
		long l = DateUtils.twoDateBetweenDays(new Date(), new Date());
		System.out.println("l = " + l);

		Date date = DateUtils.addDay(-214, new Date());
		System.out.println("date = " +DateUtils.parseTime(date));

	}
}
