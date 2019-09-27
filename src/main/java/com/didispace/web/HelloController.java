package com.didispace.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World\n";
    }


    @RequestMapping(value ="/time/message/{index}")
    public String getTime(@PathVariable int index) {
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        String time = index + ", 现在时间：" + sdf.format(date)+"\n";
        return time;
    }
}
