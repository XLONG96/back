package com.qa.controller;

import com.qa.service.CustomUserDetailsService;
import com.qa.service.QuestionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QuestionController {
    private static final Logger logger = Logger.getLogger(QuestionController.class);

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value="/ques",method= RequestMethod.POST)
    public Page getQuestions(@RequestParam(value = "start", defaultValue = "0") Integer start,
                             @RequestParam(value = "length", defaultValue = "10") Integer size,
                             @RequestParam("draw") int draw){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Integer page = start/size;
        Pageable pageable = new PageRequest(page, size, sort);

        logger.info("XXX draw/start/size is "+draw+"/"+page+"/"+size);
        logger.info("XXX start/size is "+pageable.getPageNumber()+"/"+pageable.getPageSize());

        return questionService.getQuestionList(pageable);
    }
}
