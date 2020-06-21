package il.co.mywork.crud.filemonitor;

import java.nio.file.Path;

public interface EventHandler {
    void accept(Path changedFile);
}
