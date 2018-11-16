package luj.ava.reflect.generic;

import java.lang.reflect.Field;

public interface GenericType {

  static GenericType ofField(Field field) {
    return GenericTypeOfField.SINGLETON.create(field);
  }

  static GenericType fromSubclass(Class<?> subclass) {
    return GenericTypeFromSubclass.SINGLETON.create(subclass);
  }

  <T> Class<T> getTypeArg(int index);
}
