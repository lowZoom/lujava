package luj.ava.file.path.parent.sibling;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import luj.ava.file.path.PathType;

final class TypeImpl implements PathType {

  TypeImpl(List<TypeItem> itemList) {
    _itemList = itemList;
  }

  @Override
  public void file(String name) {
    addItem(name, Files::isRegularFile);
  }

  @Override
  public void dir(String name) {
    addItem(name, Files::isDirectory);
  }

  private void addItem(String name, Predicate<Path> exists) {
    _itemList.add(new TypeItem(name, exists));
  }

  private final List<TypeItem> _itemList;
}
