package com.jie.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: wugong.jie
 * \* Date: 2018/2/24 9:43
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ClassParam {

    public static void getParameters(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.toGenericString());// private java.lang.Long com.jie.bean.User.id
            System.out.println(field.getGenericType());// class java.lang.Long
            System.out.println(field.getType());// class java.lang.Long
            System.out.println(field.getName());// id
        }
    }

    public static String getTypeDesc(Class<?> clazz) {
        StringBuffer fieldStr = new StringBuffer();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String[] fieldDescArr = field.toGenericString().split(" ");
            if (fieldDescArr.length == 3) {
                String fieldDesc = fieldDescArr[1];
                fieldStr.append(fieldDesc + ";");
            }
        }
        return fieldStr.toString();
    }

    /**
     * 判断传入的数据类型是否是可以直接使用的类型:基本数据类型/包装数据类型
     * @Author wugong
     * @Date 2018/2/24 13:24
     * @Modify if true,please enter your name or update time
     * @params
     */
    public static boolean isNormalType(Class<?> clazz){
        String[] genericStrArr = clazz.toGenericString().split(",");
        if(genericStrArr.length==3){
            return isNormalType(genericStrArr[1]);
        }
        return true;
    }

    /**
     * 是否是普通类型：基本数据类型/包装类型/还是引用类型
     * @Author wugong
     * @Date 2018/2/24 11:47
     * @Modify if true,please enter your name or update time
     * @params
     */
    public static boolean isNormalType(String fieldDesc){
        if(fieldDesc.contains("List")){
            return false;
        }else if(fieldDesc.contains("Map")){
            return false;
        }else{
            try {
                // 如果是基本数据类型
                if(Class.forName(fieldDesc).isPrimitive()){
                    return true;
                    // 如果不是基本数据类型，则判断是否包装数据类型/String
                }else if(isSpecialType(fieldDesc)){
                    return true;
                }else{
                    return false;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 判断是包装类型还是应用类型
     * @Author wugong
     * @Date 2018/2/24 11:40
     * @Modify if true,please enter your name or update time
     * @params
     */
    public static boolean isSpecialType(String typeDesc){
        List<String> typeList = new ArrayList<>();
        typeList.add("java.lang.Integer");
        typeList.add("java.lang.Double");
        typeList.add("java.lang.Float");
        typeList.add("java.lang.Long");
        typeList.add("java.lang.Short");
        typeList.add("java.lang.Byte");
        typeList.add("java.lang.Boolean");
        typeList.add("java.lang.Character");
        typeList.add("java.lang.String");
        return typeList.contains(typeDesc);
    }

    /**
     * 获取基本类型、包装类型、String类型的参数类型与对应的值
     *
     * @Author wugong
     * @Date 2018/2/24 10:57
     * @Modify if true,please enter your name or update time
     * @params
     */
    public static String getFieldsNormalKVDesc(Object obj) {
        StringBuffer fieldStr = new StringBuffer();
        Field[] fields = obj.getClass().getDeclaredFields();
        String[] types = {"java.lang.Integer",
                "java.lang.Double",
                "java.lang.Float",
                "java.lang.Long",
                "java.lang.Short",
                "java.lang.Byte",
                "java.lang.Boolean",
                "java.lang.Character",
                "java.lang.String",
                "int", "double", "long", "short", "byte", "boolean", "char", "float"};
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                for (String str : types) {
                    if (f.getType().getName().equals(str))
                        fieldStr.append(f.getName())
                                .append("(").append(f.getType().getName()).append(")").
                                append(":").append(f.get(obj));
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return fieldStr.toString();
    }

    public static void getFieldsValue(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        /**
         * 基本类型、包装类型、String类型
         */
        String[] types = {"java.lang.Integer",
                "java.lang.Double",
                "java.lang.Float",
                "java.lang.Long",
                "java.lang.Short",
                "java.lang.Byte",
                "java.lang.Boolean",
                "java.lang.Character",
                "java.lang.String",
                "int", "double", "long", "short", "byte", "boolean", "char", "float"};
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                for (String str : types) {
                    if (f.getType().getName().equals(str))
                        System.out.println("字段：" + f.getName() + " 类型为：" + f.getType().getName() + " 值为：" + f.get(obj));
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}