package com.yitihua3.exam.controller.user;


import com.yitihua3.exam.entity.user.User;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.user.JWTService;
import com.yitihua3.exam.service.user.UserService;
import com.yitihua3.exam.utils.PhotoUploadUtils;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileNotFoundException;

/**
 * @author aiwoqe
 * @Type PhotoUpload
 * @Desc
 * @date 2020年05月22日
 * @Version V1.0
 */
@Api(value = "图片上传的controller")
@RestController
@RequestMapping("/user")
public class PhotoUpload {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @Resource
    private JWTService jwtService;

    @ApiResponses({
            @ApiResponse(code = 200, message = "HTTP状态码，返回值JSON code字段值，描述：成功"),
            @ApiResponse(code = 4006, message = "非HTTP状态码，返回值JSON code字段值，描述：图片上传异常")
    })

    @ApiOperation(value = "上传文件至服务器",  notes = "上传头像",httpMethod = "POST")
    @PostMapping("photoUpload")
    public Result photoUpload(
            @ApiParam(name="file",value="文件流",required=true)
            @RequestParam("file") final MultipartFile file) throws FileNotFoundException {
        String photoName = PhotoUploadUtils.photoUpload(file);
        User user = jwtService.getSubjectUser();
        userService.updatePhoto(photoName,user);
        PhotoUploadUtils.deleteOldPhoto(user.getPhoto());
        return ResultGenerator.genOkResult("头像上传成功");
    }
}
