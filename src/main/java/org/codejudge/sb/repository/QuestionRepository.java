package org.codejudge.sb.repository;

import org.codejudge.sb.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    public Question findById(int id);

    public List<Question> findByQuiz(int quiz);

}
