package org.codejudge.sb.service;

import org.codejudge.sb.Exceptions.FailureException;
import org.codejudge.sb.entities.Question;
import org.codejudge.sb.entities.Quiz;
import org.codejudge.sb.input.CreateQuestionInput;
import org.codejudge.sb.input.CreateQuizInput;
import org.codejudge.sb.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateQuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private GetQuizService getQuizService;

    public Question createQuestion(CreateQuestionInput input) throws Exception {

        boolean quizExists = getQuizService.doesQuizExist(input.getQuiz());

        if (!quizExists) {
            throw new Exception();
        }

        Question question = Question.builder().name(input.getName())
                .options(input.getOptions())
                .correctOption(input.getCorrectOption())
                .points(input.getPoints())
                .quiz(input.getQuiz()).build();
//        questionRepository.findAll()
        Question questionCreated = questionRepository.save(question);

        if (questionCreated == null) {
            throw FailureException.builder().status("failure").reason("database issue").build();
        }

        return questionCreated;
    }


}
