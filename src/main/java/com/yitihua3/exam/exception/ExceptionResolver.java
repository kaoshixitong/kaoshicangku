package com.yitihua3.exam.exception;

import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultCode;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.utils.UrlUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.stream.Collectors;

/**
 * 统一异常处理
 *
 * <p>对于业务异常：返回头 Http 状态码一律使用500，避免浏览器缓存，在响应 Result 中指明异常的状态码 code
 *
 * @author Zoctan
 * @date 2018/06/09
 */
@Slf4j
@RestControllerAdvice
public class ExceptionResolver {
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ConstraintViolationException.class)
  public Result validatorException(final ConstraintViolationException e) {
    final String msg =
            e.getConstraintViolations().stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(","));
    // e.toString 多了不需要用户知道的属性路径
    ExceptionResolver.log.error("==> 验证实体异常: {}", e.toString());
    return ResultGenerator.genFailedResult(ResultCode.VIOLATION_EXCEPTION, msg);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(BindException.class)
  public Result validatorException(final BindException e) {
    StringBuilder errorMsg = new StringBuilder();
    final BindingResult re = e.getBindingResult();
    for (ObjectError error : re.getAllErrors()) {
      errorMsg.append(error.getDefaultMessage()).append(",");
    }
    errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
    // e.toString 多了不需要用户知道的属性路径
    ExceptionResolver.log.error("==> 验证实体异常: {}", errorMsg.toString());
    return ResultGenerator.genFailedResult(ResultCode.VIOLATION_EXCEPTION, errorMsg.toString());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Result validatorException(final MethodArgumentNotValidException e) {
    BindingResult result = e.getBindingResult();
    StringBuilder errorMsg = new StringBuilder();
    for (ObjectError error : result.getAllErrors()) {
      errorMsg.append(error.getDefaultMessage()).append(",");
    }
    errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
    ExceptionResolver.log.error("==> 验证实体异常: {}", e.toString());
    return ResultGenerator.genFailedResult(ResultCode.VIOLATION_EXCEPTION, errorMsg.toString());
  }


  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler({ServiceException.class})
  public Result serviceException(final ServiceException e) {
    ExceptionResolver.log.error("==> 服务异常: {}", e.getMessage());
    e.printStackTrace();
    return ResultGenerator.genFailedResult(e.getResultCode(), e.getMessage());
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler({ResourcesNotFoundException.class})
  public Result resourcesException(final Throwable e) {
    ExceptionResolver.log.error("==> 资源异常: {}", e.getMessage());
    e.printStackTrace();
    return ResultGenerator.genFailedResult(ResultCode.FIND_FAILED);
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler({SQLException.class, DataAccessException.class})
  public Result databaseException(final Throwable e) {
    ExceptionResolver.log.error("==> 数据库异常: {}", e.getMessage());
    e.printStackTrace();
    return ResultGenerator.genFailedResult(ResultCode.DATABASE_EXCEPTION);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({ClientException.class})
  public Result clientException(final ClientException e) {
    ExceptionResolver.log.error("==> 客户端操作异常: {}", e.getMessage());
    e.printStackTrace();
    return ResultGenerator.genFailedResult(e.getResultCode(), e.getMessage());
  }

  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler({AuthenticationException.class})
  public Result principalException(final AuthenticationException e) {
    ExceptionResolver.log.error("==> 身份验证异常: {}", e.getMessage());
    e.printStackTrace();
    return ResultGenerator.genFailedResult(ResultCode.UNAUTHORIZED_EXCEPTION, e.getMessage());
  }

  @ResponseStatus(HttpStatus.FORBIDDEN)
  @ExceptionHandler({UnauthorizedException.class})
  public Result perimissionException(final Throwable e) {
    ExceptionResolver.log.error("==> 权限异常: {}", e.getMessage());
    e.printStackTrace();
    return ResultGenerator.genFailedResult(ResultCode.NO_PERMISSION, e.getMessage());
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NoHandlerFoundException.class)
  public Result apiNotFoundException(final Throwable e, final HttpServletRequest request) {
    ExceptionResolver.log.error("==> API不存在: {}", e.getMessage());
    e.printStackTrace();
    return ResultGenerator.genFailedResult(
        "API [" + UrlUtils.getMappingUrl(request) + "] not existed");
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public Result globalException(final HttpServletRequest request, final Throwable e) {
    ExceptionResolver.log.error("==> 全局异常: {}", e.getMessage());
    e.printStackTrace();
    return ResultGenerator.genFailedResult(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        String.format("%s => %s", UrlUtils.getMappingUrl(request), e.getMessage()));
  }
}
