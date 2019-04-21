package luj.ava.file.path;

import java.nio.file.Path;
import java.util.function.Consumer;
import luj.ava.file.path.parent.sibling.ParentSiblingFinder;

final class PathXImpl implements PathX {

  PathXImpl(Path path) {
    _path = path;
  }

  @Override
  public PathX findParentSibling(Consumer<PathType> filter) {
    return new PathXImpl(ParentSiblingFinder.SINGLETON.find(_path, filter));
  }

  @Override
  public Path asPath() {
    return _path;
  }

  private final Path _path;
}
