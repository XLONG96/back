package com.qa.service;

import com.qa.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Page getQuestionList(Pageable pageable){
        return questionRepository.findAll(pageable);
    }
}
