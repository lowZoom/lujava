package luj.ava.reflect.generic;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface GenericType {

  static GenericType of(Type type) {
    return new GenericTypeImpl((ParameterizedType) type);
  }

  static GenericType ofField(Field field) {
    return of(field.getGenericType());
  }

  static GenericType fromSubclass(Class<?> subclass) {
    return of(subclass.getGenericSuperclass());
  }

  <T> Class<T> getTypeArg(int index);
}
