package org.codejudge.sb.service;

import org.codejudge.sb.Exceptions.RecordNotFoundException;
import org.codejudge.sb.entities.Question;
import org.codejudge.sb.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetQuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question getQuestion(int id) throws Exception {

        Question question = questionRepository.findById(id);

        if (question == null) {
            throw RecordNotFoundException.builder().status("failure").reason("question does not exist with given id").build();
        }

        return question;
    }

    public List<Question> getAllQuestionsByQuizId(int quizId) {
        return questionRepository.findByQuiz(quizId);
    }
}
