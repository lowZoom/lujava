package luj.ava.collection.map;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

final class MapBuilderImpl<K, V> implements MapX.Builder<K, V> {

  MapBuilderImpl(ImmutableMap.Builder<K, V> builder) {
    _builder = builder;
  }

  @Override
  public MapX.Builder<K, V> put(K key, V value) {
    if (value != null) {
      _builder.put(key, value);
    }
    return this;
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  @Override
  public <M extends Map<K, V>> M build(Class<? extends Map> mapType) {
    return (M) _builder.build();
  }

  private final ImmutableMap.Builder<K, V> _builder;
}
