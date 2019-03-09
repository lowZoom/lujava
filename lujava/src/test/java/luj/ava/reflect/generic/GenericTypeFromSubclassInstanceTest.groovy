package luj.ava.reflect.generic

import spock.lang.Specification

class GenericTypeFromSubclassInstanceTest extends Specification {

  Object _instance

  Class _type

  void setup() {
    _instance = new Test()
  }

  def "Create:直接父类"() {
    given:
    _type = GA1

    when:
    def result = create()

    then:
    result.getTypeArg(0) == Integer
  }

  GenericType create() {
    return GenericTypeFromSubclassInstance.SINGLETON.create(_instance, _type)
  }

  interface GA<A, B> {
    // 顶层泛型类
  }

  interface GA1<T> extends GA<String, T> {
    // 次级泛型类
  }

  class CA {
    // 非泛型类，干扰项
  }

  interface CB {
    // 非泛型类，干扰项
  }

  class Test extends CA implements GA1<Integer>, CB {
    // 被测类
  }
}
