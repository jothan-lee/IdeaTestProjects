/**
 * Aistarfish.com Inc.
 * Copyright (c) 2017-2021 All Rights Reserved.
 */
package
		com.jothan.test.optional;

import java.util.Optional;

/**
 * @author LanAn_Lee
 * Created by on 2021-06-09 14:46
 */
public class OptionalTest {
	public static void main(String[] args) {
		//Integer a = 666;
		Integer a = null;
		Optional<Integer> op = null;
		Integer integer = op.orElse(000);
		System.out.println("integer = " + integer);
	}

}
