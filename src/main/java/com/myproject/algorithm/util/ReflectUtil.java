package com.myproject.algorithm.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectUtil {

    private static Map<String, Class> classCache = new ConcurrentHashMap<>();

    /**
     * 为 Class.forName 添加缓存
     *
     * @param className
     * @return
     */
    public static Class getClass(String className) {
        return classCache.computeIfAbsent(className, v -> {
            try {
                return Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    /**
     * 获取父类上泛型列表
     *
     * @param classType
     * @return
     */
    public static Type[] getSuperClassActualTypes(Class classType) {
        Type genericSuperclass = classType.getGenericSuperclass();
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
    }

    /**
     * 根据索引获取父类上的泛型
     *
     * @param classType
     * @param index
     * @return
     */
    public static Type getSuperClassActualType(Class classType, int index) {
        Type[] superClassActualTypes = getSuperClassActualTypes(classType);
        return superClassActualTypes[index];
    }

}
