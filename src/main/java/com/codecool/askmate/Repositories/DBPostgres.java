package com.codecool.askmate.Repositories;

import com.codecool.askmate.Model.AuditionModel;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@Repository
@Primary
public interface DBPostgres extends JpaRepository<AuditionModel,Integer> {

    @Modifying
    @Query("delete from Answer u where u.id in ?1")
    void odeleteAnswerWithIds(Integer ids);


}
