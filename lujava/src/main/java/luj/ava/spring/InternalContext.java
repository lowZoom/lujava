package luj.ava.spring;

public interface InternalContext {

  interface Factory {

    static InternalContext create(Class<?> config) {
      return new InternalContextImpl(config);
    }
  }

  <T> T getRootBean(Class<T> beanType);
}
