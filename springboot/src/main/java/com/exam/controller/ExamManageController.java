package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ExamManage;
import com.exam.serviceimpl.ExamManageServiceImpl;
import com.exam.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExamManageController {

    @Autowired
    private ExamManageServiceImpl examManageService;

    @GetMapping("/exams")
    public Result findAll(){
        System.out.println("不分页查询所有试卷");
        com.exam.entity.Result result;
        result = Result.buildApiResult(200, "请求成功！", examManageService.findAll());
        return result;
    }

    @GetMapping("/exams/{page}/{size}")
    public Result findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        System.out.println("分页查询所有试卷");
        com.exam.entity.Result result;
        Page<ExamManage> examManage = new Page<>(page,size);
        IPage<ExamManage> all = examManageService.findAll(examManage);
        result = Result.buildApiResult(200, "请求成功！", all);
        return result;
    }

    @GetMapping("/exam/{examCode}")
    public Result findById(@PathVariable("examCode") Integer examCode){
        System.out.println("根据ID查找");
        ExamManage res = examManageService.findById(examCode);
        if(res == null) {
            return Result.buildApiResult(10000,"考试编号不存在",null);
        }
        return Result.buildApiResult(200,"请求成功！",res);
    }

    @DeleteMapping("/exam/{examCode}")
    public Result deleteById(@PathVariable("examCode") Integer examCode){
        int res = examManageService.delete(examCode);
        return Result.buildApiResult(200,"删除成功",res);
    }

    @PutMapping("/exam")
    public Result update(@RequestBody ExamManage exammanage){
        int res = examManageService.update(exammanage);
//        if (res == 0) {
//            return Result.buildApiResult(20000,"请求参数错误");
//        }
        System.out.print("更新操作执行---");
        return Result.buildApiResult(200,"更新成功",res);
    }

    @PostMapping("/exam")
    public Result add(@RequestBody ExamManage exammanage){
        int res = examManageService.add(exammanage);
        if (res ==1) {
            return Result.buildApiResult(200, "添加成功", res);
        } else {
            return  Result.buildApiResult(400,"添加失败",res);
        }
    }

    @GetMapping("/examManagePaperId")
    public Result findOnlyPaperId() {
        ExamManage res = examManageService.findOnlyPaperId();
        if (res != null) {
            return Result.buildApiResult(200,"请求成功",res);
        }
        return Result.buildApiResult(400,"请求失败",res);
    }
}
