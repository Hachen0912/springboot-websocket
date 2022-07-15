/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Hang Cheng
 * @class GreetingController
 * @create 12.07.2022 10:24
 * @Copyright (c) All Rights Reserved, 2022.
 */
package com.example.springbootwebsocket.controller;

import com.example.springbootwebsocket.model.Greeting;
import com.example.springbootwebsocket.model.HelloMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

@Controller
@Slf4j
public class GreetingController {


    @GetMapping("/xxx")
    @ResponseBody
    public String xxxController(){
        return "hello world";
    }


    @ResponseBody
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {

        log.info("{} recevied",message);
//        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }

}
