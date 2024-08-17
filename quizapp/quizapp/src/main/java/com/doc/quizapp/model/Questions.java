package com.doc.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "questions")
public class Questions {

    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String category;

    private String difficultylevel;

    

    private String option1;
    private String option2;
    private String option3;

    private String questiontitle;

    private String rightanswer;

    public void setid(Integer id) {
        this.id = id;
    }

    public Integer getid() {
        return id;
    }

    public void setcategory(String category) {
        this.category = category;
    }

    public String getcategory() {
        return category;
    }

    public void setdifficultylevel(String difficultylevel) {
        this.difficultylevel = difficultylevel;
    }

    public String getdifficultylevel() {
        return difficultylevel;
    }

    public void setquestiontitle(String questiontitle) {
        this.questiontitle = questiontitle;
    }

    public String getquestiontitle() {
        return questiontitle;
    }

    public void setoption1(String option1) {
        this.option1 = option1;
    }

    public String getoption1() {
        return option1;
    }

    public void setoption2(String option2) {
        this.option2 = option2;
    }

    public String getoption2() {
        return option2;
    }

    public void setoption3(String option3) {
        this.option3 = option3;
    }

    public String getoption3() {
        return option3;
    }

    public void setrightanswer(String rightanswer) {
        this.rightanswer = rightanswer;
    }

    public String getrightanswer() {
        return rightanswer;
    }
}
