package luj.ava.file.clazz.dir;

import java.util.stream.Stream;

public interface ClassDir {

  interface Class {

    String getName();

    java.lang.Class<?> load();
  }

  ClassLoader getLoader();

  Stream<Class> walk();
}
