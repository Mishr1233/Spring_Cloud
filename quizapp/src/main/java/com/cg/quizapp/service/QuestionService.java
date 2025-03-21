package com.cg.quizapp.service;

import com.cg.quizapp.dao.QuestionDao;
import com.cg.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
         try {
             return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
         } catch (Exception e) {
            e.printStackTrace();
         }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findAllByCategory(category),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("failed",HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> deleteById(int id) {
        try {
            questionDao.deleteById(id);
            return new ResponseEntity<>("Success",HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("failed",HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> update(Question question) {
        try {
            questionDao.save(question); // If ID exists, it updates; otherwise, it inserts.
            return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }
    }
}
