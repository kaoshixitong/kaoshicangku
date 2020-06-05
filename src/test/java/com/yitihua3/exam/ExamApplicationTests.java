package com.yitihua3.exam;

import com.yitihua3.exam.dto.answer.AnswerDTO;
import com.yitihua3.exam.dto.answer.ChoiceAnswerDTO;
import com.yitihua3.exam.entity.answer.ChoiceAnswer;
import com.yitihua3.exam.entity.answer.EssayAnswer;
import com.yitihua3.exam.entity.answer.JudgeAnswer;
import com.yitihua3.exam.entity.exam.Choice;
import com.yitihua3.exam.entity.user.Classes;
import com.yitihua3.exam.mapper.answer.ChoiceAnswerMapper;
import com.yitihua3.exam.mapper.answer.EssayAnswerMapper;
import com.yitihua3.exam.mapper.answer.JudgeAnswerMapper;
import com.yitihua3.exam.mapper.exam.ChoiceMapper;
import com.yitihua3.exam.mapper.user.ClassesMapper;
import com.yitihua3.exam.mapper.user.UserMapper;
import com.yitihua3.exam.service.answer.ChoiceAnswerService;
import com.yitihua3.exam.service.user.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class ExamApplicationTests {


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
        Object salt = ByteSource.Util.bytes("8429128961220332");
        int hashIterations = 2;
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);

    }

    @Resource
    ChoiceAnswerMapper choiceAnswerMapper;

    @Resource
    ChoiceMapper choiceMapper;

    @Resource
    JudgeAnswerMapper judgeAnswerMapper;

    @Resource
    EssayAnswerMapper essayAnswerMapper;

    @Autowired
    ChoiceAnswerService choiceAnswerService;
    @Test
    void updateChoiceScore(){


    }

    @Test
    void selectList() {
        ArrayList list = new ArrayList<>();
        ChoiceAnswer choiceAnswer1=new ChoiceAnswer(1,1,1,null,"A");
        ChoiceAnswer choiceAnswer2=new ChoiceAnswer(2,1,1,null,"B");
        ChoiceAnswer choiceAnswer3=new ChoiceAnswer(3,1,1,null,"C");
        ChoiceAnswer choiceAnswer4=new ChoiceAnswer(4,1,1,null,"D");
        JudgeAnswer judgeAnswer1=new JudgeAnswer(1,1,1,null,"A");
        JudgeAnswer judgeAnswer2=new JudgeAnswer(1,1,1,null,"B");
        EssayAnswer essayAnswer1=new EssayAnswer(1,1,1,null,"参考百度");
        EssayAnswer essayAnswer2=new EssayAnswer(1,1,1,null,"复制粘贴的答案");
        EssayAnswer essayAnswer3=new EssayAnswer(1,1,1,null,"版权声明：本文为CSDN博主「Hello-Coder」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。");
        list.add(choiceAnswer1);
        list.add(choiceAnswer2);
        list.add(choiceAnswer3);
//        list.add(choiceAnswer4);
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhh");
//        int score = choiceAnswerService.updateAnswerScore(list);
//        System.out.println("score = " + score);
//        System.out.println("choiceList = " + choiceList);
//        essayAnswerMapper.insertList(list);
    }

    @Test
    void contextLoads() throws Exception {
        System.out.println(userMapper.selectCompleteUser("小明"));
        Choice choice=new Choice(1,"题目","A选项","B选项","C选项","D选项","A",1,1,1,1);

//
//        PaperDTO dto=new PaperDTO(1,"模拟卷",100 , list,null,null);
//        Choice choice1 = DTOConverterUtils.commonConverter(choice, Choice.class);
//        LoginDTO loginDTO=new LoginDTO("admin","123","salt",1);
//        User user = DTOConverterUtils.commonConverter(loginDTO, User.class);
//        System.out.println(choice1);
//        System.out.println("user = " + user);
        ChoiceAnswerDTO choiceAnswerDTO=new ChoiceAnswerDTO(1,1,"A") ;
        ChoiceAnswerDTO choiceAnswerDTO2=new ChoiceAnswerDTO(1,2,"B") ;
        ChoiceAnswerDTO choiceAnswerDTO3=new ChoiceAnswerDTO(1,3,"C") ;
        AnswerDTO answerDTO=new AnswerDTO();
        answerDTO.setExamId(1);
        answerDTO.setUserId(2018);
        ArrayList<ChoiceAnswerDTO> list = new ArrayList<>();

        list.add(choiceAnswerDTO);
        list.add(choiceAnswerDTO2);
        list.add(choiceAnswerDTO3);
        answerDTO.setChoiceAnswerList(list);
//        System.out.println(choiceAnswerDTO.convert().add(answerDTO));
//        System.out.println(AbstractRelationMapper.listConvertAndAdd(answerDTO.getChoiceAnswerList(),answerDTO));
//        System.out.println(choiceAnswerDTO.convert());
//        System.out.println(choice.convert());

    }
}
