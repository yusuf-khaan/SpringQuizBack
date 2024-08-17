package com.doc.quizapp.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.doc.quizapp.model.Questions;
import com.doc.quizapp.model.noOfQs;
import com.doc.quizapp.serviceLayer.QuestionService;

@RestController
@RequestMapping("questions")
public class QuizController {

    @Autowired
    QuestionService questionService;

    @RequestMapping("AllQuestions")
    // @ResponseBody
    public List <Questions> getAllQuestion() {
        return questionService.getAllQuestion();
    }

    @RequestMapping("category/{category}")
    public List<Questions> questionsbycategory(@PathVariable String category) {
        return questionService.FindQuestionsbyCategory(category);
    }

    @PostMapping("add") 
    public String addQuestion(@RequestBody Questions question) {//@RequestBody here deserialize the json payload from client into class Question Matching Data types
        return questionService.addQuestion(question);
    }

    @DeleteMapping("delete")
    public String deletequestions(Integer id) {
        return questionService.deleteQuestion(id);
    }

    
    // @ResponseBody
    @PostMapping("startQuiz")
    public List<Questions> createQuiz ( Integer numberOfQuestions) {
        return questionService.createQuiz(numberOfQuestions);
    }

    @ResponseBody
    @PostMapping("startQuizz")
    public List<Questions> createQuizz (@RequestBody noOfQs numberOfQuestions) {
        return questionService.createQuiz(numberOfQuestions.getnumberOfQuestions());
    }
    
    // // @ResponseBody
    // @GetMapping("startQuiz")
    // public List<Questions> createQuiz (@RequestParam(defaultValue = "20") Integer numberOfQuestions) {
    //     return questionService.createQuiz(numberOfQuestions);
    // }
}
