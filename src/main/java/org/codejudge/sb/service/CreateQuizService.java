package org.codejudge.sb.service;

import org.codejudge.sb.Exceptions.FailureException;
import org.codejudge.sb.entities.Quiz;
import org.codejudge.sb.input.CreateQuizInput;
import org.codejudge.sb.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateQuizService {

    @Autowired
    private QuizRepository quizRepository;

    public Quiz createQuiz(CreateQuizInput input) throws FailureException {


        Quiz quiz = Quiz.builder().name(input.getName())
                .description(input.getDescription()).build();

        Quiz quizGenerated = quizRepository.save(quiz);

        if (quizGenerated == null) {
            throw FailureException.builder().status("failure").reason("database issue").build();
        }
        return quizGenerated;

    }

}
