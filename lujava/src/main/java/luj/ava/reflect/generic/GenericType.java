package luj.ava.reflect.generic;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Deprecated
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

  static <T> GenericType fromSubclassInstance(T instance, Class<T> parentType) {
    return GenericTypeFromSubclassInstance.SINGLETON.create(instance, parentType);
  }

  <T> Class<T> getTypeArg(int index);
}
