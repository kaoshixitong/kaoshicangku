package com.yitihua3.exam.controller.exam;

import com.yitihua3.exam.entity.exam.Exam;
import com.yitihua3.exam.service.exam.ExamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("考试的controller")
@RestController
@RequestMapping("/exam")
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
    @ApiOperation(value = "根据考试编号查询考试",  notes = "根据考试编号查询考试",httpMethod = "GET")
    @GetMapping("/queryExamById")
    public String queryExamById(
            @ApiParam(name="examId",value="考试编号",required=true)
                    Integer examId) {
        examService.queryById(examId);
        return "examList";
    }

    @ApiOperation(value = "根据考试编号删除考试",notes = "根据考试编号删除考试",httpMethod = "DELETE")
    @GetMapping("/deleteExamById")
    public String deleteExamById(
            @ApiParam(name = "examId",value = "考试编号",required = true) Integer examId
    ){
        examService.deleteById(examId);
        return "examList";
    }

    @RequestMapping("/toAddExam")
    public String toAddExam(){
        return "addExam";
    }

    @ApiOperation(value = "添加考试",notes = "添加考试",httpMethod = "POST")
    @GetMapping("/addExam")
    public String addExam(
            @RequestParam  Exam exam
//            @ApiParam(name = "examId",value = "考试编号",required = true)Integer examId,
//            @ApiParam(name = "examName",value = "考试名称",required = true)String examName,
//            @ApiParam(name = "begin",value = "开始时间",required = true)String begin,
//            @ApiParam(name = "end",value = "结束时间",required = true)String end,
//            @ApiParam(name = "during",value = "持续时间",required = true)Integer during,
//            @ApiParam(name = "paperDTO",value = "试卷编号",required = true)PaperDTO paperDTO
    ){
        examService.insert(exam);
        return "examList";
    }

    @RequestMapping("/toUpdateExam")
    public String toUpdateExam(Integer examId, Model model){
        examService.queryById(examId);
        model.addAttribute("examId",examId);
        return "updateExam";
    }

    @ApiOperation(value = "更新考试",notes = "更新考试",httpMethod = "PUT")
    @GetMapping("/updateExam")
    public String updateExam(@RequestParam Exam exam,Model model
                            //            @ApiParam(name = "examId",value = "考试编号",required = true)Integer examId,
//            @ApiParam(name = "examName",value = "考试名称",required = true)String examName,
//            @ApiParam(name = "begin",value = "开始时间",required = true)String begin,
//            @ApiParam(name = "end",value = "结束时间",required = true)String end,
//            @ApiParam(name = "during",value = "持续时间",required = true)Integer during,
//            @ApiParam(name = "paperDTO",value = "试卷编号",required = true)PaperDTO paperDTO){){
    ){
        examService.update(exam);
        exam = examService.queryById(exam.getExamId());
        model.addAttribute("exam",exam);
        return "examList";
    }

    @ApiOperation(value = "显示所有考试",notes = "显示所有考试",httpMethod = "GET")
    @GetMapping("/queryAll")
    public String queryAll(){
        examService.queryAll();
        return "examList";
    }




}
