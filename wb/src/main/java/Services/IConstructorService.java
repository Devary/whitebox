package Services;

import java.io.File;
import java.io.IOException;

public interface IConstructorService {
    StringBuilder getFileContent(File file) throws IOException;
    void writeIn(String text,File file);
    boolean validateFilePath(String filePath);
    boolean generateFile(String fileName, String filePath);
}
