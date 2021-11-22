package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Teacher;
import com.exam.serviceimpl.TeacherServiceImpl;
import com.exam.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {

    private TeacherServiceImpl teacherService;
    @Autowired
    public TeacherController(TeacherServiceImpl teacherService){
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers/{page}/{size}")
    public Result findAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<Teacher> teacherPage = new Page<>(page,size);
        IPage<Teacher> teacherIPage = teacherService.findAll(teacherPage);

        return Result.buildApiResult(200,"查询所有教师",teacherIPage);
    }

    @GetMapping("/teacher/{teacherId}")
    public Result findById(@PathVariable("teacherId") Integer teacherId){
        return Result.success(teacherService.findById(teacherId));
    }

    @DeleteMapping("/teacher/{teacherId}")
    public Result deleteById(@PathVariable("teacherId") Integer teacherId){
        return Result.success(teacherService.deleteById(teacherId));
    }

    @PutMapping("/teacher")
    public Result update(@RequestBody Teacher teacher){
        return Result.success(teacherService.update(teacher));
    }

    @PostMapping("/teacher")
    public Result add(@RequestBody Teacher teacher){
        return Result.success(teacherService.add(teacher));
    }
}
