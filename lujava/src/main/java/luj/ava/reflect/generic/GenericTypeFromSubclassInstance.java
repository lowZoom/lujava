package luj.ava.reflect.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

enum GenericTypeFromSubclassInstance {
  SINGLETON;

  GenericType create(Object instance, Class<?> parentType) {
    return GenericType.of(findType(instance.getClass(), parentType));
  }

  private Type findType(Type cursor, Class<?> target) {
    Class<?> cursorClass = asClass(cursor);
    if (cursorClass == target) {
      return cursor;
    }

    return Arrays.stream(cursorClass.getGenericInterfaces())
        .map(parent -> findType(parent, target))
        .filter(Objects::nonNull)
        .findAny()
        .orElse(null);
  }

  private Class<?> asClass(Type type) {
    if (!(type instanceof ParameterizedType)) {
      return (Class<?>) type;
    }
    ParameterizedType paramType = (ParameterizedType) type;
    return (Class<?>) paramType.getRawType();
  }
}
