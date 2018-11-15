package luj.ava.reflect.generic;

import java.lang.reflect.Field;

public interface GenericType {

  static GenericType fromSubclass(Class<?> subclass) {
    return GenericTypeFromSubclass.SINGLETON.create(subclass);
  }

  static GenericType ofField(Field field) {
    return GenericTypeOfField.SINGLETON.create(field);
  }

  <T> Class<T> getTypeArg(int index);
}
