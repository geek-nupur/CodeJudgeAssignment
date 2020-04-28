package org.codejudge.sb.service;

import antlr.RecognitionException;
import org.codejudge.sb.Exceptions.FailureException;
import org.codejudge.sb.Exceptions.RecordNotFoundException;
import org.codejudge.sb.entities.Quiz;
import org.codejudge.sb.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetQuizService {

    @Autowired
    private QuizRepository quizRepository;

    public Quiz getQuiz(int id) throws RecordNotFoundException {

        Quiz quiz = quizRepository.findById(id);

        if (quiz == null) {
            throw RecordNotFoundException.builder().status("failure").reason("quiz id not found").build();
        }

        return quiz;
    }

    public boolean doesQuizExist(int id) {
        Quiz quiz = quizRepository.findById(id);
        if (quiz == null) {
            return false;
        }
        return true;
    }
}
