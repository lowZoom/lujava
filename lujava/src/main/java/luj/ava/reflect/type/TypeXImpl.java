package luj.ava.reflect.type;

import com.google.common.reflect.TypeToken;

final class TypeXImpl<T> implements TypeX<T> {

  TypeXImpl(TypeToken<T> token) {
    _token = token;
  }

  @Override
  public <T1> TypeX<T1> getSupertype(Class<T1> superclass) {
    return TypeXGetSupertype.SINGLETON.get(_token, superclass);
  }

  @Override
  public <T1> TypeX<T1> getTypeParam(int index) {
    return new TypeXImpl(_token.resolveType(_token.getRawType().getTypeParameters()[index]));
  }

  @Override
  public Class<T> asClass() {
    return (Class<T>) _token.getRawType();
  }

  private final TypeToken<T> _token;
}
