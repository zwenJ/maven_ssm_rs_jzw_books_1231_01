package com.jzw.book.service.impl;

import com.jzw.book.mapper.ImagesMapper;
import com.jzw.book.model.Images;
import com.jzw.book.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/3 17:53
 */
@Service
public class ImagesServiceImpl implements ImagesService {

    @Autowired
    private ImagesMapper imagesMapper;


    /**
     * 根据图书编号查询到对应的图片
     *
     * @param bookId
     * @return
     */
    @Override
    public Images showImages(Integer bookId) {
        return imagesMapper.selectByPrimaryKey(bookId);
    }

    /**
     * 判断该图书是否已经上传图片
     *
     * @param bookId
     * @return
     */
    @Override
    public boolean doImagesExist(Integer bookId) {
        return null!=imagesMapper.selectByPrimaryKey(bookId);
    }

    /**
     * 天剑一条图片信息
     *
     * @param images
     * @return
     */
    @Override
    public boolean saveImage(Images images) {
        int insertSelective = imagesMapper.insertSelective(images);
        if (insertSelective > 0) return true;
        return false;
    }

    /**
     * 修改一个图片的信息
     *
     * @param images
     * @return
     */
    @Override
    public boolean updateImage(Images images) {
        int updateByPrimaryKeySelective = imagesMapper.updateByPrimaryKeySelective(images);
        if (updateByPrimaryKeySelective > 0) return true;
        return false;
    }


}
