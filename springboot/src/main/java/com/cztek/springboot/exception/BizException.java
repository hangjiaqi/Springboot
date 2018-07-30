package com.cztek.springboot.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class BizException {

    /**
     * 运行时异常
     * @param exception
     * @return
     */
    @ExceptionHandler({ RuntimeException.class })
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(RuntimeException exception) {
        log.info("自定义异常处理-RuntimeException");
        ModelAndView m = new ModelAndView();
        m.addObject("exception", exception.getMessage());
        m.setViewName("error/404");
        return m;
    }

    /**
     * Excepiton异常
     * @param exception
     * @return
     */
    @ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(Exception exception) {
        log.info("自定义异常处理-Exception");
        ModelAndView m = new ModelAndView();
        m.addObject("exception", exception.getMessage());
        m.setViewName("error/404");
        return m;
    }
}
