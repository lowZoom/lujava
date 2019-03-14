package luj.ava.reflect.type;

import com.google.common.reflect.TypeToken;

enum TypeXGetSupertype {
  SINGLETON;

  <T> TypeX<T> get(TypeToken<?> token, Class<T> superclass) {
    return new TypeXImpl(token.getSupertype((Class) superclass)) ;
  }
}
