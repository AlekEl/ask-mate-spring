package com.codecool.askmate.Repositories;

import com.codecool.askmate.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBPostgres extends JpaRepository<Question,Long> {
}
