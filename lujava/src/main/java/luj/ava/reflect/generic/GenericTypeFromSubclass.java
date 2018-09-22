package luj.ava.reflect.generic;

import java.lang.reflect.ParameterizedType;

enum GenericTypeFromSubclass {

  SINGLETON;

  GenericType create(Class<?> subclass) {
    return new GenericTypeImpl((ParameterizedType) subclass.getGenericSuperclass());
  }
}
