package il.co.mywork.crud.filemonitor;

import il.co.mywork.crud.Crud;
import il.co.mywork.crud.filecrud.FileCrud;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class LocalStreamEventHandler implements EventHandler {
    private String outFilePath = "./src/il/co/mywork/crud/filecrud/syslog_backup.txt";
    private String fileToObserve;
    private BufferedReader reader;
    private Crud<Integer, String> crud;

    public LocalStreamEventHandler(String directoryPath, String fileToObserve) throws IOException {
        this.fileToObserve = fileToObserve;
        crud = new FileCrud(outFilePath);
        reader = new BufferedReader(new FileReader(directoryPath + "/" + fileToObserve));
    }

    @Override
    public void accept(Path changedFile) {
        if (changedFile.endsWith(fileToObserve)) {
            try {
                String data;

                /* read each line, add it to backup file with newline */
                while ((data = reader.readLine()) != null) {
                    crud.create(data);
                }
            } catch (IOException ignored) {}
        }
    }
}
