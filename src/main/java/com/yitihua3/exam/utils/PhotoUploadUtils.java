package com.yitihua3.exam.utils;


import com.yitihua3.exam.exception.ClientException;
import com.yitihua3.exam.exception.ServiceException;
import com.yitihua3.exam.response.ResultCode;
import org.apache.commons.lang3.EnumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * @author aiwoqe
 */
@Component
public  class PhotoUploadUtils {
    private static Logger log = LoggerFactory.getLogger(PhotoUploadUtils.class);

    private enum PhotoSuffix{
        /**
         * BMP
         */
        BMP,
        /**
         * JPG
         */
        JPG,
        /**
         * JPEG
         */
        JPEG,
        /**
         * PNG
         */
        PNG;
    }

    /**
     * 图片存放路径
     */
    @Value(value = "${picture.location}")
    private String pictureLocation;
    private static String pictureLocationProxy;
    /**
     * 图片存放路径
     */
    @Value(value = "${picture.maxsize}")
    private DataSize pictureMaxsize;
    private static DataSize pictureMaxsizeProxy;
    @PostConstruct
    public void init() {
        pictureLocationProxy = pictureLocation;
        pictureMaxsizeProxy = pictureMaxsize;
    }
    /**
     * 上传头像并返回头像名字
     * @param file
     * @return 图片的名字
     */
    public static String photoUpload(MultipartFile file) throws FileNotFoundException {
        String originalFilename = file.getOriginalFilename();
        DataSize fileSize = DataSize.ofBytes(file.getSize());
        if (file.isEmpty()) {
            throw new ClientException(ResultCode.PHOTO_EXCEPTION,"请选择图片上传");
        }

        if (pictureMaxsizeProxy.toBytes() < fileSize.toBytes()) {
            throw new ClientException(ResultCode.PHOTO_EXCEPTION,"请上传"+pictureMaxsizeProxy.toString()+"大小的文件");
        }
        //截取扩展名
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //判断上传文件类型
        log.info("文件类型是"+suffix);
        //检查后缀是否合法
        boolean validSuffix = EnumUtils.isValidEnum(PhotoSuffix.class, suffix.toUpperCase().substring(1));
        if(!validSuffix) {
            throw new ClientException(ResultCode.PHOTO_EXCEPTION,"图片后缀异常");
        }
        //随机图片名
        String uuid = UUID.randomUUID().toString();
        //图片新名字filePath
        String newName=uuid+suffix;
        //处理路径
        File destination = pathPrepare(newName);
        try {
            //这里是把文件上传到 “绝对路径”
            file.transferTo(destination);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServiceException(ResultCode.PHOTO_EXCEPTION,"文件上传过程发生错误，请重试");
        }
        return newName;
    }

    /**
     * 用于图片路径处理
     * @param newName 图片的新名字
     * @return 路径设置好的File
     * @throws FileNotFoundException
     */
    private static File pathPrepare(String newName) throws FileNotFoundException {

        String path = ResourceUtils.getURL("classpath:").getPath().substring(1) + "static/photo/";
        //构建真实的文件路径
        File destination = new File(path + File.separator + newName);
        if (!destination.getParentFile().exists()) {
            destination.getParentFile().mkdirs();
        }
        return destination;
    }

    /**
     * 删除旧照片
     * @param oldPhoto
     */
    public static void deleteOldPhoto(String oldPhoto) {
        new File(pictureLocationProxy+oldPhoto).delete();
    }
}
