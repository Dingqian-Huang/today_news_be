package com.david.commom.exception;

import com.david.commom.pojo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NewsExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(NewsExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public Result exceptionHandler (Exception e) {
        //get stack info
        StackTraceElement stackTraceElement = e.getStackTrace()[0];
        String className = stackTraceElement.getClassName();
        int lineNumber = stackTraceElement.getLineNumber();
        String methodName = stackTraceElement.getMethodName();
        logger.error("System error : {}, Error class: {}, Error Method: {}, At line: {}", e.getMessage(), className, methodName, lineNumber);
        return Result.error();
    }

    @ExceptionHandler(NewsException.class)
    public Result newsExceptionHandler(NewsException e){
        logger.error("news exception: {}", e.getMessage());
        return Result.errorMessage(e.getMessage(), e.getCode(), null);
    }
}
