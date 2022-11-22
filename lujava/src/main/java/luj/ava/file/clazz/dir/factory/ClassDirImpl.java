package luj.ava.file.clazz.dir.factory;

import java.util.stream.Stream;
import luj.ava.file.clazz.dir.ClassDir;
import luj.ava.file.clazz.dir.walk.ClassDirWalker;
import luj.ava.file.path.PathX;

final class ClassDirImpl implements ClassDir {

  @Override
  public ClassLoader getLoader() {
    return _classLoader;
  }

  @Override
  public Stream<Class> walk() {
    return ClassDirWalker.GET.walk(_path, _classLoader).stream();
  }

  ClassLoader _classLoader;

  PathX _path;
}
