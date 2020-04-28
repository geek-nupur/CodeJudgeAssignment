package org.codejudge.sb.controller;

import io.swagger.annotations.ApiOperation;
import org.codejudge.sb.Exceptions.FailureException;
import org.codejudge.sb.Exceptions.RecordNotFoundException;
import org.codejudge.sb.entities.Question;
import org.codejudge.sb.entities.Quiz;
import org.codejudge.sb.input.CreateQuestionInput;
import org.codejudge.sb.input.CreateQuizInput;
import org.codejudge.sb.output.GetAllQuestionsForQuizOutput;
import org.codejudge.sb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/api")
public class AppController {

    @ApiOperation("This is the hello world api")
    @GetMapping("/")
    public String hello() {
        return "Hello World!!";
    }


    @Autowired
    CreateQuizService createQuizService;

    @Autowired
    GetQuizService getQuizService;

    @Autowired
    CreateQuestionService createQuestionService;

    @Autowired
    GetQuestionService getQuestionService;

    @Autowired
    GetAllQuestionsService getAllQuestionsService;

    @RequestMapping(method = RequestMethod.POST, value = "/quiz")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Quiz createQuiz(@RequestBody CreateQuizInput input, HttpServletResponse httpServletResponse)
            throws FailureException {
        return createQuizService.createQuiz(input);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/quiz/{quiz_id}")
    public Quiz getQuiz(@PathVariable("quiz_id") int id) throws RecordNotFoundException {
        return getQuizService.getQuiz(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/questions")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Question createQuestion(@RequestBody CreateQuestionInput input) throws Exception {
        return createQuestionService.createQuestion(input);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/questions/{question_id}")
//    @ResponseStatus(value = HttpStatus.CREATED)
    public Question getQuestion(@PathVariable("question_id") int id) throws Exception {
        return getQuestionService.getQuestion(id);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/quiz-questions/{quiz_id}")
    public GetAllQuestionsForQuizOutput getAllQuestionsForQuizOutput(@PathVariable("quiz_id") int id) throws Exception {

        return getAllQuestionsService.getAllQuestionsForQuiz(id);
    }

}
