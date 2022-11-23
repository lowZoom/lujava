package luj.ava.reflect.type;

import com.google.common.reflect.TypeToken;

final class TypeXImpl<T> implements TypeX<T> {

  TypeXImpl(TypeToken<?> token) {
    _token = token;
  }

  @Override
  public boolean isAssignableTo(Class<?> clazz) {
    return clazz.isAssignableFrom(asClass());
  }

  @SuppressWarnings("unchecked")
  @Override
  public <P> TypeX<P> getSupertype(Class<P> superclass) {
    return TypeGetSupertype.SINGLETON.get((TypeToken<P>) _token, superclass);
  }

  @Override
  public <T1> TypeX<T1> getTypeParam(int index) {
    return new TypeXImpl<>(_token.resolveType(_token.getRawType().getTypeParameters()[index]));
  }

  @SuppressWarnings("unchecked")
  @Override
  public Class<T> asClass() {
    return (Class<T>) _token.getRawType();
  }

  @Override
  public String toString() {
    return _token.toString();
  }

  private final TypeToken<?> _token;
}
