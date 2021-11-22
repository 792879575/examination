package com.exam.controller;

import com.exam.entity.FillQuestion;
import com.exam.serviceimpl.FillQuestionServiceImpl;
import com.exam.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FillQuestionController {

    @Autowired
    private FillQuestionServiceImpl fillQuestionService;

    @PostMapping("/fillQuestion")
    public Result add(@RequestBody FillQuestion fillQuestion) {
        int res = fillQuestionService.add(fillQuestion);
        if (res != 0) {
            return Result.buildApiResult(200,"添加成功",res);
        }
        return Result.buildApiResult(400,"添加失败",res);
    }

    @GetMapping("/fillQuestionId")
    public Result findOnlyQuestionId() {
        FillQuestion res = fillQuestionService.findOnlyQuestionId();
        return Result.buildApiResult(200,"查询成功",res);
}
}
