package com.yitihua3.exam.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应状态码枚举类
 *
 * <p>自定义业务异常 2*** 开始
 *
 * <p>原有类异常 4*** 开始
 *
 * @author Zoctan
 * @date 2018/07/14
 */
@AllArgsConstructor
@Getter
public enum ResultCode {
    /** 成功请求，但结果不是期望的成功结果 */
    SUCCEED_REQUEST_FAILED_RESULT(1000, "成功请求，但结果不是期望的成功结果"),

    /** 查询失败 */
    FIND_FAILED(2000, "查询失败"),

    /** 保存失败 */
    SAVE_FAILED(2001, "保存失败"),

    /** 更新失败 */
    UPDATE_FAILED(2002, "更新失败"),

    /** 删除失败 */
    DELETE_FAILED(2003, "删除失败"),

    /** 账户名重复 */
    DUPLICATE_NAME(2004, "账户名重复"),

    /** 数据库异常 */
    DATABASE_EXCEPTION(4001, "数据库异常"),

    /** 认证异常 */
    UNAUTHORIZED_EXCEPTION(4002, "认证异常"),

    /** 验证异常 */
    VIOLATION_EXCEPTION(4003, "验证异常"),

    /** 登录异常 */
    NO_LOGIN(4004, "未登录"),

    /** 权限异常 */
    NO_PERMISSION(4005, "无权限"),

    /** 图片上传异常 */
    PHOTO_EXCEPTION(4006, "图片上传异常"),

    /** 注册异常 */
    REGISTER_EXCEPTION(4007, "注册异常"),

    /** 答题异常 */
    ANSWER_EXCEPTION(4008, "答题异常");

    private final int value;

    private final String reason;



    public String format(final Object... objects) {
        return objects.length > 0 ? String.format(this.getReason(), objects) : this.getReason();
    }
}