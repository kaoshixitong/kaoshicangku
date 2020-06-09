package com.yitihua3.exam;

//import com.yitihua3.exam.dto.answer.AnswerDTO;
//import com.yitihua3.exam.dto.answer.JudgeAnswerDTO;

import com.yitihua3.exam.controller.exam.PaperController;
import com.yitihua3.exam.entity.exam.Judge;
import com.yitihua3.exam.entity.exam.Exam;
import com.yitihua3.exam.entity.exam.Judge;
import com.yitihua3.exam.entity.exam.Paper;
import com.yitihua3.exam.mapper.exam.*;
import com.yitihua3.exam.mapper.exam.JudgeMapper;
import org.junit.*;
import com.yitihua3.exam.controller.exam.JudgeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Map;


@SpringBootTest
@WebAppConfiguration
class ExamApplicationTests {
    @Autowired
    private PaperController paperController;
    @Test
    void run1(){
        paperController.queryAllTestById(1);
        paperController.queryRight(1);
        paperController.queryScore(1);
    }

}
//    @Autowired
//    private ExamMapper examMapper;
//
//    @Test
//    void run2() {
//        Exam exam = new Exam("erha", "1111", "4424", 2, 111);
////        examMapper.insert(exam);
////        examMapper.queryAll();
////        System.out.println(examMapper.queryById(1));
//        examMapper.update(exam);
//        examMapper.deleteById(4);
//    }
//}
//
//
//    @Autowired
//    private JudgeController judgeController;
//   @Test
//    void run1(){
//       Judge judge  = new Judge(3,"sa","ac","bd","ac",1,1,3,1);
//       Model model = new Model() {
//           @Override
//           public Model addAttribute(String s, Object o) {
//               return null;
//           }
//
//           @Override
//           public Model addAttribute(Object o) {
//               return null;
//           }
//
//           @Override
//           public Model addAllAttributes(Collection<?> collection) {
//               return null;
//           }
//
//           @Override
//           public Model addAllAttributes(Map<String, ?> map) {
//               return null;
//           }
//
//           @Override
//           public Model mergeAttributes(Map<String, ?> map) {
//               return null;
//           }
//
//           @Override
//           public boolean containsAttribute(String s) {
//               return false;
//           }
//
//           @Override
//           public Object getAttribute(String s) {
//               return null;
//           }
//
//           @Override
//           public Map<String, Object> asMap() {
//               return null;
//           }
//       };
//       judgeController.deleteJudgeById(3);
//       judgeController.addJudge(judge);
//       System.out.println(judgeController.queryAll());
//       System.out.println(judgeController.queryAllTest());
//       System.out.println(judgeController.queryJudgeById(1));
//       System.out.println(judgeController.queryJudgeChapterById(1));
//       System.out.println(judgeController.queryJudgeRight());
//       System.out.println(judgeController.queryJudgeRightById(1));
//       System.out.println(judgeController.queryJudgeScore());
//       System.out.println(judgeController.queryJudgeScoreById(1));
//       System.out.println(judgeController.queryJudgeSubjectById(1));






//    @Autowired
//    private JudgeMapper judgeMapper;
//    @Test
//    void run2(){
//        Judge judge = new Judge(1,"今天好日子啊",1,"今天坏日子啊",1,2);
//        judgeMapper.insert(judge);
//        System.out.println(judgeMapper.queryById(1));
//        System.out.println(judgeMapper.queryAll());
//        System.out.println(judgeMapper.queryAllTest());
//        Judge judge1 = new Judge(1,"今天好日子",1,"今天坏日子",1,2);
//        judgeMapper.update(judge1);
//        Judge judge2 = new Judge(2,"今天好日子",1,"今天坏日子",1,2);
//        System.out.println(judgeMapper.queryReference());
//        System.out.println(judgeMapper.queryReferenceById(1));
//        System.out.println(judgeMapper.queryScore());
//        System.out.println(judgeMapper.queryScoreById(1));
//        System.out.println(judgeMapper.queryChapterById(1));
//        System.out.println(judgeMapper.querySubjectById(1));
//        judgeMapper.insert(judge2);
//        judgeMapper.deleteById(2);
//    }
//    @Autowired
//    JudgeMapper judgeMapper;
//    @Resource
//    UserMapper userMapper;
//    @Test
//    void contextLoads() throws Exception {
//        System.out.println(userMapper.selectCompleteUser("小明"));
//        Judge judge=new Judge(1,"题目","A选项","B选项","C选项","D选项","A",1,1,1,1);
//
////
////        PaperDTO dto=new ExamDTO(1,"模拟卷",100 , list,null,null);
////        Judge judge1 = DTOConverterUtils.commonConverter(judge, Judge.class);
////        LoginDTO loginDTO=new LoginDTO("admin","123","salt",1);
////        User user = DTOConverterUtils.commonConverter(loginDTO, User.class);
////        System.out.println(judge1);
////        System.out.println("user = " + user);
//        JudgeAnswerDTO judgeAnswerDTO=new JudgeAnswerDTO(null,1,1,"A") ;
//        JudgeAnswerDTO judgeAnswerDTO2=new JudgeAnswerDTO(null,1,2,"B") ;
//        JudgeAnswerDTO judgeAnswerDTO3=new JudgeAnswerDTO(null,1,3,"C") ;
//        AnswerDTO answerDTO=new AnswerDTO();
//        answerDTO.setExamId(1);
//        answerDTO.setUserId(2018);
//        ArrayList<JudgeAnswerDTO> list = new ArrayList<>();
//
//        list.add(judgeAnswerDTO);
//        list.add(judgeAnswerDTO2);
//        list.add(judgeAnswerDTO3);
//        answerDTO.setJudgeAnswerList(list);
////        System.out.println(judgeAnswerDTO.convert().add(answerDTO));
////        System.out.println(AbstractRelationMapper.listConvertAndAdd(answerDTO.getJudgeAnswerList(),answerDTO));
////        System.out.println(judgeAnswerDTO.convert());
////        System.out.println(judge.convert());
//
//    }
//
//    @Autowired
//    private JudgeMapper judgeMapper;
//    @Test
//    void run1(){
//        Judge judge = new Judge("哈哈",1,"嘻嘻",1,1);
//        judgeMapper.insert(judge);
//        System.out.println(judgeMapper.queryById(1));
//        System.out.println(judgeMapper.queryAll());
//        System.out.println(judgeMapper.queryAllTest());
//        System.out.println(judgeMapper.queryScoreById(1));
//        System.out.println(judgeMapper.queryScore());
//        System.out.println(judgeMapper.queryReferenceById(1));
//        System.out.println(judgeMapper.queryReference());
//        Judge judge1 = new Judge(3,"哈哈",1,"嘻嘻",1,1);
////        Judge judge2 = new Judge("哈哈","a","b","c","d","a",1,1,1,1);
//        judgeMapper.update(judge1);
//        System.out.println(judgeMapper.querySubjectById(1));
//        System.out.println(judgeMapper.queryChapterById(1));
//          judgeMapper.deleteById(3);
//    }
//}
