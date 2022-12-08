package luj.ava.stream;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public interface StreamX<T> {

  static <T> Stream<T> from(Collection<T> c) {
    return (c == null) ? Stream.empty() : c.stream();
  }

  /**
   * @see java.util.Optional#stream
   */
  @Deprecated
  static <T> Stream<T> from(Optional<T> o) {
    return o.map(Stream::of).orElseGet(Stream::empty);
  }
}
