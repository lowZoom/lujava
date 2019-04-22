package luj.ava.file.path;

import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.stream.Stream;
import luj.ava.file.path.parent.sibling.ParentSiblingFinder;
import luj.ava.file.path.walk.PathWalker;

final class PathXImpl implements PathX {

  PathXImpl(Path path) {
    _path = path;
  }

  @Override
  public PathX findParentSibling(Consumer<PathType> filter) {
    return new PathXImpl(ParentSiblingFinder.SINGLETON.find(_path, filter));
  }

  @Override
  public Stream<PathX> walk() {
    return PathWalker.SINGLETON.walk(_path);
  }

  @Override
  public String getFileName() {
    return _path.getFileName().toString();
  }

  @Override
  public Path asPath() {
    return _path;
  }

  @Override
  public String toString() {
    return _path.toString();
  }

  private final Path _path;
}
