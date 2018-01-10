package com.jzw.book.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jzw.book.model.Books;
import com.jzw.book.model.Users;
import com.jzw.book.service.IBookService;
import com.jzw.book.service.ImagesService;
import com.jzw.book.util.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Book;
import java.util.Date;
import java.util.List;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/3 13:02
 */
@RequestMapping(value = "/book", method = RequestMethod.POST)
public class BookController extends ParentController{

    //日志对象
    private Logger logger = LoggerFactory.getLogger(BookController.class);


    @Autowired
    private IBookService iBookService;

    @Autowired
    private ImagesService imagesService;


    private List<Books> booksList;


    /**
     * 新增书籍信息
     * @param books
     * @param model
     * @return
     */
    @RequestMapping("/addbook.controller")
    public String addBook(@Validated(value = {Books.AddBook.class})
                              @ModelAttribute("form") Books books,
                          BindingResult bindingResult,
                          Model model,
                          HttpServletRequest request){
        //服务器校验
        if (bindingResult.hasErrors()) {
            initTypesList(request);
            model.addAttribute("AddBook", books);
            return "manager/add_book";
        }

        logger.debug("请求添加新的书籍，需要添加的书籍信息为：\n"+books);

        //设置相关的参数
        books.setBookStatus(1);//状态 1新增 2上架 3下架  456待定
        books.setBookDate(new Date());//时间
        books.setShopId(1);//商家，暂定品台

        // TODO: 2018/1/6 已禁用增加图书的方法
        //通知业务逻辑层
        boolean saveBook = iBookService.saveBook(books);

        //判断添加是否成功

        if (!saveBook){ //添加失败，转发回添加页面
            model.addAttribute("AddBook",books);
            return "manager/add_book";
        }
        //添加成功，跳转到未上架页面
        return "redirect:/book/select/manager/books/list_books1.controller?status=1";
    }


    /**
     * 跳转 到 修改图书信息的页面
     *
     * @param bookId
     * @return
     */
    @RequestMapping(value = "/toeditbook.controller", method = RequestMethod.GET)
    public String toEditBook(@ModelAttribute("bookId") Integer bookId,
                             HttpServletRequest request) {

        Books updateBook = iBookService.showBook(bookId);
        request.setAttribute("UpdateBook", updateBook);

        return "manager/edit_book";
    }


    /**
     * 改变商品状态
     * @param books
     * @return
     */
    @RequestMapping(value = "/updatebooks/{cli}.controller")
    public String updateBook(@ModelAttribute("books") Books books,
                             @ModelAttribute("pages") Integer pages,
                             @PathVariable("cli") String cli,
                             HttpServletRequest request){

        // TODO 这里应改判断一下，如果是上架商品，那么商品的信息应该是完善的才能上架成功！否则予以提示

        //修改失败
        if (!update(books)){
            //编辑   修改Book的信息失败
            if (pages == 2) {
                //修改失败提示信息
                request.setAttribute("UpdateManager", "error");

                //保存被修改的信息
                request.setAttribute("UpdateBook", books);
                return "manager/edit_book";
            }
            else if (pages == 1) {
                return "redirect:/book/toJs.controller?result=error";
            }
        }

        //post请求方式，修改商品的状态信息
        if (pages == 1) {
            return "redirect:/book/toJs.controller?result=success";
        }
        //成功 路径跳转
        return "redirect:/book/select/manager/books/list_books1.controller?status="+books.getBookStatus();
    }

    /**
     * 将结果转换为JSON返回
     * @return
     */
    @RequestMapping(value = "/toJs.controller", method = RequestMethod.GET)
    @ResponseBody
    public String updateBook(@ModelAttribute("result") String result){
        return result;
    }


    /**
     * 删除的方法
     *
     * @param bookId
     * @param users
     * @param request
     * @return
     */
    @RequestMapping("/deletebook.controller")
    @ResponseBody
    public String deleteBook(@ModelAttribute("bookId") Integer bookId,
                             @ModelAttribute("users") Users users,
                             HttpServletRequest request){
        /**
         * 删除 商品信息
         * 同时删除商品的图片信息
         */
        //TODO 管理员删除商品 应该 先判断权限  这里还没有完成

        boolean deleteBook = iBookService.deleteBook(bookId);
        if (deleteBook) {
            return "success";
        }

        //重定向到未上架商品管理页面
        return "error";
    }



    /**
     * 根据编号查询单个图书详情
     * @param bookId
     * @param request
     * @return
     */
    @RequestMapping(value = "/details.controller", method = RequestMethod.GET)
    public String selectBook(@ModelAttribute("bookId") Integer bookId,
                             HttpServletRequest request) {

        Books showBook = iBookService.showBook(bookId);
        request.setAttribute("ShowBookDeatils", showBook);

        return "home/details_book";
    }



    /**
     * 查询方法
     * @param pageBean
     * @param dir
     * @param res
     * @param request
     * @return
     */
    @RequestMapping(value = "/select/{dir}/{res}.controller",method = RequestMethod.GET)
    public String selectBooks(@ModelAttribute("pageBean") PageBean pageBean,
                              @PathVariable("dir") String dir,
                              @PathVariable("res") String res,
                              HttpServletRequest request){

        select(request, pageBean);

        return "redirect:/base/"+dir+"/"+res+".controller";
    }

    /**
     * 查询方法 的重写
     * @param pageBean
     * @param dir
     * @param res
     * @param cli
     * @param request
     * @return
     */
    @RequestMapping(value = "/select/{dir}/{res}/{cli}.controller",method = RequestMethod.GET)
    public String selectBooks(@ModelAttribute("pageBean") PageBean pageBean,
                              @PathVariable("dir") String dir,
                              @PathVariable("res") String res,
                              @PathVariable("cli") String cli,
                              HttpServletRequest request){

        select(request, pageBean);
        if ("list_books1".equalsIgnoreCase(cli)){
            //如果你是要跳转到未上架的商品栏去
            //查询判断你还有那些商品为上传图片，或者修改已上传的图片
            if (null != booksList) {
                for (Books books : booksList) {
                    boolean b = imagesService.doImagesExist(books.getBookId());
                    logger.debug("是否存在！"+b);
                    books.setExistImage(b);
                }
                //保存到request中
                request.getSession().setAttribute("SelectBookList", booksList);
            }
        }

        return "redirect:/base/"+dir+"/"+res+"/"+cli+".controller";
    }

    /**
     * 通用查询
     * @param request
     * @param pageBean
     */
    private void select(HttpServletRequest request, PageBean pageBean){
        logger.debug("查询商品的信息：PageBean：\n"+pageBean);

        //开始分页
        PageHelper.startPage(pageBean);
        booksList = iBookService.showBooks(pageBean);
        PageInfo pageInfo = new PageInfo(booksList);
        pageBean.setPages(pageInfo.getPages());
        pageBean.setTotal(pageInfo.getTotal());


        //保存到request中
        request.getSession().setAttribute("SelectBookList", booksList);
        request.getSession().setAttribute("PageBean", pageBean);
    }


    /**
     * 通用修改
     * @param books
     * @return
     */
    private boolean update(Books books){
        if (null != books) {
            return iBookService.updateBook(books);
        }

        return false;
    }


}
