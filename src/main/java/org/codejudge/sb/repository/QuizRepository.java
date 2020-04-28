package org.codejudge.sb.repository;

import org.codejudge.sb.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

    public Quiz findById(int id);
}
