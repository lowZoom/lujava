package luj.ava.file.path;

import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.stream.Stream;

public interface PathX {

  static PathX of(Path path) {
    return new PathXImpl(path);
  }

  PathX findParentSibling(Consumer<PathType> filter);

  Stream<PathX> walk();

  String getFileName();

  Path asPath();
}
