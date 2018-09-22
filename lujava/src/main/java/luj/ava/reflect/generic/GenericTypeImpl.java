package luj.ava.reflect.generic;

import java.lang.reflect.ParameterizedType;

final class GenericTypeImpl implements GenericType {

  GenericTypeImpl(ParameterizedType type) {
    _type = type;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> Class<T> getTypeArg(int index) {
    return (Class<T>) _type.getActualTypeArguments()[index];
  }

  private final ParameterizedType _type;
}
