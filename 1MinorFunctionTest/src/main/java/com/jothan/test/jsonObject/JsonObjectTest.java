/**
 * Aistarfish.com Inc.
 * Copyright (c) 2017-2021 All Rights Reserved.
 */
package
		com.jothan.test.jsonObject;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * @author LanAn_Lee
 * Created by on 2021-06-09 14:40
 */
public class JsonObjectTest {

	public static void main(String[] args) {
		String s = "['true']";

		List<String> stringList = JSONObject.parseArray(s, String.class);
		System.out.println("stringList = " + stringList.contains("true"));
	}

}
