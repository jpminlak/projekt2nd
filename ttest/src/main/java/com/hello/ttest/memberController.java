package com.hello.ttest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class memberController {

    @GetMapping("/indexm")
    public String index() {
        return "indexm";
    }
    
    
}
