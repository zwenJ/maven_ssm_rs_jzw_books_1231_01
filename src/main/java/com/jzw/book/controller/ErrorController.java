package com.jzw.book.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/9 13:22
 */
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = Exception.class)
    public String showError(){
        return "redirect:/html/error.html";
    }

}
