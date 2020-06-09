package com.yitihua3.exam.controller.exam;



import com.alibaba.fastjson.JSONObject;
import com.yitihua3.exam.entity.exam.Essay;
import com.yitihua3.exam.entity.exam.Judge;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.exam.JudgeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Judge)表控制层
 *
 * @author makejava
 *
 */
@Api(value = "判断题的controller")
@RestController
@RequestMapping("exam/judge")
public class JudgeController {
    /**
     * 服务对象
     */
    @Autowired
    private JudgeService judgeService;

    /**
     * 通过主键查询单条数据
     *
     * @param judgeId 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据判断题编号查询判断题", notes = "用于学生、教师查询某一选择题", httpMethod = "GET")
    @GetMapping("queryJudgeById")
    public Result queryJudgeById(
            @ApiParam(name = "judgeId", value = "判断题编号", required = true)
                    Integer judgeId) {
        Judge judge = judgeService.queryById(judgeId);
        if(judge==null){
            return ResultGenerator.genFailedResult("按编号查询判断题失败");
        }
        else
        return ResultGenerator.genOkResult("按编号查询判断题成功");
    }

    @RequestMapping("toAddJudge")
    public String toAddJudge(){
        return "addJudge";
    }

    @ApiOperation(value = "添加判断题",  notes = "用于教师添加判断题",httpMethod = "POST")
    @PostMapping("addJudge")
    public Result  addJudge(
//            @ApiParam(name="judgeId",value="判断题编号",required=true)
//                                        Integer JudgeId,
//                            @ApiParam(name="title",value="添加题目内容",required=true)
//                                        String title,
//                            @ApiParam(name="typeA",value="添加选项A",required=true)
//                                        String typeA,
//                            @ApiParam(name="typeB",value="添加选项B",required=true)
//                                        String typeB,
//                            @ApiParam(name="right",value="添加判断题答案",required=true)
//                                        String right,
//                            @ApiParam(name="score",value="添加判断题得分",required=true)
//                                        Integer score,
//                            @ApiParam(name="subjectId",value="添加科目类型编号",required=true)
//                                        Integer subjectId,
//                            @ApiParam(name="chapterId",value="添加具体章节编号",required=true)
//                                        Integer chapterId,
//                            @ApiParam(name="subject",value="添加科目类型",required=true)
//                                        Integer subject,
//                            @ApiParam(name="chapter",value="添加具体章节",required=true)
//                                        Integer chapter
                            @RequestBody Judge judge)
    {
        Judge insert = judgeService.insert(judge);
        if(insert ==null){
            return ResultGenerator.genFailedResult("添加判断题失败");
        }
        else
        return ResultGenerator.genOkResult("添加判断题成功");
    }

    @ApiOperation(value = "上传excel表格添加判断题",notes = "用于教师上传判断题的excel表格",httpMethod = "GET")
    @GetMapping("addJudgeByExcel")
    public Result addJudgeByExcel(@RequestBody Map<String,Object> obj){
        Judge judgeList =(Judge) obj.get("judgeList");
        Judge insert = judgeService.insert(judgeList);
        if (insert==null){
            return ResultGenerator.genFailedResult("文件上传失败");

        }
        else return ResultGenerator.genOkResult("文件上传成功");

    }

    @ApiOperation(value = "根据判断题编号删除判断题",  notes = "用于教师删除判断题",httpMethod = "DELETE")
    @DeleteMapping("deleteJudgeById")
    public Result deleteJudgeById(
            @ApiParam(name="judgeId",value="判断题编号",required=true)
                    @ApiIgnore @RequestBody JSONObject jsonObject) {
        boolean b = judgeService.deleteById(jsonObject.getInteger("judgeId"));
        if(!b){
            return ResultGenerator.genFailedResult("删除判断题失败");
        }
        else
        return ResultGenerator.genOkResult("删除判断题成功");
    }

    @RequestMapping("toUpdateJudgeById")
    public String toUpdateJudgeById(Integer judgeId,Model model){
        judgeService.queryById(judgeId);
        model.addAttribute("judgeId",judgeId);
        return "updateJudgeById";

    }

    @ApiOperation(value = "根据判断题编号更新判断题",  notes = "用于教师更新判断题",httpMethod = "PUT")
    @GetMapping("updateJudgeById")
    public Result updateJudgeById(
//            @ApiParam(name="judgeId",value="判断题编号",required=true)
//                    Integer judgeId,
//            @ApiParam(name="title",value="更新题目内容",required=true)
//                    String title,
//            @ApiParam(name="typeA",value="更新选项A",required=true)
//                    String typeA,
//            @ApiParam(name="typeB",value="更新选项B",required=true)
//                    String typeB,
//            @ApiParam(name="Right",value="更新判断题答案",required=true)
//                    String right,
//            @ApiParam(name="score",value="更新判断题得分",required=true)
//                    Integer score,
//            @ApiParam(name="subjectId",value="更新科目类型编号",required=true)
//                    Integer subjectId,
//            @ApiParam(name="chapterId",value="更新具体章节编号",required=true)
//                    Integer chapterId,
//            @ApiParam(name="subject",value="更新科目类型",required=true)
//                    Integer subject,
//            @ApiParam(name="chapter",value="更新具体章节",required=true)
//                    Integer chapter) {
            Model model, Judge judge){
        Judge update = judgeService.update(judge);
        judge = judgeService.queryById(judge.getJudgeId());
        model.addAttribute("judge",judge);
        if(update==null){
            return ResultGenerator.genFailedResult("按编号更新判断题失败");
        }
        else
        return ResultGenerator.genOkResult("按编号更新判断题成功");
    }

    @ApiOperation(value = "显示所有判断题",notes = "用于教师显示所有判断题信息",httpMethod = "GET")
    @GetMapping("queryAll")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="分页页码",required=true,example = "1"),
            @ApiImplicitParam(name="size",value="分页数量",required=true,example = "5")
    })
    public Result queryAll(){
        List<Judge> judges = judgeService.queryAll();
        if (judges!=null&&judges.size()>0){
            return ResultGenerator.genOkResult("显示所有判断题成功");
        }
        else
            return ResultGenerator.genFailedResult("显示所有判断题失败");

    }

    @ApiOperation(value = "显示判断题试卷",notes = "用于显示所有判断题题库",httpMethod = "GET")
    @GetMapping("queryAllTest")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="分页页码",required=true,example = "1"),
            @ApiImplicitParam(name="size",value="分页数量",required=true,example = "5")
    })
    public Result queryAllTest(){
        List<Judge> judges = judgeService.queryAllTest();
        if (judges!=null&&judges.size()>0){
            return ResultGenerator.genOkResult("查询所有判断题试卷成功");
        }
        else
            return ResultGenerator.genFailedResult("查询所有判断题试卷失败");

    }

    @ApiOperation(value = "查询某一判断题得分",notes = "用于显示某一道判断题得分",httpMethod = "GET")
    @GetMapping("queryJudgeScoreById")
    public Result queryJudgeScoreById(
            @ApiParam(name = "judgeId",value = "判断题编号",required = true)
            Integer judgeId
    ){
        Judge judge = judgeService.queryScoreById(judgeId);
        if(judge==null){
            return ResultGenerator.genFailedResult("查询第"+judgeId+"道判断题得分失败");
        }
        else
        return ResultGenerator.genOkResult("查询第"+judgeId+"道判断题成绩成功");
    }

    @ApiOperation(value = "查询判断题得分",notes = "用于显示某张试卷判断题总分",httpMethod = "GET")
    @GetMapping("queryJudgeScore")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="分页页码",required=true,example = "1"),
            @ApiImplicitParam(name="size",value="分页数量",required=true,example = "5")
    })
    public Result queryJudgeScore(@ApiParam(name = "paperId",value = "试卷编号",required = true) Integer paperId

    ){
        List<Judge> judges = judgeService.queryScore(paperId);
        if (judges!=null&&judges.size()>0){
            return ResultGenerator.genOkResult("查询判断题成绩成功");
        }
        else
            return ResultGenerator.genFailedResult("查询判断题成绩失败");

    }

    @ApiOperation(value = "查询某一判断题答案",notes = "用于显示某一道判断题答案",httpMethod = "GET")
    @GetMapping("queryJudgeRightById")
    public Result queryJudgeRightById(
            @ApiParam(name="judgeId",value="判断题编号",required=true)
             Integer judgeId){
        Judge judge = judgeService.queryRightById(judgeId);
        if(judge==null){
            return ResultGenerator.genFailedResult("查询第"+judgeId+"道判断题答案失败");
        }
        else
        return ResultGenerator.genOkResult("查询第"+judgeId+"道判断题答案成功");

    }

    @ApiOperation(value = "查询判断题答案",notes = "用于显示某张试卷所有判断题答案",httpMethod = "GET")
    @GetMapping("queryJudgeRight")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="分页页码",required=true,example = "1"),
            @ApiImplicitParam(name="size",value="分页数量",required=true,example = "5")
    })
    public Result queryJudgeRight(@ApiParam(name = "paperId",value = "试卷编号",required = true) Integer paperId)
    {
        List<Judge> judges = judgeService.queryRight(paperId);
        if (judges!=null&&judges.size()>0){
            return ResultGenerator.genOkResult("查询判断题答案成功");
        }
       else
           return ResultGenerator.genFailedResult("查询判断题答案失败");

    }

    @ApiOperation(value = "查询某一判断题所属科目",notes = "用于查询某一道判断题所属科目",httpMethod = "GET")
    @GetMapping("queryJudgeSubjectById")
    public Result queryJudgeSubjectById(
            @ApiParam(name="judgeId",value="判断题编号",required=true)
             Integer judgeId ){
        Judge judge = judgeService.querySubjectId(judgeId);
        if(judge==null){
            return ResultGenerator.genFailedResult("查询第"+judgeId+"道判断题所属科目失败");
        }
        else
        return ResultGenerator.genOkResult("查询第"+judgeId+"道判断题所属科目成功");

    }

    @ApiOperation(value = "查询某一判断题所属章节",notes = "用于查询某道一判断题所属章节",httpMethod = "GET")
    @GetMapping("queryJudgeChapterById")
    public Result queryJudgeChapterById(
            @ApiParam(name="judgeId",value="判断题编号",required=true)
             Integer judgeId ){
        Judge judge = judgeService.queryChapterId(judgeId);
        if(judge==null){
            return ResultGenerator.genFailedResult("查询第"+judgeId+"道判断题所属章节失败");
        }
        else
        return ResultGenerator.genOkResult("查询第"+judgeId+"道判断题所属章节成功");

    }
    @ApiOperation(value = "按试卷编号查询判断题",notes = "用于显示某一张试卷内的判断题",httpMethod = "GET")
    @GetMapping("queryAllTestById")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="分页页码",required=true,example = "1"),
            @ApiImplicitParam(name="size",value="分页数量",required=true,example = "5")
    })
    public Result queryAllTestById(@ApiParam(name = "paperId",value = "试卷编号",required = true)
                                    Integer paperId){
        List<Judge> judge = judgeService.queryAllTestById(paperId);
        if (judge==null){
            return ResultGenerator.genFailedResult("根据试卷编号获取判断题失败");
        }
        else return ResultGenerator.genOkResult("根据试卷编号获取判断题成功");
    }
}