package luj.ava.collection;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.List;
import java.util.Set;

public interface CollectionX {

  static <T> List<T> nonNull(List<T> list) {
    return (list == null) ? ImmutableList.of() : list;
  }

  static <T> Set<T> nonNull(Set<T> set) {
    return (set == null) ? ImmutableSet.of() : set;
  }
}
