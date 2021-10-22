package luj.ava.file.path.walk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import luj.ava.file.path.PathX;

public enum PathLister {
  GET;

  public Stream<PathX> list(Path path) {
    if (!Files.isDirectory(path)) {
      return Stream.empty();
    }

    try {
      return Files.list(path).map(PathX::of);
    } catch (IOException e) {
      throw new UnsupportedOperationException(e);
    }
  }
}
