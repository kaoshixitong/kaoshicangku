package com.yitihua3.exam;

//import com.yitihua3.exam.dto.answer.AnswerDTO;
//import com.yitihua3.exam.dto.answer.EssayAnswerDTO;

import com.yitihua3.exam.entity.exam.Essay;
import com.yitihua3.exam.entity.exam.Exam;
import com.yitihua3.exam.entity.exam.Essay;
import com.yitihua3.exam.entity.exam.Paper;
import com.yitihua3.exam.mapper.exam.EssayMapper;
import com.yitihua3.exam.mapper.exam.ExamMapper;
import com.yitihua3.exam.mapper.exam.EssayMapper;
import com.yitihua3.exam.mapper.exam.PaperMapper;
import org.junit.*;
import com.yitihua3.exam.controller.exam.EssayController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@WebAppConfiguration
class ExamApplicationTests {
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


//    @Autowired
//    private EssayController essayController;
//    @Autowired
//    private EssayMapper essayMapper;
//   @Test
//    void run1(){
//       Essay essay  = new Essay("er","a","b","c","d","a",1,1,1,1);
////       System.out.println(essayController.queryAll());
////       essayController.addEssay(essay);
//       System.out.println(essayMapper.queryAll());
//
//
//   }
//
//
//}



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
//    EssayMapper essayMapper;
//    @Resource
//    UserMapper userMapper;
//    @Test
//    void contextLoads() throws Exception {
//        System.out.println(userMapper.selectCompleteUser("小明"));
//        Essay essay=new Essay(1,"题目","A选项","B选项","C选项","D选项","A",1,1,1,1);
//
////
////        PaperDTO dto=new ExamDTO(1,"模拟卷",100 , list,null,null);
////        Essay essay1 = DTOConverterUtils.commonConverter(essay, Essay.class);
////        LoginDTO loginDTO=new LoginDTO("admin","123","salt",1);
////        User user = DTOConverterUtils.commonConverter(loginDTO, User.class);
////        System.out.println(essay1);
////        System.out.println("user = " + user);
//        EssayAnswerDTO essayAnswerDTO=new EssayAnswerDTO(null,1,1,"A") ;
//        EssayAnswerDTO essayAnswerDTO2=new EssayAnswerDTO(null,1,2,"B") ;
//        EssayAnswerDTO essayAnswerDTO3=new EssayAnswerDTO(null,1,3,"C") ;
//        AnswerDTO answerDTO=new AnswerDTO();
//        answerDTO.setExamId(1);
//        answerDTO.setUserId(2018);
//        ArrayList<EssayAnswerDTO> list = new ArrayList<>();
//
//        list.add(essayAnswerDTO);
//        list.add(essayAnswerDTO2);
//        list.add(essayAnswerDTO3);
//        answerDTO.setEssayAnswerList(list);
////        System.out.println(essayAnswerDTO.convert().add(answerDTO));
////        System.out.println(AbstractRelationMapper.listConvertAndAdd(answerDTO.getEssayAnswerList(),answerDTO));
////        System.out.println(essayAnswerDTO.convert());
////        System.out.println(essay.convert());
//
//    }

    @Autowired
    private EssayMapper essayMapper;
    @Test
    void run1(){
        Essay essay = new Essay("哈哈",1,"嘻嘻",1,1);
        essayMapper.insert(essay);
        System.out.println(essayMapper.queryById(1));
        System.out.println(essayMapper.queryAll());
        System.out.println(essayMapper.queryAllTest());
        System.out.println(essayMapper.queryScoreById(1));
        System.out.println(essayMapper.queryScore());
        System.out.println(essayMapper.queryReferenceById(1));
        System.out.println(essayMapper.queryReference());
        Essay essay1 = new Essay(3,"哈哈",1,"嘻嘻",1,1);
//        Essay essay2 = new Essay("哈哈","a","b","c","d","a",1,1,1,1);
        essayMapper.update(essay1);
        System.out.println(essayMapper.querySubjectById(1));
        System.out.println(essayMapper.queryChapterById(1));
          essayMapper.deleteById(3);
    }
}
