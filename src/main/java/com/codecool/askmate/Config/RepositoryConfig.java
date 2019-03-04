package com.codecool.askmate.Config;

import com.codecool.askmate.Repositories.DBQuestionRepository;
import com.codecool.askmate.Repositories.HashMapQuestionRepository;
import com.codecool.askmate.Repositories.RepositoriesInterface.QuestionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RepositoryConfig {

    @Bean(name = "HashMapQuestionRepository")
    @Profile("HashMap")
    public QuestionRepository createHashMapQuestionRepository(){
        QuestionRepository repository = new HashMapQuestionRepository();
        return repository;
    }

    @Bean(name = "DBQuestionRepository")
    @Profile("DB")
    public QuestionRepository createDBQuestionRepository(){
        QuestionRepository repository = new DBQuestionRepository();
        return repository;
    }
}
