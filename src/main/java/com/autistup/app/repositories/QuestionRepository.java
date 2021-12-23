package com.autistup.app.repositories;

import com.autistup.app.entities.Parent;
import com.autistup.app.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    public List<Question> findAllByForumId(Long id);
}
