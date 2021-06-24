/**
 * Aistarfish.com Inc.
 * Copyright (c) 2017-2021 All Rights Reserved.
 */
package
		com.jothan.test.time;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.jothan.test.time.util.DateUtils;

import org.springframework.util.CollectionUtils;

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

		String endDateString = "2020-10"+ "-05 00:38:00";
		System.out.println("endDateString = " + endDateString);
		Date newDate = DateUtils.formatTime(endDateString);
		System.out.println("newDate = " + newDate);
		Date minScopeDate = DateUtils.addDay(2, DateUtils.formatTime(endDateString));
		System.out.println("minScopeDate = " + DateUtils.parseTime(minScopeDate));
		Date date1 = DateUtils.addMonth(1, newDate);
		System.out.println("date1 = " + date1);
		AtomicReference<Boolean> isZYMini = new AtomicReference<>(Boolean.FALSE);
		isZYMini.set(true);
		System.out.println("isZYMini = " + isZYMini.get());

		String a = "11111111111";
		System.out.println("SEARCH_TYPE_ALL"+a);
		ArrayList<String> list = new ArrayList<>();
		list.add("222");
		list.add("33333");
		System.out.println(list);
		String str = String.join(",", list);
		System.out.println("str = " + str);

		String s = "[\"https://sf-spectre.sh1a.qingstor.com/org/logod0421c5ee0854ab5b6fd67be6495c095.png\"]";
		java.util.List<String> out = JSON.parseObject(s,
		                                              new TypeReference<List<String>>() {
		                                              });
		System.out.println(out.get(0));
		JSONArray objects = JSONObject.parseArray(s);
		System.out.println("lists = " + objects);


		List<String> strings = Arrays.asList("2018-04-17 08:10:02", "2019-04-19 08:10:02", "2018-04-30 08:10:02",
		                                     "2018-04-30 08:10:03", "2018-04-10 08:10:03");

		List<Date> dates = Arrays.asList(new Date(),new Date(),new Date());
		System.out.println("dates = " + dates);
		Date max = Collections.max(dates);
		System.out.println("max = " + max);


	}
}
