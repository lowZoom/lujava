package luj.ava.file.clazz.dir.factory;

import java.nio.file.Path;
import java.nio.file.Paths;
import luj.ava.file.clazz.dir.ClassDir;
import luj.ava.file.path.PathX;

public enum ClassDirFactory {
  GET;

  public ClassDir create(String path) {
    return create(Paths.get(path));
  }

  public ClassDir create(Path path) {
    ClassDirImpl dir = new ClassDirImpl();
    dir._classLoader = new DynamicClassLoader(getClass().getClassLoader(), path);
    dir._path = PathX.of(path);
    return dir;
  }
}
