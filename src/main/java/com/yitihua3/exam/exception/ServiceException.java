package com.yitihua3.exam.exception;

import com.yitihua3.exam.response.ResultCode;

/**
 * Service 异常
 *
 * @author Zoctan
 * @date 2018/05/27
 */
public class ServiceException extends RuntimeException {
  private static final long serialVersionUID = 770293933438435163L;

  private ResultCode resultCode;

  public ServiceException(final String message) {
    this(ResultCode.DATABASE_EXCEPTION,message);
  }

  public ServiceException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public ServiceException(final ResultCode resultCode, final String message) {
    super(message);
    this.resultCode = resultCode;
  }

  public ServiceException(final ResultCode resultCode) {
    super(resultCode.getReason());
    this.resultCode = resultCode;
  }

  public ResultCode getResultCode() {
    return this.resultCode;
  }

  public void setResultCode(final ResultCode resultCode) {
    this.resultCode = resultCode;
  }
}
