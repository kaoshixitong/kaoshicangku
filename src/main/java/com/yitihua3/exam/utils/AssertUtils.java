package com.yitihua3.exam.utils;


import com.yitihua3.exam.exception.ServiceException;
import com.yitihua3.exam.response.ResultCode;

/**
 * 断言工具
 *
 * @author Zoctan
 * @date 2018/11/29
 */
public class AssertUtils {
  public static void throwIf(
          final boolean statement, final ResultCode resultCode, final String message) {
    if (statement) {
      throw toThrow(resultCode, message);
    }
  }

  public static void throwIf(
      final boolean statement, final ResultCode resultCode, final Object... messages) {
    throwIf(statement, resultCode, resultCode.format(messages));
  }

  public static RuntimeException toThrow(final ResultCode resultCode, final Object... messages) {
    return new ServiceException(resultCode, resultCode.format(messages));
  }

  public static void asserts(
      final boolean statement, final ResultCode resultCode, final Object... messages) {
    throwIf(!statement, resultCode, messages);
  }
}
