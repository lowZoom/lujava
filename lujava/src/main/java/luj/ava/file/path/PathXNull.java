package luj.ava.file.path;

import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.stream.Stream;

enum PathXNull implements PathX {
  SINGLETON;

  @Override
  public PathX findParentSibling(Consumer<PathType> filter) {
    return this;
  }

  @Override
  public PathX resolve(String first, String... more) {
    return this;
  }

  @Override
  public Stream<PathX> walk() {
    return Stream.empty();
  }

  @Override
  public Stream<PathX> list() {
    return Stream.empty();
  }

  @Override
  public boolean isDirectory() {
    return false;
  }

  @Override
  public boolean isRegularFile() {
    return false;
  }

  @Override
  public String getFileName() {
    return null;
  }

  @Override
  public long getSize() {
    return 0;
  }

  @Override
  public Path asPath() {
    return null;
  }
}
