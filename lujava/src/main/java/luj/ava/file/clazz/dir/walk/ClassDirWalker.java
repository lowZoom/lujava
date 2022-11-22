package luj.ava.file.clazz.dir.walk;

import com.google.common.collect.ImmutableList;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import luj.ava.file.clazz.dir.ClassDir;
import luj.ava.file.path.PathX;

public enum ClassDirWalker {
  GET;

  public List<ClassDir.Class> walk(PathX path, ClassLoader loader) {
    Path classDir = path.asPath();
    return path.walk(s -> s
        .filter(PathX::isRegularFile)
        .filter(p -> p.getFileName().endsWith(".class"))
        .map(PathX::asPath)
        .map(p -> toClassName(classDir, p))
        .map(n -> makeClass(n, loader))
        .collect(Collectors.toList()));
  }

  private String toClassName(Path dir, Path clazz) {
    String fullWithExt = ImmutableList.copyOf(dir.relativize(clazz)).stream()
        .map(Path::toString)
        .collect(Collectors.joining("."));

    return CLASS_EXT.matcher(fullWithExt).replaceAll("");
  }

  private ClassImpl makeClass(String name, ClassLoader loader) {
    ClassImpl clazz = new ClassImpl();
    clazz._name = name;
    clazz._classLoader = loader;
    return clazz;
  }

  private static final Pattern CLASS_EXT = Pattern.compile("\\.class$");
}
