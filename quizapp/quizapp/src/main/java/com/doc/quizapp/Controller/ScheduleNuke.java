package com.doc.quizapp.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doc.quizapp.model.Questions;
import com.doc.quizapp.model.ScheduleNukeDBS;
import com.doc.quizapp.model.banaoQuiz;
import com.doc.quizapp.serviceLayer.NukeService;


@RequestMapping("Schedule")
@RestController
public class ScheduleNuke {

    @Autowired
    NukeService nukeService;

    @RequestMapping(value = "NukeTime", method=RequestMethod.POST)
    public String generateNuke(@RequestBody banaoQuiz requestasked) {
        System.out.println(requestasked.toString());
        return nukeService.generateNuke(requestasked);
    }

@RequestMapping("Start")
public List<ScheduleNukeDBS> startQuiz(@RequestBody String title) {
    return nukeService.findquestionByTitle(title);
}

@PostMapping("quizTime")
public List<Questions> quizTime(@RequestBody String title) {
    System.out.println(title);
    // return nukeService.quizTime(title);
    return nukeService.quizTime(title);
}
}