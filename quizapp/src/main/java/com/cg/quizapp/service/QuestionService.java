package com.cg.quizapp.service;

import com.cg.quizapp.dao.QuestionDao;
import com.cg.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
          return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
         return questionDao.findAllByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "Success";
    }
}
