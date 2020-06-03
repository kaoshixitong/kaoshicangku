package com.yitihua3.exam.utils;

import com.zhaofujun.automapper.AutoMapper;
import com.zhaofujun.automapper.IMapper;
import com.zhaofujun.automapper.builder.ClassMappingBuilder;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Map;

/**
 * @author aiwoqe
 * @Type DTOConverter
 * @Desc
 * @date 2020年04月28日
 * @Version V1.0
 */
public class DTOConverterUtils {

    public static<DTO,DO> DO commonConverter(DTO dto, Class<DO> doClass){
        IMapper mapper=new AutoMapper();
        DO aDo = mapper.map(dto, doClass);
        return aDo;
    }

    public static<DTO,DO> DO differentNameConverter(DTO dto, Class<DO> doClass,Map<String,String>fieldMap) throws RuntimeException{
        IMapper mapper=new AutoMapper();
        //允许映射包括没有setter的字段
        ClassMappingBuilder builder = mapper.mapping(dto.getClass(), doClass, true);
        if (!CollectionUtils.isEmpty(fieldMap)){
            for (Map.Entry<String,String> entry : fieldMap.entrySet()) {
                builder.field(entry.getKey(), entry.getKey());
            }
        }
        DO aDo = mapper.map(dto, doClass);
        return aDo;
    }

    public static<DTO,DO> DO excludeConverter(DTO dto, Class<DO> doClass,String[] excludeArray) throws RuntimeException{
        IMapper mapper=new AutoMapper();
        //允许映射包括没有setter的字段
        ClassMappingBuilder builder = mapper.mapping(dto.getClass(), doClass, true);
        if(excludeArray!=null&&!"".equals(excludeArray[0])) {
            String excludes = Arrays.toString(excludeArray).substring(0, excludeArray.length - 1);
            builder.excludes(excludes);
        }

        DO aDo = mapper.map(dto, doClass);
        return aDo;
    }

    public static<DTO,DO> DO complexConverter(DTO dto, Class<DO> doClass,Map<String,String>fieldMap,String[] excludeArray) throws RuntimeException{
        IMapper mapper=new AutoMapper();
        //允许映射包括没有setter的字段
        ClassMappingBuilder builder = mapper.mapping(dto.getClass(), doClass, true);
        if(!CollectionUtils.isEmpty(fieldMap)) {
            for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
                builder.field(entry.getKey(), entry.getValue());
            }
        }
        if(excludeArray!=null&&!"".equals(excludeArray[0])) {
            builder.excludes(excludeArray);
        }
        DO aDo = mapper.map(dto, doClass);
        return aDo;
    }
}
