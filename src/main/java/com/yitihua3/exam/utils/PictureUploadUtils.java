//package com.yitihua3.exam.utils;
//
//
//
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.IOUtils;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ResourceUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.UUID;
//
//@Component
//public  class PictureUploadUtils {
//
//    @Resource
//    StudentService tempUserService;
//
//    static StudentService studentService;
//
//    @PostConstruct
//    public void init() {
//        studentService = tempUserService;
//    }
//
//    //图片名前的路径                                           //src           //target
//    public static String pictureUpload(MultipartFile file) throws IOException {
//        String originalFilename = file.getOriginalFilename();
//        System.out.println(originalFilename);
//        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));      //截取扩展名
//        //判断上传文件类型
//        System.out.println(suffix);
//        if(suffix.equalsIgnoreCase(".jpg")||suffix.equalsIgnoreCase(".png")){
//            String uuid = UUID.randomUUID().toString();                                                             //随即取名
//            String newName=uuid+suffix;                                                                             //图片新名字
//            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(getPrefixRoad1()+newName));   //上传到src
//            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(getPrefixRoad2()+newName));   //上传到target
//            return newName;                                                                                     //是图片则返回图片名
//        }else return "false";
//    }
//    //返回上传到src的路径名
//    public static String getPrefixRoad1() throws FileNotFoundException {
//        String road= ResourceUtils.getURL("classpath:").getPath();
//        int target = road.lastIndexOf("target");
//        String prefixRoad=road.substring(0,target)+"src/main/resources/static/imgs/";             //src中imgs的路径
//        return prefixRoad;
//    }
//    //返回上传到target的路径名
//    public static String getPrefixRoad2() throws FileNotFoundException {
//        String prefixRoad2= ResourceUtils.getURL("classpath:").getPath().substring(1)+"static/imgs/";//target中imgs的路径
//        return prefixRoad2;
//    }
//    //选用default.jpg为photo
//    public static String defaultPicture() throws IOException {
//        String uuid = UUID.randomUUID().toString();
//        String newName=uuid+".jpg";
//        File file = new File(getPrefixRoad2() + "default.jpg");
//        FileInputStream stream=new FileInputStream(file);
//        MultipartFile multipartFile =new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(stream));
//        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),new File(getPrefixRoad1()+newName));   //上传到src
//        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),new File(getPrefixRoad2()+newName));   //上传到target
//        return newName;
//    }
//    //删除旧照片
//    public static void deleteOldPhoto(Integer id) throws FileNotFoundException {
//        String oldImg=studentService.getStuById(id).getPhoto();                        //根据id找出旧图片
//        new File(getPrefixRoad1()+oldImg).delete();                         //删去src旧图片
//        new File(getPrefixRoad2()+oldImg).delete();                         //删去target旧图片
//    }
//}
