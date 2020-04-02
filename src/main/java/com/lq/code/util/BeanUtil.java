package com.lq.code.util;

import com.lq.code.dto.QueueDto;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by qi_liang on 2018/1/29.
 * @author qi
 */
public class BeanUtil {

    public final static Logger LOGGER = LoggerFactory.getLogger(BeanUtil.class);

    public static final String FILE_SYMBOL = "/";

    /**
     *  获取类属性，包括父类属性
     * @param clazz
     */
    public static List<Field> getAllField(Class clazz){
        Field[] fields = getField(clazz);
        List<Field> fieldList = new ArrayList<>();
        Field[] superFields = getSuperField(clazz);
        if (superFields!=null&&superFields.length>0){
            for (Field field:superFields) {
                fieldList.add(field);
            }
        }
        if (fields!=null&&fields.length>0){
            for (Field field:fields){
                fieldList.add(field);
            }
        }
        return fieldList;
    }

    /**
     * 获取类属性
     * @param clazz
     * @return
     */
    public static Field[] getField(Class clazz){

        return clazz.getDeclaredFields();
    }

    /**
     *  获取父类的属性
     * @param clazz
     * @return
     */
    public static Field[] getSuperField(Class clazz){

        return clazz.getSuperclass().getDeclaredFields();
    }

    /**
     *  复制属性，不为空的复制，为空忽略
     */
    public static void copyNotNull(Object targer,Object source){

        Class sourceClass = source.getClass();
        List<Field> fieldList  = getAllField(sourceClass);
        Map<String,Field> fieldMap = new HashMap<>(fieldList.size());
        for (Field field: fieldList){
            field.setAccessible(true);
            fieldMap.put(field.getName(),field);
        }
        Class targerClass = targer.getClass();
        List<Field> targerFieldList = getAllField(targerClass);
        for (Field field:targerFieldList){
            field.setAccessible(true);
            Field targerField = fieldMap.get(field.getName());
            //判断类型是否相等
            if (targerField!=null&&targerField.getGenericType().toString().equals(field.getGenericType().toString())){
                try {
                    PropertyDescriptor pd = new PropertyDescriptor(targerField.getName(), targerClass);
                    //获得写方法
                    Method wM = pd.getWriteMethod();
                    Object value =  targerField.get(source);
                    if (value!=null) {
                        wM.invoke(targer, value);
                    }
            } catch (Exception e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }

    }

    /**
     *  通过反射获取属性的数据类型
     *  key 属性名
     *  value  类型
     * @param fields
     * @return
     */
    public static Map<String,String> getFiledType(Field[] fields){
        Map<String,String> map=new HashMap<>(fields.length);
        for (Field field:fields){
            map.put(field.getName(),field.getGenericType().toString());
        }
        return map;
    }

    public static List<Map<String,String>> getFileInfo(Field[] fields){
        List<Map<String,String>> list=new ArrayList<>();
        for (Field field:fields){
            Map<String,String> map = new HashMap(2);
            map.put("fieldName",field.getName());
            map.put("fieldType",field.getGenericType().toString());
            list.add(map);
        }
        return list;
    }

    /**
     *  返回属性名列表
     * @param fields
     * @return
     */
    public static List<String> getFiledName(Field[] fields){
        List<String> filedNameList=new ArrayList<>(fields.length);
        for (Field field:fields){
            filedNameList.add(field.getName());
        }
        return filedNameList;
    }

    /**
     *  返回属性类型列表
     * @param fields
     * @return
     */
    public static List<String> getFileTypeList(Field[] fields){
        List<String> fileTypeList=new ArrayList<>(fields.length);
        for (Field field:fields){
            fileTypeList.add(field.getGenericType().toString());
        }
        return fileTypeList;
    }

    /**
     *  获取包下面的class集合
     * @param packagePath
     * @return
     */
    public static Set<Class> getClassSet(String packagePath){

        Set<Class> set = new HashSet<>();
        String separator = File.separator;
        String filePath = packagePath.replace(".",separator);
        String classPath = BeanUtil.class.getResource(FILE_SYMBOL).getPath()+filePath;
        File file = new File(classPath);
        if (file.exists()){
            File[] files = file.listFiles();
            try {
                for (File classFile:files){
                    String className = classFile.getName().split("\\.")[0];
                    Class clazz =Class.forName(packagePath+"."+className);
                    set.add(clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    /**
     * 扫描包路径，并返回一个队列class
     * @param packagePath
     * @return
     */
    public static QueueDto<Class> getQueueDto(String packagePath){
        QueueDto<Class> classQueueDto = new QueueDto<>();
        String separator = File.separator;
        String filePath = packagePath.replace(".",separator);
        String classPath = BeanUtil.class.getResource(FILE_SYMBOL).getPath()+filePath;
        File file = new File(classPath);
        if (file.exists()){
            File[] files = file.listFiles();
            try {
                for (File classFile:files){
                    String className = classFile.getName().split("\\.")[0];
                    Class clazz =Class.forName(packagePath+"."+className);
                    classQueueDto.add(clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            }
        }
            return classQueueDto;
    }

    public static String getEntityName(Class entityClazz){
        String entityPath=entityClazz.getName();
        String [] entityNameArray=entityPath.split("\\.");
        String entityName=entityNameArray[entityNameArray.length-1];
        return entityName;
    }

    /**
     *  判断对象是否该与类型一致
     * @param obj
     * @param clazzType
     * @return
     */
    public static Boolean isType(Object obj,Class clazzType){

        if (obj!=null) {
            Class clazz = obj.getClass();
            return clazz.getTypeName().equals(clazzType.getTypeName()) ? true : false;
        }
        else{
            return false;
        }
    }


    /**
     *  判断对象是否为空 ,为空返回true
     * @param object
     * @return
     */
    public boolean isNull(Object object){

        return object==null;
    }

}
