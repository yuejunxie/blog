package com.drawinds.blog.source.aop.proxy.cglib;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/23 19:33
 * Description:
 */
public class PersonService {

    private String name = "Jack";

    public PersonService() {
    }

    public PersonService(String name) {
        this.name = name;
    }

    public String sayHello() {
        String s = "Hello" + name;
        System.out.println(s);
        return s;
    }

    public final String sayOther(String name) {
        return "Hello Other" + name;
    }

}
