package luj.ava.reflect.type;

import com.google.common.reflect.TypeToken;
import java.lang.reflect.Type;

public interface TypeX<T> {

  static <T> TypeX<T> of(Class<T> type) {
    return of((Type) type);
  }

  static <T> TypeX<T> of(Type type) {
    return new TypeXImpl<>(TypeToken.of(type));
  }

  @SuppressWarnings("unchecked")
  static <T> TypeX<T> ofInstance(T instance) {
    return of((Class<T>) instance.getClass());
  }

  boolean isAssignableTo(Class<?> clazz);

  <T1> TypeX<T1> getSupertype(Class<T1> superclass);

  <T1> TypeX<T1> getTypeParam(int index);

  Class<T> asClass();
}
