package luj.ava.reflect.generic;

public interface GenericType {

  static GenericType fromSubclass(Class<?> subclass) {
    return GenericTypeFromSubclass.SINGLETON.create(subclass);
  }

  <T> Class<T> getTypeArg(int index);
}
