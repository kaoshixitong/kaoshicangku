package com.yitihua3.exam.dto.common;

/**
 * @author aiwoqe
 */
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.TYPE}) //Target 注解的使用域，FIELD表示使用在属性上面，TYPE表示使用在类上面
@Retention(RetentionPolicy.RUNTIME) //Retention 设置注解的生命周期 ，这里定义为RetentionPolicy.RUNTIME 非常关键
@Documented
public @interface FieldMapper {
    //自定义属性
    String value() default "";
    String type() default "";  // value : status(标记属性值为Y/N的属性) / date(标记属性类型为时间)
    String[] exclude() default "";//目标对象的例外属性
    String[] share() default "";//标注的类选择转换给  除泛型标注的  其他类  的属性；例如AnswerDTO的examId和userId可以转给转成ChoiceAnswer,JudgeAnswer等等
}                               //此时属性名为目标类的属性名
