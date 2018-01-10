package com.jzw.book.service;

import com.jzw.book.model.Images;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/3 17:49
 */
public interface ImagesService {


    /**
     * 根据图书编号查询到对应的图片
     * @param bookId
     * @return
     */
    public Images showImages(Integer bookId);

    /**
     * 判断该图书是否已经上传图片
     * @param bookId
     * @return
     */
    public boolean doImagesExist(Integer bookId);

    /**
     * 天剑一条图片信息
     * @param images
     * @return
     */
    public boolean saveImage(Images images);

    /**
     * 修改一个图片的信息
     * @param images
     * @return
     */
    public boolean updateImage(Images images);

}
