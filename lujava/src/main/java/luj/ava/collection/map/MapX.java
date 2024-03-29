package luj.ava.collection.map;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.function.Function;

public interface MapX<K, V> extends Map<K, V> {

  interface Builder<K, V> {

    Builder<K, V> put(K key, V value);

    Map<K, V> build();

    @SuppressWarnings("rawtypes")
    <M extends Map<K, V>> M build(Class<? extends Map> mapType);
  }

  static <K, V> Builder<K, V> builder() {
    return new MapBuilderImpl<>(ImmutableMap.builder());
  }

  @SuppressWarnings("unchecked")
  static <K, V> Map<K, V> copyOf(Object[][] entries) {
    return copyOf(entries, k -> (K) k);
  }

  @SuppressWarnings("unchecked")
  static <K, V> Map<K, V> copyOf(Object[][] entries, Function<Object, K> keyMaker) {
    ImmutableMap.Builder<K, V> builder = ImmutableMap.builder();
    for (Object[] entry : entries) {
      Object value = entry[1];
      if (value == null) {
        continue;
      }
      builder.put(keyMaker.apply(entry[0]), (V) value);
    }
    return builder.build();
  }

  static <K, V> Map<K, V> nonNull(Map<K, V> map) {
    return (map == null) ? ImmutableMap.of() : map;
  }
}
