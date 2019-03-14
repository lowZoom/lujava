package luj.ava.reflect.type

import com.google.common.reflect.TypeToken
import spock.lang.Specification

class TypeXGetSupertypeTest extends Specification {

  TypeToken _token

  Class _superclass

  void setup() {
  }

  def "Get:"() {
    given:
    _token = TypeToken.of(CA)
    _superclass = IA

    when:
    def result = get()

    then:
    result.asClass() == IA
  }

  TypeX get() {
    return TypeXGetSupertype.SINGLETON.get(_token, _superclass)
  }

  private interface IA {

  }

  private interface IAA extends IA {

  }

  private class CA implements IAA {

  }
}
