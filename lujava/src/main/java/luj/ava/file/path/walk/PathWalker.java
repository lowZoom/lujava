package luj.ava.file.path.walk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import luj.ava.file.path.PathX;

public enum PathWalker {
  GET;

  public Stream<PathX> walk(Path path) {
    if (!Files.isDirectory(path)) {
      return Stream.empty();
    }

    try {
      return Files.walk(path).map(PathX::of);
    } catch (IOException e) {
      throw new UnsupportedOperationException(e);
    }
  }
}
