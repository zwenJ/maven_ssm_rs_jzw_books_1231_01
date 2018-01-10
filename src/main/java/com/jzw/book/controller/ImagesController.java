package com.jzw.book.controller;

import com.jzw.book.model.Images;
import com.jzw.book.service.ImagesService;
import com.jzw.book.util.Config;
import com.jzw.book.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/3 14:33
 */
@RequestMapping(value = "/image", method = RequestMethod.POST)
public class ImagesController  extends ParentController {

    private Logger logger = LoggerFactory.getLogger(ImagesController.class);

    @Autowired
    private ImagesService imagesService;


    /**
     * 进入到上传图片的页面
     * @param bookId
     * @param request
     * @return
     */
    @RequestMapping(value = "/doimages.controller", method = RequestMethod.GET)
    public String doImage(@ModelAttribute("bookid") Integer bookId,
                          HttpServletRequest request){
        request.getSession().setAttribute("UploadImageSession",bookId);
        return "manager/upload_image";
    }


    /**
     * 图片上传
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/upload.controller")
    public String addImage(@ModelAttribute("file") MultipartFile file,
                           HttpServletRequest request){
        logger.debug("上传图片的请求：本次上传的图片为："+file);

        boolean uploadResult = false;
        //上传图片的商品
        Integer bookId = (Integer) request.getSession().getAttribute("UploadImageSession");

        if (null != file) {
            String suffixY = StringUtil.sub(file.getOriginalFilename(),".");
            String suffixx = suffixY == "" ? ".temp" : suffixY;
            String name = bookId+"="+UUID.randomUUID()+"=book"+suffixx;
            //文件保存的路径
            String path = Config.PATH+name;

            try{
                //转存文件到本地
                file.transferTo(new File(path));

                logger.debug("文件保存成功！");

                Images images = new Images();
                images.setBookId(bookId);
                images.setImgName(name);

                //通知业务逻辑层保存
                boolean saveImage = imagesService.saveImage(images);
                uploadResult = saveImage;
                if (saveImage){
                    logger.debug("文件信息保存成功！");
                }
                else {
                    logger.debug("文件信息保存失败！");
                }

            } catch (Exception e){
                e.printStackTrace();
                logger.error("转存 及 保存 文件到本地/数据库中出现错误",e);
            }

        }

        //设置上传的结果
        request.getSession().setAttribute("BookResult",uploadResult);
        return "redirect:/book/select/manager/books/list_books1.controller?status=1";
    }


    /**
     * 返回图片字节流
     * @param bookId
     * @param request
     * @param response
     */
    @RequestMapping(value = "/traget.controller", method = RequestMethod.GET)
    public void getImagesOut(@ModelAttribute("bookId") Integer bookId,
                             HttpServletRequest request,
                             HttpServletResponse response){

        Images images = imagesService.showImages(bookId);
        if (null != images){
            if (StringUtil.isNotNull(images.getImgName())) {
                String path = Config.PATH+images.getImgName();

                //获得文件
                File file = new File(path);

                BufferedInputStream bis = null;
                BufferedOutputStream bos = null;

                /**
                 * 获取文件都入流
                 */
                try {
                    bis = new BufferedInputStream(new FileInputStream(file));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    logger.error("获取文件读入流出现了错误：", e);
                    try {
                        bis = new BufferedInputStream(new FileInputStream(new File(Config.PATH+"moren")));
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                        logger.error("获取文件读入流 再次 出现了错误：", e);
                    }
                }

                try {
                    bos = new BufferedOutputStream(response.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("获取文件写出流出现了错误：",e);
                }

                /**
                 * 获取文件写出流
                 */
                if (bis != null && bos != null) {
                    /**
                     * 文件写出去
                     */
                    byte[] bytes = new byte[50];
                    try {
                        //边读边写
                        int len;
                        while (-1 != (len = bis.read(bytes))){
                            bos.write(bytes, 0, len);
                        }

                        //刷新
                        bos.flush();
                        //关流
                        bos.close();
                        bis.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                        logger.error("IO读写的时候出现了错误：",e);
                    }

                }

            }
        }

    }


}
