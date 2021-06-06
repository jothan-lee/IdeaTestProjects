/**
 * Aistarfish.com Inc.
 * Copyright (c) 2017-2021 All Rights Reserved.
 */
package
		com.jothan.test.fieldname;

import com.jothan.test.fieldname.entity.Payment;
import com.jothan.test.fieldname.util.ObjectFieldutil;

/**
 * @author LanAn_Lee
 * Created by on 2021-05-27 23:19
 */
public class testMain {
	public static void main(String[] args) throws IllegalAccessException {
		Payment payment = new Payment();
		ObjectFieldutil.setValues("serial", "我就是个测试值", payment);
		System.out.println("此处是根据属性名来给属性名赋值的方法payment = " + payment);
		Object o = ObjectFieldutil.getValues("serial", payment);
		System.out.println("根据属性名得到属性名的值的方法o = " + o.toString());

	}

}
