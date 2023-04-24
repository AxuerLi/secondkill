package com.xdu.secondkill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : ruixueli
 * @date : 2023/4/24 8:05
 * @modyified By :
 */

@Controller
@RequestMapping("/demo")
public class DemoController {

    /**
     * 功能：测试
     * 当用户访问路径为"/demo/hello"时
     * 该控制器的hello方法将被调用.并返回名为"hello"的视图
     * 同时将名为"name"、值为"rxli"的属性传递给该视图。
     */
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","rxliiiii");
        return "hello";
    }
}