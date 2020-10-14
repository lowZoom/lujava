package luj.ava.collection.map;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

public interface MapX<K, V> extends Map<K, V> {

  interface Builder<K, V> {

    Builder<K, V> put(K key, V value);

    @SuppressWarnings("rawtypes")
    <M extends Map<K, V>> M build(Class<? extends Map> mapType);
  }

  static <K, V> Builder<K, V> builder() {
    return new MapBuilderImpl<>(ImmutableMap.builder());
  }

  @SuppressWarnings("unchecked")
  static <K, V> Map<K, V> copyOf(Object[][] entries) {
    ImmutableMap.Builder<K, V> builder = ImmutableMap.builder();
    for (Object[] entry : entries) {
      builder.put((K) entry[0], (V) entry[1]);
    }
    return builder.build();
  }

  static <K, V> Map<K, V> nonNull(Map<K, V> map) {
    return (map == null) ? ImmutableMap.of() : map;
  }
}
