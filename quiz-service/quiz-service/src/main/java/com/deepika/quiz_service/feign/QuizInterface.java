package com.deepika.quiz_service.feign;


import com.deepika.quiz_service.entity.QuestionWrapper;
import com.deepika.quiz_service.entity.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("Question/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String categoryName , @RequestParam Integer numQuestions);



    @PostMapping("Question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);


    ;

    @PostMapping("Question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);

}
