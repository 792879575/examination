package com.exam.config;

public class ApiResult {

    public static com.exam.entity.Result success(Object object) {
        com.exam.entity.Result apiResult = new com.exam.entity.Result();
        apiResult.setData(object);
        apiResult.setCode(200);
        apiResult.setMessage("请求成功");
        return apiResult;
    }

    public static com.exam.entity.Result success() {
        return success(null);
    }

    public static <T> com.exam.entity.Result buildApiResult(Integer code, String message, T data) {
        com.exam.entity.Result result = new com.exam.entity.Result();


        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
