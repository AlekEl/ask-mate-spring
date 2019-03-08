package com.codecool.askmate.Config;

import com.codecool.askmate.Repositories.DBQuestionRepository;
//import com.codecool.askmate.Repositories.HashMapQuestionRepository;
import com.codecool.askmate.Repositories.RepositoriesInterface.QuestionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

@Configuration
public class RepositoryConfig {

//    @Bean(name = "HashMapQuestionRepository")
//    @Profile("HashMap")
//    public QuestionRepository createHashMapQuestionRepository() {
//        QuestionRepository repository = new HashMapQuestionRepository();
//        return repository;
//    }

    @Bean(name = "H2Db")
    @Profile("DB")
    public JpaRepository createDBQuestionRepository() {
        JpaRepository repository = new DBQuestionRepository();
        return repository;
    }
}
