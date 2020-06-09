package com.yitihua3.exam.response;


import cn.hutool.json.JSONUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Zoctan
 * @date 2018/07/15
 */
@Data
@ApiModel(value = "响应结果")
@AllArgsConstructor()
public class Result<T> {
    @ApiModelProperty(value = "状态码",name = "code")
    private Integer code;

    @ApiModelProperty(value = "消息",name = "message")
    private String message;

    @ApiModelProperty(value = "数据",name = "data")
    private T data;

    public Result(Integer code,String message){
        this.code=code;
        this.message=message;
    }

    public Result(Integer code,T data){
        this.code=code;
        this.data=data;
    }
    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}