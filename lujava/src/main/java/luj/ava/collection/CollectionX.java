package luj.ava.collection;

import com.google.common.collect.ImmutableSet;
import java.util.Set;

public interface CollectionX {

  static <T> Set<T> nonNull(Set<T> set) {
    return (set == null) ? ImmutableSet.of() : set;
  }
}
