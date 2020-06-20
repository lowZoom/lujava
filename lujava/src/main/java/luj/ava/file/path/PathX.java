package luj.ava.file.path;

import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public interface PathX {

  static PathX of(Path path) {
    return new PathXImpl(path);
  }

  PathX findParentSibling(Consumer<PathType> filter);

  PathX resolve(String first, String... more);

  @Deprecated
  Stream<PathX> walk();

  <T> T walk(Function<Stream<PathX>, T> walker);

  Stream<PathX> list();

  boolean isDirectory();

  boolean isRegularFile();

  String getFileName();

  String getFileNameWithoutExtenstion();

  long getSize();

  Path asPath();
}
