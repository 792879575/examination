package com.exam.controller;

import com.exam.entity.Replay;
import com.exam.serviceimpl.ReplayServiceImpl;
import com.exam.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReplayController {

    @Autowired
    private ReplayServiceImpl replayService;

    @PostMapping("/replay")
    public Result add(@RequestBody Replay replay) {
        int data = replayService.add(replay);
        if (data != 0) {
            return Result.buildApiResult(200,"添加成功！",data);
        } else {
            return Result.buildApiResult(400,"添加失败！",null);
        }
    }

    @GetMapping("/replay/{messageId}")
    public Result findAllById(@PathVariable("messageId") Integer messageId) {
        List<Replay> res = replayService.findAllById(messageId);
        return Result.buildApiResult(200,"根据messageId查询",res);
    }
}
