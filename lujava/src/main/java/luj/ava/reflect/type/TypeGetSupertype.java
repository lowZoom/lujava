package luj.ava.reflect.type;

import com.google.common.reflect.TypeToken;

enum TypeGetSupertype {
  SINGLETON;

  <T> TypeX<T> get(TypeToken<T> token, Class<T> superclass) {
    return new TypeXImpl<>(token.getSupertype(superclass));
  }
}
