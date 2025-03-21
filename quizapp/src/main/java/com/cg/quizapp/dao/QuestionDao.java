package com.cg.quizapp.dao;

import com.cg.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> findAllByCategory(String category);

//    @Query(value = "SELECT*FROM question q where q.category:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
//    List<Question> findRandomQuestionsByCategory(String category, int numQ);

    @Query(value = "SELECT * FROM question WHERE category = ?1 ORDER BY RANDOM() LIMIT ?2", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int limit);

}
