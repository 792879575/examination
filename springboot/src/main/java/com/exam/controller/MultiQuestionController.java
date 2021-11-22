package com.exam.controller;

import com.exam.entity.MultiQuestion;
import com.exam.serviceimpl.MultiQuestionServiceImpl;
import com.exam.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiQuestionController {

    @Autowired
    private MultiQuestionServiceImpl multiQuestionService;

    @GetMapping("/multiQuestionId")
    public Result findOnlyQuestion() {
        MultiQuestion res = multiQuestionService.findOnlyQuestionId();
        return Result.buildApiResult(200,"查询成功",res);
    }

    @PostMapping("/MultiQuestion")
    public Result add(@RequestBody MultiQuestion multiQuestion) {
        int res = multiQuestionService.add(multiQuestion);
        if (res != 0) {

            return Result.buildApiResult(200,"添加成功",res);
        }
        return Result.buildApiResult(400,"添加失败",res);
    }
}
