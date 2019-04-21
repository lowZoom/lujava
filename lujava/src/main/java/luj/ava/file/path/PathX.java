package luj.ava.file.path;

import java.nio.file.Path;
import java.util.function.Consumer;

public interface PathX {

  static PathX of(Path path) {
    return new PathXImpl(path);
  }

  PathX findParentSibling(Consumer<PathType> filter);

  Path asPath();
}
