package luj.ava.stream;

import java.util.Collection;
import java.util.stream.Stream;

public interface StreamX<T> {

  static <T> Stream<T> from(Collection<T> c) {
    return (c == null) ? Stream.empty() : c.stream();
  }
}
