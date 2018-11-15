package luj.ava.reflect.generic;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

enum GenericTypeOfField {
  SINGLETON;

  GenericType create(Field field) {
    return new GenericTypeImpl((ParameterizedType) field.getGenericType());
  }
}
