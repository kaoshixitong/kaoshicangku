package com.yitihua3.exam;

<<<<<<< HEAD
import com.yitihua3.exam.dto.answer.AnswerDTO;
import com.yitihua3.exam.dto.answer.ChoiceAnswerDTO;
import com.yitihua3.exam.entity.exam.Choice;
import com.yitihua3.exam.entity.user.Classes;
import com.yitihua3.exam.mapper.user.ClassesMapper;
import com.yitihua3.exam.mapper.user.UserMapper;
import com.yitihua3.exam.service.user.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
=======
//import com.yitihua3.exam.dto.answer.AnswerDTO;
//import com.yitihua3.exam.dto.answer.JudgeAnswerDTO;

import com.yitihua3.exam.entity.exam.Exam;
import com.yitihua3.exam.mapper.exam.ExamMapper;
import org.junit.*;
import com.yitihua3.exam.controller.exam.ChoiceController;
>>>>>>> 1de8b11470374ab95a07891848a3ae274f25c9c0
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

<<<<<<< HEAD
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
=======
>>>>>>> 1de8b11470374ab95a07891848a3ae274f25c9c0

@SpringBootTest
@WebAppConfiguration
class ExamApplicationTests {
//    @Autowired
//    private ExamMapper examMapper;
//    @Test
//    void run2(){
//        Exam exam = new Exam(1,"lsb","111","222",111,1);
//        examMapper.insert(exam);
//        System.out.println(examMapper.queryAll());
//        System.out.println(examMapper.queryById(1));
//        examMapper.update(exam);
//        examMapper.deleteById(1);
//    }


<<<<<<< HEAD
    @Resource
    UserMapper userMapper;
    @Resource
    UserService userService;

    @Resource
    ClassesMapper classesMapper;

    @Test
    void classes(){
        List<Classes> classes = classesMapper.queryAll(null);
        System.out.println("classes = " + classes);
    }

    @Test
    void salt() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();
        System.out.println("salt = " + salt);
    }

    @Test
    void encrypt() {
        String hashAlgorithmName = "MD5";
        Object credentials = "123";
        Object salt = ByteSource.Util.bytes("1205352135315608");
        int hashIterations = 2;
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);

    }
    
    @Test
    void contextLoads() throws Exception {
        System.out.println(userMapper.selectCompleteUser("小明"));
        Choice choice=new Choice(1,"题目","A选项","B选项","C选项","D选项","A",1,1,1,1);
=======
    @Autowired
    private ChoiceController choiceController;
   @Test
    void run1(){
       choiceController.queryAll();
   }

>>>>>>> 1de8b11470374ab95a07891848a3ae274f25c9c0

}



//    @Autowired
//    private EssayMapper essayMapper;
//    @Test
//    void run2(){
//        Essay essay = new Essay(1,"今天好日子啊",1,"今天坏日子啊",1,2);
//        essayMapper.insert(essay);
//        System.out.println(essayMapper.queryById(1));
//        System.out.println(essayMapper.queryAll());
//        System.out.println(essayMapper.queryAllTest());
//        Essay essay1 = new Essay(1,"今天好日子",1,"今天坏日子",1,2);
//        essayMapper.update(essay1);
//        Essay essay2 = new Essay(2,"今天好日子",1,"今天坏日子",1,2);
//        System.out.println(essayMapper.queryReference());
//        System.out.println(essayMapper.queryReferenceById(1));
//        System.out.println(essayMapper.queryScore());
//        System.out.println(essayMapper.queryScoreById(1));
//        System.out.println(essayMapper.queryChapterById(1));
//        System.out.println(essayMapper.querySubjectById(1));
//        essayMapper.insert(essay2);
//        essayMapper.deleteById(2);
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
////        ExamDTO dto=new ExamDTO(1,"模拟卷",100 , list,null,null);
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

//    @Test
//    void run1(){
////        Judge judge = new Judge(1,"今天是个好日子","嗯","b","c",1,2,3);
////        judgeMapper.insert(judge);
////        System.out.println(judgeMapper.queryById(1));
////        System.out.println(judgeMapper.queryAll());
////        System.out.println(judgeMapper.queryAllTest());
////        System.out.println(judgeMapper.queryScoreById(1));
////        System.out.println(judgeMapper.queryScore());
////        System.out.println(judgeMapper.queryRightById(1));
////        System.out.println(judgeMapper.queryRight());
////        Judge judge1 = new Judge(1,"今天是个好","ty","b","c",1,2,3);
////        Judge judge2 = new Judge(2,"今天是个好","ty","b","c",1,2,3);
////        judgeMapper.update(judge1);
////        judgeMapper.insert(judge2);
////        System.out.println(judgeMapper.querySubjectById(1));
////        System.out.println(judgeMapper.queryChapterById(1));
////          judgeMapper.deleteById(2);
////    }
//}
