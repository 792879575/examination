package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Student;
import com.exam.serviceimpl.StudentServiceImpl;
import com.exam.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "学生管理")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @ApiOperation(value = "查询所有学生")
    @GetMapping("/students/{page}/{size}")
    public Result findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Student> studentPage = new Page<>(page,size);
        IPage<Student> res = studentService.findAll(studentPage);
        return  Result.buildApiResult(200,"分页查询所有学生",res);
    }

    @ApiOperation(value = "根据ID查询学生")
    @GetMapping("/student/{studentId}")
    public Result findById(@PathVariable("studentId") Integer studentId) {
        Student res = studentService.findById(studentId);
        if (res != null) {
        return Result.buildApiResult(200,"请求成功",res);
        } else {
            return Result.buildApiResult(404,"查询的用户不存在",null);
        }
    }

    @ApiOperation("根据ID删除学生")
    @DeleteMapping("/student/{studentId}")
    public Result deleteById(@PathVariable("studentId") Integer studentId) {
        return Result.buildApiResult(200,"删除成功",studentService.deleteById(studentId));
    }

    @ApiOperation("更新密码")
    @PutMapping("/studentPWD")
    public Result updatePwd(@RequestBody Student student) {
        studentService.updatePwd(student);
        return Result.buildApiResult(200,"密码更新成功",null);
    }

    @ApiOperation("更新学生信息")
    @PutMapping("/student")
    public Result update(@RequestBody Student student) {
        int res = studentService.update(student);
        if (res != 0) {
            return Result.buildApiResult(200,"更新成功",res);
        }
        return Result.buildApiResult(400,"更新失败",res);
    }


    @ApiOperation("添加学生")
    @PostMapping("/student")
    public Result add(@RequestBody Student student) {
        int res = studentService.add(student);
        if (res == 1) {
            return Result.buildApiResult(200,"添加成功",null);
        }else {
            return Result.buildApiResult(400,"添加失败",null);
        }
    }
}
