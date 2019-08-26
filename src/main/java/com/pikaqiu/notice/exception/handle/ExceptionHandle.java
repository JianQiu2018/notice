package com.pikaqiu.notice.exception.handle;

import com.pikaqiu.notice.dto.HttpResponse;
import com.pikaqiu.notice.exception.UserException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: 异常捕获类
 *
 * @author 贞子
 * @date 2019/8/21 20:53
 */

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public HttpResponse handle(Exception e) {
        if (e instanceof UserException) {
            return new HttpResponse().setErrorMessage(((UserException) e).getErrorCode(),e.getMessage());
        }
        return new HttpResponse().setErrorMessage(e.getMessage());
    }
}