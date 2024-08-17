package com.doc.quizapp.serviceLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doc.quizapp.DAO.QuestionDAO;
import com.doc.quizapp.model.Questions;
import com.doc.quizapp.model.noOfQs;

@Service
public class QuestionService {
        // private static final Logger LOGGER = LoggerFactory.getLogger(QuestionService.class);

    // @Autowired
    // public QuestionService(QuestionDAO questionDAO) {
    //     LOGGER.info("Creating QuestionService instance");
    //     this.questionDAO = questionDAO;
    // }

    // QuestionDAO Questiondao = new QuestionDAO(); you cant do this as this is interface, it cant be instantiated

    // @Autowired
    // public Questions question;

    Random rand = new Random();

    @Autowired
    public QuestionDAO questionDAO;

    public List<Questions> getAllQuestion() {
              
        return questionDAO.findAll();
    }

    public List<Questions> FindQuestionsbyCategory(String Category) {
        return questionDAO.findBycategory(Category);
    }

    @ResponseBody
    public String addQuestion(Questions questions) {
        questionDAO.save(questions);
        // List<Questions> list = new ArrayList<>();
        // list.add(questions);
        return "success";
    }

    @ResponseBody
    public String deleteQuestion(Integer id) {

        try {
        Questions question = (Questions) questionDAO.findById(id).orElseThrow();
        questionDAO.delete(question);
        }
        catch (Exception e) {
            return "Error" + e.getMessage();
        }

        // questionDAO.deleteById(id);
        return "successfully deleted";
    }

    @ResponseBody
public List<Questions> createQuiz(Integer noOfQuestionsService) {
    noOfQuestionsService = 5;
    
    List<Questions> listofQuestions = new ArrayList<>();
    List<Integer> records = new ArrayList<>();
    
    // Populate the records list with some values
    // for (int j = 0; j < 50; j++) {
    //     records.add(j);
    // }

    // HashSet<Integer> set = new HashSet<>();
    
    
    int i = 0;
    while (noOfQuestionsService > 0) {
        int randomIndex = rand.nextInt(50);

        if (!listofQuestions.contains(questionDAO.findById(randomIndex).orElse(new Questions()))) {
            Questions question = questionDAO.findById(randomIndex).orElse(new Questions());
            listofQuestions.add(question);
            noOfQuestionsService--;
        }
        i++;
    }
    return listofQuestions;
}

    // @ResponseBody
    // public List<Questions> createQuiz(Integer noOfQuestionsService) {
    //     noOfQuestionsService = 5;
        
    //     List <Questions> listofQuestions = new ArrayList<>();
    //     List<Integer> records = new ArrayList<>();
    //     int i = 1;
    //     while(noOfQuestionsService > 0) {
    //         if((!records.contains(rand.nextInt(50)))) {
    //             Questions question = (Questions) questionDAO.findById(records.get(i++)).orElse(new Questions());
    //             listofQuestions.add(question);
    //             noOfQuestionsService--;
    //         }
    //     }
    //     return listofQuestions;
    // }


}
