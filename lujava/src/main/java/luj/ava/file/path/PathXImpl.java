package luj.ava.file.path;

import static com.google.common.base.Preconditions.checkNotNull;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;
import luj.ava.file.path.parent.sibling.ParentSiblingFinder;
import luj.ava.file.path.walk.PathWalker;

final class PathXImpl implements PathX {

  PathXImpl(Path path) {
    _path = checkNotNull(path);
  }

  @Override
  public PathX findParentSibling(Consumer<PathType> filter) {
    return new PathXImpl(ParentSiblingFinder.SINGLETON.find(_path, filter));
  }

  @Override
  public PathX resolve(String first, String... more) {
    return new PathXImpl(_path.resolve(Paths.get(first, more)));
  }

  @Override
  public Stream<PathX> walk() {
    return PathWalker.SINGLETON.walk(_path);
  }

  @Override
  public boolean isDirectory() {
    return Files.isDirectory(_path);
  }

  @Override
  public boolean isRegularFile() {
    return Files.isRegularFile(_path);
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
