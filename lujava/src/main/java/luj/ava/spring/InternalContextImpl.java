package luj.ava.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(includeFilters = @ComponentScan.Filter(Internal.class))
final class InternalContextImpl implements InternalContext {

  InternalContextImpl(Class<?> config) {
    _config = config;
  }

  @Override
  public <T> T getRootBean(Class<T> beanType) {
    try (AnnotationConfigApplicationContext appCtx =
        new AnnotationConfigApplicationContext(InternalContextImpl.class, _config)) {
      return appCtx.getBean(beanType);
    }
  }

  private final Class<?> _config;
}
