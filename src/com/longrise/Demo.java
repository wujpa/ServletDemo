package com.longrise;

import util.JDUtil;

public class Demo {
    public static void main(String[] args) {
        String sql = "select * from student";
        JDUtil.query(sql,null);
    }
}
