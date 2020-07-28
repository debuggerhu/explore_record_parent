package com.hhx.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;

/**
 * 改为使用mapStruct
 */
@Deprecated
public class Global {

    /**
     * 将源对象的值复制到新的对象并返回新的对象
     *
     * @param source      源对象
     * @param targetClass 新对象的class
     * @param <T>         新对象类型
     * @return 新对象
     */
    public static <T> T convertObject(Object source, Class<T> targetClass) {
        try {
            T target = targetClass.newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isObjectBlank(Object object) {
        return Arrays.stream(object.getClass().getDeclaredFields()).allMatch(field -> {
            field.setAccessible(true);
            try {
                if (field.get(object) == null) {
                    return true;
                } else {
                    if (field.getType().getSimpleName().equals("String")) {
                        return StringUtils.isBlank(field.get(object).toString());
                    } else {
                        return false;
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return false;
            }
        });
    }

}
