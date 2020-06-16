package luj.ava.file.path;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;
import luj.ava.file.path.parent.sibling.ParentSiblingFinder;
import luj.ava.file.path.walk.PathLister;
import luj.ava.file.path.walk.PathWalker;

final class PathXImpl implements PathX {

  PathXImpl(Path path) {
    _path = checkNotNull(path);
  }

  @Override
  public PathX findParentSibling(Consumer<PathType> filter) {
    Path result = ParentSiblingFinder.SINGLETON.find(_path, filter);
    return result == null ? PathXNull.SINGLETON : new PathXImpl(result);
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
  public Stream<PathX> list() {
    return PathLister.SINGLETON.list(_path);
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
  public long getSize() {
    try {
      return Files.size(_path);

    } catch (IOException e) {
      throw new UnsupportedOperationException(e);
    }
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
