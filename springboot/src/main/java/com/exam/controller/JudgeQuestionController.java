package com.exam.controller;

import com.exam.entity.JudgeQuestion;
import com.exam.serviceimpl.JudgeQuestionServiceImpl;
import com.exam.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JudgeQuestionController {

    @Autowired
    private JudgeQuestionServiceImpl judgeQuestionService;

    @PostMapping("/judgeQuestion")
    public Result add(@RequestBody JudgeQuestion judgeQuestion) {
        int res = judgeQuestionService.add(judgeQuestion);
        if (res != 0) {
            return Result.buildApiResult(200,"添加成功",res);
        }
        return Result.buildApiResult(400,"添加失败",res);
    }

    @GetMapping("/judgeQuestionId")
    public Result findOnlyQuestionId() {
        JudgeQuestion res = judgeQuestionService.findOnlyQuestionId();
        return  Result.buildApiResult(200,"查询成功",res);
    }
}
