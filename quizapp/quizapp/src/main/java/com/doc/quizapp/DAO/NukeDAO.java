package com.doc.quizapp.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.doc.quizapp.model.ScheduleNukeDBS;
// import jakarta.persistence.Query;

@Repository
public interface NukeDAO extends JpaRepository<ScheduleNukeDBS, Integer> {

    @Query(value = "select *  from ScheduleNukeDBS where Title = :title ", nativeQuery = true)
    public List<ScheduleNukeDBS> findByTits (@Param("title") String title);

    @Query(value = "Select * from schedulenukedbs WHERE title = :Quiztitle Limit 1", nativeQuery = true)
    public ScheduleNukeDBS findBytitle (@Param("Quiztitle") String Quiztitle);

    // List<ScheduleNukeDBS> findByTitle (String title);

    // @Query(value = "SELECT * FROM questions q WHERE q.category = ':category' ORDER BY RANDOM() LIMIT = :num", nativeQuery = true)
    // List<Questions> quizmaker(String category, Integer num);
}
