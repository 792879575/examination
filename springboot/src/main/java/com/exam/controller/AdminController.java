package com.exam.controller;

import com.exam.entity.Admin;
import com.exam.entity.Result;
import com.exam.serviceimpl.AdminServiceImpl;
import com.exam.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("管理员模块")
@RequestMapping(value = "admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @ApiOperation("查询全部管理员")
    @GetMapping("all")
    public Result findAllAdmin(){
        return Result.success(adminService.findAll());
    }

    @ApiOperation("根据ID查找管理员")
    @GetMapping("{adminId}")
    public Result findAdminById(@PathVariable("adminId") Integer adminId){
        return Result.success(adminService.findById(adminId));
    }

    @ApiOperation("删除管理员")
    @DeleteMapping("/delete/{adminId}")
    public Result deleteAdminById(@PathVariable("adminId") Integer adminId){
        adminService.deleteById(adminId);
        return Result.success();
    }

    @ApiOperation("更新管理员信息")
    @PutMapping("/update/{adminId}")
    public Result updateAdmin(@PathVariable("adminId") Integer adminId, Admin admin){
        return Result.success(adminService.update(admin));
    }

    @ApiOperation("添加管理员信息")
    @PostMapping("/add/admin")
    public Result add(Admin admin){
        return Result.success(adminService.add(admin));
    }
}
