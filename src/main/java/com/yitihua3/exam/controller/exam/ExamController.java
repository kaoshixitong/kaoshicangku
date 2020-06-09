package com.yitihua3.exam.controller.exam;

import com.alibaba.fastjson.JSONObject;
import com.yitihua3.exam.entity.exam.Exam;

import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.exam.ExamService;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api("考试的controller")
@RestController
@RequestMapping("/exam/exam")
public class ExamController {
    /**
        服务对象
     **/
    @Autowired
    private ExamService examService;

    /**
     * 通过主键查询单条数据
     *
     * @param examId 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据考试编号查询考试",  notes = "学生、教师均可查询某一考试",httpMethod = "GET")
    @GetMapping("queryExamById")
    public Result queryExamById(
            @ApiParam(name="examId",value="考试编号",required=true)
                    Integer examId) {
        Exam exam = examService.queryById(examId);
        if (exam==null){
            return ResultGenerator.genFailedResult("按编号查询考试失败");
        }
        else
        return ResultGenerator.genOkResult("按编号查询考试成功");
    }

    @ApiOperation(value = "根据考试编号删除考试",notes = "用于教师删除某一考试",httpMethod = "DELETE")
    @DeleteMapping("deleteExamById")
    public Result deleteExamById(
            @ApiParam(name = "examId",value = "考试编号",required = true)
            @ApiIgnore @RequestBody  JSONObject jsonObject
    ){
        boolean b = examService.deleteById(jsonObject.getInteger("examId"));
        if (!b){
            return ResultGenerator.genFailedResult("删除考试失败");
        }
        else

        return ResultGenerator.genOkResult("删除考试成功"); 
    }

    @RequestMapping("toAddExam")
    public String toAddExam(){
        return "addExam";
    }

    @ApiOperation(value = "添加考试",notes = "用于教师添加考试相关信息",httpMethod = "POST")
    @PostMapping("addExam")
    public Result addExam(
            @RequestBody  Exam exam
//            @ApiParam(name = "examId",value = "考试编号",required = true)Integer examId,
//            @ApiParam(name = "examName",value = "考试名称",required = true)String examName,
//            @ApiParam(name = "begin",value = "开始时间",required = true)String begin,
//            @ApiParam(name = "end",value = "结束时间",required = true)String end,
//            @ApiParam(name = "during",value = "持续时间",required = true)Integer during,
//            @ApiParam(name = "paperDTO",value = "考试编号",required = true)PaperDTO paperDTO
    ){
        Exam insert = examService.insert(exam);
        if (insert==null){
            return ResultGenerator.genFailedResult("添加考试失败");
        }
        else
        return ResultGenerator.genOkResult("添加考试成功");
    }

    @RequestMapping("toUpdateExam")
    public String toUpdateExam(Integer examId, Model model){
        examService.queryById(examId);
        model.addAttribute("examId",examId);
        return "updateExam";
    }

    @ApiOperation(value = "更新考试",notes = "用于教师更改考试相关信息",httpMethod = "PUT")
    @PutMapping("updateExam")
    public Result updateExam(@RequestBody Exam exam,Model model
                            //            @ApiParam(name = "examId",value = "考试编号",required = true)Integer examId,
//            @ApiParam(name = "examName",value = "考试名称",required = true)String examName,
//            @ApiParam(name = "begin",value = "开始时间",required = true)String begin,
//            @ApiParam(name = "end",value = "结束时间",required = true)String end,
//            @ApiParam(name = "during",value = "持续时间",required = true)Integer during,
//            @ApiParam(name = "paperDTO",value = "考试编号",required = true)PaperDTO paperDTO){){
    ){
        Exam update = examService.update(exam);
        exam = examService.queryById(exam.getExamId());
        model.addAttribute("exam",exam);
        if(update==null){
            return ResultGenerator.genFailedResult("按编号更新考试失败");
        }
        return ResultGenerator.genOkResult("按编号更新考试成功");
    }

    @ApiOperation(value = "显示所有考试",notes = "学生、教师均可显示所有考试",httpMethod = "GET")
    @GetMapping("queryAll")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="分页页码",required=true,example = "1"),
            @ApiImplicitParam(name="size",value="分页数量",required=true,example = "5")
    })
    public Result queryAll(){
        List<Exam> exams = examService.queryAll();
        if (exams!=null && exams.size()>0){
            return ResultGenerator.genOkResult("查询所有考试成功");}
        else
            return ResultGenerator.genFailedResult("查询所有考试失败");
    }


}
