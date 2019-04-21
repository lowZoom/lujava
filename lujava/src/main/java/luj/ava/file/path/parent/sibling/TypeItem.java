package luj.ava.file.path.parent.sibling;

import java.nio.file.Path;
import java.util.function.Predicate;

final class TypeItem {

  TypeItem(String name, Predicate<Path> exists) {
    _name = name;
    _exists = exists;
  }

  public String getName() {
    return _name;
  }

  public Predicate<Path> getExists() {
    return _exists;
  }

  private final String _name;

  private final Predicate<Path> _exists;
}
