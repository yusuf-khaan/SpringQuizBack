package com.doc.quizapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class indexrun {
    
    @RequestMapping("/index")
    public String getindex() {
        return "index.html";
    }
}
