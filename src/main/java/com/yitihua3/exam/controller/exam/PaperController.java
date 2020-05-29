package com.yitihua3.exam.controller.exam;

import com.yitihua3.exam.entity.exam.Paper;
import com.yitihua3.exam.service.exam.PaperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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

    /**
     * 通过主键查询单条数据
     *
     * @param paperId 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据试卷编号查询试卷",  notes = "根据试卷编号查询试卷",httpMethod = "GET")
    @GetMapping("/queryPaperById")
    public String queryPaperById(
            @ApiParam(name="paperId",value="试卷编号",required=true)
                    Integer paperId) {
        paperService.queryById(paperId);
        return "paperList";
    }

    @ApiOperation(value = "根据试卷编号删除试卷",notes = "根据试卷编号删除试卷",httpMethod = "DELETE")
    @GetMapping("/deletePaperById")
    public String deletePaperById(
            @ApiParam(name = "paperId",value = "试卷编号",required = true) Integer paperId
    ){
        paperService.deleteById(paperId);
        return "paperList";
    }

    @RequestMapping("/toAddPaper")
    public String toAddPaper(){
        return "addPaper";
    }

    @ApiOperation(value = "添加试卷",notes = "添加试卷",httpMethod = "POST")
    @GetMapping("/addPaper")
    public String addPaper(
            @RequestParam Paper paper
//            @ApiParam(name = "paperId",value = "试卷编号",required = true)Integer paperId,
//            @ApiParam(name = "paperName",value = "试卷名称",required = true)String paperName,
//            @ApiParam(name = "begin",value = "开始时间",required = true)String begin,
//            @ApiParam(name = "end",value = "结束时间",required = true)String end,
//            @ApiParam(name = "during",value = "持续时间",required = true)Integer during,
//            @ApiParam(name = "paperDTO",value = "试卷编号",required = true)PaperDTO paperDTO
    ){
        paperService.insert(paper);
        return "paperList";
    }

    @RequestMapping("/toUpdatePaper")
    public String toUpdatePaper(Integer paperId, Model model){
        paperService.queryById(paperId);
        model.addAttribute("paperId",paperId);
        return "updatePaper";
    }

    @ApiOperation(value = "更新试卷",notes = "更新试卷",httpMethod = "PUT")
    @GetMapping("/updatePaper")
    public String updatePaper(@RequestParam Paper paper, Model model
                             //            @ApiParam(name = "paperId",value = "试卷编号",required = true)Integer paperId,
//            @ApiParam(name = "paperName",value = "试卷名称",required = true)String paperName,
//            @ApiParam(name = "begin",value = "开始时间",required = true)String begin,
//            @ApiParam(name = "end",value = "结束时间",required = true)String end,
//            @ApiParam(name = "during",value = "持续时间",required = true)Integer during,
//            @ApiParam(name = "paperDTO",value = "试卷编号",required = true)PaperDTO paperDTO){){
    ){
        paperService.update(paper);
        paper = paperService.queryById(paper.getPaperId());
        model.addAttribute("paper",paper);
        return "paperList";
    }

    @ApiOperation(value = "显示所有试卷",notes = "显示所有试卷",httpMethod = "GET")
    @GetMapping("/queryAll")
    public String queryAll(){
        paperService.queryAll();
        return "paperList";
    }

}
