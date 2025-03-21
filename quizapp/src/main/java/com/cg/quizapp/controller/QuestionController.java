package com.cg.quizapp.controller;

import com.cg.quizapp.model.Question;
import com.cg.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allquestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
   public ResponseEntity<String> addQuestion(@RequestBody Question question){
     return  questionService.addQuestion(question);

   }

   @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
       return  questionService.deleteById(id);
   }

   @PutMapping("update")
    public ResponseEntity<String> update(@RequestBody Question question){
       return questionService.update(question);

   }
}
