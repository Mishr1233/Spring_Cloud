package com.cg.question_service.controller;


import com.cg.question_service.model.Question;
import com.cg.question_service.model.QuestionWrapper;
import com.cg.question_service.model.Response;
import com.cg.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    Environment environment;

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

   //generate
   @GetMapping("generate")
   public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestions){

       return questionService.getQuestionsForQuiz(categoryName,numQuestions);
   }

    //getQuestions(questionid)

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
        System.out.println(environment.getProperty("local.server.port"));
       return questionService.getQuestionsFromId(questionIds);
    }

    //getScore
    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }





}
