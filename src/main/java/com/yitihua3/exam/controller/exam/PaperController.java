package com.yitihua3.exam.controller.exam;

import com.yitihua3.exam.entity.exam.Choice;
import com.yitihua3.exam.entity.exam.Essay;
import com.yitihua3.exam.entity.exam.Judge;
import com.yitihua3.exam.entity.exam.Paper;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.exam.ChoiceService;
import com.yitihua3.exam.service.exam.EssayService;
import com.yitihua3.exam.service.exam.JudgeService;
import com.yitihua3.exam.service.exam.PaperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author aiwoqe
 * @Type PaperController
 * @Desc
 * @date 2020年04月24日
 * @Version V1.0
 */
@Api(value = "试卷的controller")
@RestController
@RequestMapping("/paper")
public class PaperController {
    /**
     * 服务对象
     */
    @Autowired
    private PaperService paperService;

    @Autowired
    private JudgeService judgeService;

    @Autowired
    private ChoiceService choiceService;

    @Autowired
    private EssayService essayService;

    /**
     * 通过主键查询单条数据
     *
     * @param paperId 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据试卷编号查询试卷",  notes = "根据试卷编号查询试卷",httpMethod = "GET")
    @GetMapping("/queryPaperById")
    public Result queryPaperById(
            @ApiParam(name="paperId",value="试卷编号",required=true)
                    Integer paperId) {
        Paper paper = paperService.queryById(paperId);
        if (paper==null){
            return ResultGenerator.genFailedResult("按编号查询试卷失败");
        }
        else
        return ResultGenerator.genOkResult("按编号查询试卷成功");
    }

    @ApiOperation(value = "根据试卷编号删除试卷",notes = "根据试卷编号删除试卷",httpMethod = "DELETE")
    @GetMapping("/deletePaperById")
    public Result deletePaperById(
            @ApiParam(name = "paperId",value = "试卷编号",required = true) Integer paperId
    ){
        boolean b = paperService.deleteById(paperId);
        if (!b){
            return ResultGenerator.genFailedResult("删除试卷失败");
        }
        return ResultGenerator.genOkResult("删除试卷成功");
    }

    @RequestMapping("/toAddPaper")
    public String toAddPaper(){
        return "addPaper";
    }

    @ApiOperation(value = "添加试卷",notes = "添加试卷",httpMethod = "POST")
    @GetMapping("/addPaper")
    public Result addPaper(
            @RequestParam Paper paper
//            @ApiParam(name = "paperId",value = "试卷编号",required = true)Integer paperId,
//            @ApiParam(name = "paperName",value = "试卷名称",required = true)String paperName,
//            @ApiParam(name = "begin",value = "开始时间",required = true)String begin,
//            @ApiParam(name = "end",value = "结束时间",required = true)String end,
//            @ApiParam(name = "during",value = "持续时间",required = true)Integer during,
//            @ApiParam(name = "paperDTO",value = "试卷编号",required = true)PaperDTO paperDTO
    ){
        Paper insert = paperService.insert(paper);
        if(insert==null){
            return ResultGenerator.genFailedResult("添加试卷失败");
        }
        return ResultGenerator.genOkResult("添加试卷成功");
    }

    @RequestMapping("/toUpdatePaper")
    public String toUpdatePaper(Integer paperId, Model model){
        paperService.queryById(paperId);
        model.addAttribute("paperId",paperId);
        return "updatePaper";
    }

    @ApiOperation(value = "更新试卷",notes = "更新试卷",httpMethod = "PUT")
    @GetMapping("/updatePaper")
    public Result updatePaper(@RequestParam Paper paper, Model model
                             //            @ApiParam(name = "paperId",value = "试卷编号",required = true)Integer paperId,
//            @ApiParam(name = "paperName",value = "试卷名称",required = true)String paperName,
//            @ApiParam(name = "begin",value = "开始时间",required = true)String begin,
//            @ApiParam(name = "end",value = "结束时间",required = true)String end,
//            @ApiParam(name = "during",value = "持续时间",required = true)Integer during,
//            @ApiParam(name = "paperDTO",value = "试卷编号",required = true)PaperDTO paperDTO){){
    ){
        Paper update = paperService.update(paper);
        paper = paperService.queryById(paper.getPaperId());
        model.addAttribute("paper",paper);
        if (update==null){
            return ResultGenerator.genFailedResult("按编号更新试卷失败");
        }
        return ResultGenerator.genOkResult("按编号更新试卷成功");
    }

    @ApiOperation(value = "显示所有试卷信息",notes = "显示所有试卷信息",httpMethod = "GET")
    @GetMapping("/queryAll")
    public Result queryAll(){
        List<Paper> papers = paperService.queryAll();
        if (papers!=null && papers.size()>0){
            return ResultGenerator.genOkResult("查询所有试卷成功");
        }
        else
            return ResultGenerator.genFailedResult("查询所有试卷失败");

    }

    @ApiOperation(value = "显示所有考试试卷",notes = "显示所有考试试卷",httpMethod = "GET")
    @GetMapping("/queryAllTest")
    public Result queryAllTest(){
        List<Choice> choices = choiceService.queryAllTest();
        List<Judge> judges = judgeService.queryAllTest();
        List<Essay> essays = essayService.queryAllTest();
        if (choices!=null && judges!=null && essays!=null && choices.size()>0 && judges.size()>0 && essays.size()>0)
            return ResultGenerator.genOkResult("查询所有考试试卷成功");
        else
                return ResultGenerator.genFailedResult("查询所有考试试卷失败");
    }

    @ApiOperation(value = "显示所有试卷内容信息",notes = "显示所有试卷内容信息",httpMethod = "GET")
    @GetMapping("/queryAllContent")
    public Result queryAllContent(){
        List<Choice> choices = choiceService.queryAll();
        List<Judge> judges = judgeService.queryAll();
        List<Essay> essays = essayService.queryAll();
        if (choices!=null && judges!=null && essays!=null && choices.size()>0 && judges.size()>0 && essays.size()>0)
            return ResultGenerator.genOkResult("查询所有试卷内容信息成功");
        else
            return ResultGenerator.genFailedResult("查询所有试卷内容信息失败");
    }
}
