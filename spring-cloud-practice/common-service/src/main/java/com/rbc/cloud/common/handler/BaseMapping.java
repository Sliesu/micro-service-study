package com.rbc.cloud.common.handler;

import org.mapstruct.AfterMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * MapStruct 通用映射
 *
 * @param <S>
 * @param <T>
 */
public interface BaseMapping<S, T> {

    /**
     * 正向映射
     *
     * @param obj
     * @return
     */
    @InheritConfiguration
    T convertTo(S obj);

    /**
     * 反向映射
     *
     * @param obj
     * @return
     */
    @InheritInverseConfiguration(name = "convertTo")
    S convertFrom(T obj);

    /**
     * 正向映射（List)
     *
     * @param list
     * @return
     */
    default List<T> convertTo(List<S> list) {
        if (list == null) {
            return null;
        }

        List<T> result = new ArrayList<T>(list.size());
        for (S s : list) {
            if (s == null) {
                continue;
            }
            result.add(convertTo(s));
        }

        return result;
    }

    /**
     * 反向映射（List)
     *
     * @param list
     * @return
     */
    default List<S> convertFrom(List<T> list) {
        if (list == null) {
            return null;
        }

        List<S> result = new ArrayList<S>(list.size());
        for (T t : list) {
            if (t == null) {
                continue;
            }
            result.add(convertFrom(t));
        }

        return result;
    }

    /**
     * 正向映射的后置处理
     *
     * @param src
     * @param dest
     */
    @AfterMapping
    default void handleAfterConvertTo(S src, @MappingTarget T dest) {
        afterConvertTo(src, dest);
    }

    /**
     * 反向映射的后置处理
     *
     * @param src
     * @param dest
     */
    @AfterMapping
    default void handleAfterConvertFrom(T src, @MappingTarget S dest) {
        afterConvertFrom(src, dest);
    }

    /**
     * 正向映射的后置处理
     *
     * @param src
     * @param dest
     */
    default void afterConvertTo(S src, T dest) {
        //TODO 覆盖此方法处理其他复杂转换逻辑
    }

    /**
     * 反向映射的后置处理
     *
     * @param src
     * @param dest
     */
    default void afterConvertFrom(T src, S dest) {
        //TODO 覆盖此方法处理其他复杂转换逻辑
    }

    /**
     * 正向映射（stream)
     *
     * @param stream
     * @return
     */
    @InheritConfiguration(name = "convertTo")
    Stream<T> convertTo(Stream<S> stream);

    /**
     * 反向映射（stream)
     *
     * @param stream
     * @return
     */
    @InheritConfiguration(name = "convertFrom")
    Stream<S> convertFrom(Stream<T> stream);

}
