package com.jzw.book.controller;

import com.jzw.book.model.Types;
import com.jzw.book.service.ITypesService;
import com.jzw.book.util.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/5 18:24
 */
@Controller
public class ParentController {

    private Logger logger = LoggerFactory.getLogger(ParentController.class);


    @Autowired
    private ITypesService iTypesService;

    @ModelAttribute
    public void init(Model model) {

        logger.debug("执行了父类的初始化方法!");

        model.addAttribute("AllPageBean", new PageBean());
    }


    /**
     * 初始化查询所有的类型
     * @param request
     */
    public void initTypesList(HttpServletRequest request){
        /**
         * 查询出商品类型，保存到request中
         */
        List<Types> typesList = iTypesService.showAll();
        request.getSession().setAttribute("TypesList", typesList);
    }


}
