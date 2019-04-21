package luj.ava.file.path.parent.sibling;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import luj.ava.file.path.PathType;

public enum ParentSiblingFinder {
  SINGLETON;

  public Path find(Path startPath, Consumer<PathType> filter) {
    TypeItem sibling = getSiblingCond(filter);
    Path cursor = startPath.getParent();

    while (cursor != null) {
      Path result = findImpl(cursor, sibling);
      if (result != null) {
        return result;
      }
      cursor = cursor.getParent();
    }
    return null;
  }

  private TypeItem getSiblingCond(Consumer<PathType> filter) {
    List<TypeItem> result = new ArrayList<>();
    TypeImpl input = new TypeImpl(result);
    filter.accept(input);
    return result.get(0);
  }

  private Path findImpl(Path parent, TypeItem sibling) {
    Path path = parent.resolve(sibling.getName());
    if (!sibling.getExists().test(path)) {
      return null;
    }
    return path;
  }
}
