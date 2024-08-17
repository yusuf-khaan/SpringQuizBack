package com.doc.quizapp.serviceLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.doc.quizapp.DAO.NukeDAO;
import com.doc.quizapp.DAO.QuestionDAO;
import com.doc.quizapp.model.Questions;
import com.doc.quizapp.model.ScheduleNukeDBS;
import com.doc.quizapp.model.banaoQuiz; 

@Service
public class NukeService {

    private banaoQuiz banaoQuiz;
    
    // @Autowired
    // Questions questions;

    @Autowired
    NukeDAO nukedao;

    ScheduleNukeDBS schedulenuke = new ScheduleNukeDBS();

    @Autowired
    QuestionDAO questionDAO;

    public String generateNuke(banaoQuiz requestasked) {

        System.out.println(requestasked.getCategory() + " dont forget me guys");
        System.out.println(requestasked.getNumberOfQuestions() + " dont forget me guys too");

        Pageable pageable = PageRequest.of(0, requestasked.getNumberOfQuestions());
        List<Questions> questions =  questionDAO.quizmaker(requestasked.getCategory(), pageable);
        

        schedulenuke.setTitle(requestasked.getTitle());
        schedulenuke.setQuestions(questions);

        nukedao.save(schedulenuke);


        return "successfully create quiz";
    }

    public List<ScheduleNukeDBS> findquestionByTitle(String title) {
        return nukedao.findByTits(title);
    }

    public List<Questions> quizTime(String Quiztitle) {

        System.out.println(Quiztitle);
        ScheduleNukeDBS schedule = nukedao.findBytitle(Quiztitle);
        System.out.println(schedule +" hey check schedule is alsl alive");
        List<Questions> questionForQuiz = schedule.getQuestions();

        return questionForQuiz;
    }
}