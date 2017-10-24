package cn.ifxcode.project.exception;

import cn.ifxcode.project.bean.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * spring json api exception advice
 *
 * @author dongbo
 * @date 2017/10/20
 */
@Slf4j
@ControllerAdvice(value = {"cn.ifxcode.project.controller.json"})
public class JsonApiExceptionAdvice {

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity processServiceException(ServiceException e) {
        Result res = genErrorInfo(500, e.getCode(), e.getMessage());
        log.warn(e.getMessage(), e);
        return ResponseEntity.ok(res);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity processIllegalArgumentException(IllegalArgumentException e) {
        Result res = genErrorInfo(400, "ILLEGAL_ARGUMENT", e.getMessage());
        log.warn(e.getMessage(), e);
        return ResponseEntity.ok(res);
    }

    @ExceptionHandler
    public ResponseEntity defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        log.error(e.getMessage(), e);
        Result res = genErrorInfo(500, "INTERNAL_SERVER_ERROR", "服务器异常");
        return ResponseEntity.ok(res);
    }

    private Result genErrorInfo(int code, String errCode, String message) {
        if (errCode == null) {
            errCode = "SERVICE_EXCEPTION";
        }
        return new Result().setSuccess(false)
                .setCode(String.valueOf(code))
                .setData(new ErrorInfo(errCode, message))
                .setMsg(message);
    }

    @Data
    @AllArgsConstructor
    private static class ErrorInfo {
        String errCode;
        String message;
    }
}
