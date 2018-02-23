package com.snippets.spring.commons.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Objects;

public class ValidateUtils {

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void validateEnum(Class<? extends Enum> c, Collection<String> es, String message) {
        try {
            for (String string : es) {
                Enum.valueOf(c, string);
            }
        } catch (Exception e2) {
            throw new RuntimeException(message);
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void validateEnum(Class<? extends Enum> c, String e, String message) {
        try {
            Enum.valueOf(c, e);
        } catch (Exception e2) {
            throw new RuntimeException(message);
        }
    }

    public static void validateEmpty(Object[] objects, String message) {
        if (objects == null || objects.length == 0) {
            throw new RuntimeException(message);
        }
    }

    public static void validateNotEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isNotEmpty(collection)) {
            throw new RuntimeException(message);
        }
    }

    public static void validateEmpty(Collection<?> collection, String message) {
        if (collection == null || collection.isEmpty()) {
            throw new RuntimeException(message);
        }
    }

    public static void validateNotEquals(Object a, Object b, String message) {
        if (!Objects.equals(a, b)) {
            throw new RuntimeException(message);
        }
    }

    public static void validateEquals(Object a, Object b, String message) {
        if (Objects.equals(a, b)) {
            throw new RuntimeException(message);
        }
    }

    public static void validateNotTrue(Boolean b, String message) {
        if (!b) {
            throw new RuntimeException(message);
        }
    }

    public static void validateTrue(Boolean b, String message) {
        if (b) {
            throw new RuntimeException(message);
        }
    }

    public static void validateBlank(String value, String message) {
        if (StringUtils.isBlank(value)) {
            throw new RuntimeException(message);
        }
    }

    public static void validateNotNull(Object value, String message) {
        if (Objects.isNull(value)) {
            throw new RuntimeException(message);
        }
    }

    private static void validateNull(Object value, String message) {
        if (Objects.isNull(value) || StringUtils.isBlank(value.toString())) {
            throw new RuntimeException(message);
        }
    }

    public static <T> void validateContains(Collection<T> collection, T t, String message) {
        validateNull(collection, message);
        if (collection.contains(t)) {
            throw new RuntimeException(message);
        }
    }

    public static <T> void validateNotContain(Collection<T> collection, T t, String message) {
        validateNull(collection, message);
        if (!collection.contains(t)) {
            throw new RuntimeException(message);
        }
    }
}
