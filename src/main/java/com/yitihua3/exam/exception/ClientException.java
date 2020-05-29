package com.yitihua3.exam.exception;

import com.yitihua3.exam.response.ResultCode;

/**
 * @author aiwoqe
 * @Type ClientException
 * @Desc
 * @date 2020年05月29日
 * @Version V1.0
 */
public class ClientException extends RuntimeException  {
    private ResultCode resultCode;

    public ClientException(final String message) {
        super(message);
    }

    public ClientException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ClientException(final ResultCode resultCode, final String message) {
        super(message);
        this.resultCode = resultCode;
    }

    public ClientException(final ResultCode resultCode) {
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
