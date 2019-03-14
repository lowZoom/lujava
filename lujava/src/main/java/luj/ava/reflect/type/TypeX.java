package luj.ava.reflect.type;

import com.google.common.reflect.TypeToken;

public interface TypeX<T> {

  static <T> TypeX<T> of(Class<T> type) {
    return new TypeXImpl(TypeToken.of(type));
  }

  <T1> TypeX<T1> getSupertype(Class<T1> superclass);

  <T1> TypeX<T1> getTypeParam(int index);

  Class<T> asClass();
}
