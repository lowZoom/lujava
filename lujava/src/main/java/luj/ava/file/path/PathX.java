package luj.ava.file.path;

import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.stream.Stream;

public interface PathX {

  static PathX of(Path path) {
    return new PathXImpl(path);
  }

  PathX findParentSibling(Consumer<PathType> filter);

  PathX resolve(String first, String... more);

  Stream<PathX> walk();

  Stream<PathX> list();

  boolean isDirectory();

  boolean isRegularFile();

  String getFileName();

  long getSize();

  Path asPath();
}
