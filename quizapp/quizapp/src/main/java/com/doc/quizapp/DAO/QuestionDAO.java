package com.doc.quizapp.DAO;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.doc.quizapp.model.Questions;


@Repository
public interface QuestionDAO extends JpaRepository<Questions, Integer> {

    List<Questions> findBycategory(String category); // smart enough to find column category avai hawa hawai

    // @Modifying(clearAutomatically = true)
    @Query (value = "Select * from questions q where q.category = :category order by random()", nativeQuery= true)
    List<Questions> quizmaker (@Param("category") String category, Pageable pageable);

    // List<Questions> findByid(Integer id);


    // @Query("SELECT q FROM Question q")
    // List<Questions> findAll();
}
