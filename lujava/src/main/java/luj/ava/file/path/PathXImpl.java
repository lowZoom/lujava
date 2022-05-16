package luj.ava.file.path;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.function.Function;
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
    Path result = ParentSiblingFinder.GET.find(_path, filter);
    return result == null ? PathXNull.INSTANCE : new PathXImpl(result);
  }

  @Override
  public PathX resolve(String first, String... more) {
    return new PathXImpl(_path.resolve(Paths.get(first, more)));
  }

  @Override
  public Stream<PathX> walk() {
    return PathWalker.GET.walk(_path);
  }

  @Override
  public <T> T walk(Function<Stream<PathX>, T> walker) {
    Stream<PathX> stream = PathWalker.GET.walk(_path);
    T result = walker.apply(stream);
    stream.close();
    return result;
  }

  @Override
  public Stream<PathX> list() {
    return PathLister.GET.list(_path);
  }

  @Override
  public <T> T list(Function<Stream<PathX>, T> lister) {
    Stream<PathX> stream = PathLister.GET.list(_path);
    T result = lister.apply(stream);
    stream.close();
    return result;
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
    Path fileName = _path.getFileName();
    return fileName == null ? "" : fileName.toString();
  }

  @Override
  public String getFileNameWithoutExtenstion() {
    String fileName = getFileName();
    if (isDirectory()) {
      return fileName;
    }
    int dotIndex = fileName.lastIndexOf('.');
    return (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
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
  public PathX getParent() {
    Path parent = _path.getParent();
    return parent == null ? PathXNull.INSTANCE : new PathXImpl(parent);
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
