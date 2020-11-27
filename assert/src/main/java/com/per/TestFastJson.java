package com.per;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;

/**
 * @Description: TODO 练习断言(没有成功的项目)
 * @Author: lys
 * @Date: 2020-11-06 13:46
 * @Version: 1.3.*
 */
public class TestFastJson {


    public static void main(String[] args) {
        Model model = new Model();
        model.setName("李园松");
        model.setPassword("0987");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        model.setList(list);
        model.setNoName(new NoName("秦威",666));
        System.out.println("model = " + model);
        //model = Model(name=李园松, password=0987, list=[1, 2], noName=NoName(img=秦威, num=666))

        //////////////////////////////javaBean转字符串，json////////////////////////////////////////////
        //javabean转字符串
        String str = JSONObject.toJSONString(model);
        System.out.println("str = " + str);
        //str = {"list":[1,2],"name":"李园松","noName":{"img":"秦威","num":666},"password":"0987"}

        //javabean转json
        JSONObject o1 = (JSONObject)JSONObject.toJSON(model);
        System.out.println("o1 = " + o1);
        //o1 = {"password":"0987","name":"李园松","noName":{"img":"秦威","num":666},"list":[1,2]}

        //////////////////////////////字符串转javaBean，json////////////////////////////////////////////
        //字符串转Javabean
        Model o = JSONObject.parseObject(str, Model.class);
        System.out.println("o = " + o);
        //o = Model(name=李园松, password=0987, list=[1, 2], noName=NoName(img=秦威, num=666))

        //字符串转json
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println("jsonObject = " + jsonObject);
        //jsonObject = {"password":"0987","name":"李园松","noName":{"img":"秦威","num":666},"list":[1,2]}

        //////////////////////////////json转javaBean，字符串////////////////////////////////////////////
        //json转javaBean
        Model model1 = JSONObject.toJavaObject(jsonObject, Model.class);
        System.out.println("model1 = " + model1);
        //model1 = Model(name=李园松, password=0987, list=[1, 2], noName=NoName(img=秦威, num=666))

        //json转字符串
        String s = JSONObject.toJSONString(jsonObject);
        System.out.println("s = " + s);
        //s = {"password":"0987","name":"李园松","noName":{"img":"秦威","num":666},"list":[1,2]}

        //或者

        String s1 = JSONObject.toJavaObject(jsonObject, String.class);
        System.out.println("s1 = " + s1);
        //s1 = {"password":"0987","name":"李园松","noName":{"img":"秦威","num":666},"list":[1,2]}


    }
}
