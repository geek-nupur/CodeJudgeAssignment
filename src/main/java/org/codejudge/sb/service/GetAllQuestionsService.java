package org.codejudge.sb.service;

import org.codejudge.sb.Exceptions.RecordNotFoundException;
import org.codejudge.sb.entities.Question;
import org.codejudge.sb.entities.Quiz;
import org.codejudge.sb.output.GetAllQuestionsForQuizOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllQuestionsService {

    @Autowired
    private GetQuestionService getQuestionService;

    @Autowired
    private GetQuizService getQuizService;


    public GetAllQuestionsForQuizOutput getAllQuestionsForQuiz(int quizId) throws RecordNotFoundException {

        boolean quizExists = getQuizService.doesQuizExist(quizId);
        if (!quizExists) {
            throw RecordNotFoundException.builder().build();
        }

        Quiz quiz = getQuizService.getQuiz(quizId);

        List<Question> questions = getQuestionService.getAllQuestionsByQuizId(quizId);

        GetAllQuestionsForQuizOutput output = GetAllQuestionsForQuizOutput.builder().name(quiz.getName())
                .description(quiz.getDescription())
                .questions(questions).build();

        return output;

    }
}
