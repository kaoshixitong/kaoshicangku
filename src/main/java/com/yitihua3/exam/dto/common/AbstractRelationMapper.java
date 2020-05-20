package com.yitihua3.exam.dto.common;

/**
 * @author aiwoqe
 * @Type RelationMapperUtils
 * @Desc
 * @date 2020年04月29日
 * @Version V1.0
 */

import com.yitihua3.exam.utils.DTOConverterUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;

public abstract class AbstractRelationMapper<S,T> {
    /**
     * Entity and Dto Mapper
     *             ture  : Entity To Dto (defult)
     *             false : Dto To Entry
     *     Rule:
     *         实现相互转换前提: Dto field name(dto和entry的field name相同并且 类上有@RelMapper) 或 field的@RelMapper(value="Entity field name") 满足其一即可转换
     * @return
     * @throws Exception
     */
    private final S source = this.setSource();
    private final Class<T> targetClazz= (Class<T>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    private final boolean fieldAnnotationPresent = isFieldAnnotationPresent();

    /**
     * 设置转换源
     * @return
     */
    protected abstract S setSource();
        
    /**
     * 判断类上是否有
     * @return
     */
    protected abstract boolean isFieldAnnotationPresent();

    public T convert(){
        return sourceToTarget(this.source,this.targetClazz);
    }

    public static <V>  List listConvert(List<V> sourceList){
        if(CollectionUtils.isEmpty(sourceList)){
            return null;
        }
        if(sourceList.get(0) instanceof AbstractRelationMapper){
            List targetList=new ArrayList<>();
            for (V v:sourceList){
                AbstractRelationMapper mapper=(AbstractRelationMapper)v;
                targetList.add(mapper.convert());
            }
            return targetList;
        }
        return null;
    }

    public<V> S add(V v) {
        if(v==null){
            return (S)this;
        }
        Class<?> sourceClazz = v.getClass();
        String[] shareArray = sourceClazz.getAnnotation(FieldMapper.class).share();
        boolean enAdd=sourceClazz.isAnnotationPresent(FieldMapper.class)&&
                !ArrayUtils.isEmpty(shareArray);
        if(!enAdd){
            return (S)this;
        }
        Field [] sourceFields = sourceClazz.getDeclaredFields();
        List<Field> fieldList = Arrays.asList(sourceFields);
        List<String> fieldNameList=new ArrayList<>();
        fieldList.stream().forEach(field -> fieldNameList.add(field.getName()));
        List<String> shareList = Arrays.asList(shareArray);
        fieldNameList.retainAll(shareList);
        if (fieldNameList.isEmpty()){
            return (S)this;
        }
        Class<? extends AbstractRelationMapper> targetClazz = this.getClass();
        for (String field:fieldNameList){
            Field sourceField = null;
            try {
                sourceField = sourceClazz.getDeclaredField(field);
                sourceField.setAccessible(true);
                Object getField = sourceField.get(v);
                Field targetField = targetClazz.getDeclaredField(field);
                targetField.setAccessible(true);
                targetField.set(this, getField);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return (S)this;
    }

    public static <V,E> List listConvertAndAdd(List<E> sourceList,V v){
        List listConvert = listConvert(sourceList);
        List listConvertAndAdd = listAdd(listConvert, v);
        return listConvertAndAdd;
    }

    public static <V,E> List listAdd(List<E> sourceList,V v){
        if(CollectionUtils.isEmpty(sourceList)){
            return null;
        }
        if(sourceList.get(0) instanceof AbstractRelationMapper){
            List targetList=new ArrayList<>();
            for (E e:sourceList){
                AbstractRelationMapper mapper=(AbstractRelationMapper)e;
                targetList.add(mapper.add(v));
            }
            return targetList;
        }
        return null;
    }

    private final T sourceToTarget(Object source, Class<T> targetClazz) {
        if (source == null) {
            return null;
        }
        Class sourceClazz = source.getClass();
        //判断类上面是否有自定义注解
        boolean existAnnotationClazz =
                this.fieldAnnotationPresent ? sourceClazz.isAnnotationPresent(FieldMapper.class) : targetClazz.isAnnotationPresent(FieldMapper.class);
        if (!existAnnotationClazz) {
            return DTOConverterUtils.commonConverter(source, targetClazz);
        }
        String[] excludeArray = annotationExcludeArray(sourceClazz);
        Map<String, String> fieldMap;
        if (this.fieldAnnotationPresent) {
            fieldMap= annotationFieldMap(sourceClazz);
        }else {
            fieldMap = annotationFieldMap(targetClazz);
        }
        return DTOConverterUtils.complexConverter(source,targetClazz,fieldMap,excludeArray);
    }

    private final Map<String,String> annotationFieldMap(Class clazz){
        Field [] sourceFields = clazz.getDeclaredFields();
        Map<String,String>fieldMap = new HashMap<>();
        if(ArrayUtils.isEmpty(sourceFields)){
            return null;
        }
        for (Field sourceField:sourceFields){
            if(sourceField.isAnnotationPresent(FieldMapper.class)){
                String annotationField=sourceField.getAnnotation(FieldMapper.class).value();
                if(StringUtils.isEmpty(annotationField)){continue;}
                if(this.fieldAnnotationPresent){
                    fieldMap.put(sourceField.getName(),annotationField);
                }else {
                    fieldMap.put(annotationField,sourceField.getName());
                }
            }
        }
        return fieldMap;
    }

    private final String[] annotationExcludeArray(Class<Object> clazz){
        String[] excludes;
        if(!clazz.isAnnotationPresent(FieldMapper.class)){
            return null;
        }
        String[] excludeAnnotations = clazz.getAnnotation(FieldMapper.class).exclude();

        if(!ArrayUtils.isEmpty(excludeAnnotations)){
            excludes=excludeAnnotations;
            return excludes;
        }return null;
    }


}
