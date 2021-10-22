package luj.ava.file.path;

import java.nio.file.FileVisitOption;
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

  /**
   * @see #walk(Function)
   */
  @Deprecated
  Stream<PathX> walk();

  /**
   * @see java.nio.file.Files#walk
   */
  <T> T walk(Function<Stream<PathX>, T> walker);

  /**
   * @see #list(Function)
   */
  @Deprecated
  Stream<PathX> list();

  /**
   * @see java.nio.file.Files#list
   */
  <T> T list(Function<Stream<PathX>, T> lister);

  boolean isDirectory();

  boolean isRegularFile();

  String getFileName();

  String getFileNameWithoutExtenstion();

  /**
   * @return 字节数
   */
  long getSize();

  Path asPath();

  String toString();
}
