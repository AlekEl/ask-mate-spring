package com.codecool.askmate.Repositories;

import com.codecool.askmate.Model.Question;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public interface DBPostgres extends JpaRepository<Question,Integer> {

    @Modifying
    @Query("delete from Answer u where u.id in ?1")
    void odeleteAnswerWithIds(List<Integer> ids);

}
