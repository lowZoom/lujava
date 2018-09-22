package luj.ava.reflect.generic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class GenericTypeFromSubclassTest {

  GenericTypeFromSubclass _sut;

  @Before
  public void setUp() {
    _sut = GenericTypeFromSubclass.SINGLETON;
  }

  @Test
  public void create_() {
    //-- Arrange --//

    //-- Act --//
    GenericType result = _sut.create(Subclass.class);

    //-- Assert --//
    assertThat(result.getTypeArg(0)).isSameAs(String.class);
  }

  @SuppressWarnings("unused")
  class Superclass<T> {
    // NOOP
  }

  class Subclass extends Superclass<String> {
    // NOOP
  }
}
