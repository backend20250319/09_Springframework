package com.jjh.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterceptorTestController {

    @GetMapping("/stopwatch")
    public String stopWatch () throws InterruptedException {
        System.out.println("Handler Method 호출 시점");
        Thread.sleep(1000);
        return  "result";
    }

}
