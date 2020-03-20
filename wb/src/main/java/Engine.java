import Services.ConstructorService;
import Services.IConstructorService;

public class Engine {
    boolean isFileCreated;
    boolean isIsfileModified;
    boolean isfileRemoved;
    AbstractFile file;



    public Engine(AbstractFile file) {
        this.file = file;
    }

    public Engine() {
    }

    public boolean isFileCreated() {
        return isFileCreated;
    }

    public void setFileCreated(boolean fileCreated) {
        isFileCreated = fileCreated;
    }

    public boolean isIsfileModified() {
        return isIsfileModified;
    }

    public void setIsfileModified(boolean isfileModified) {
        isIsfileModified = isfileModified;
    }

    public boolean isIsfileRemoved() {
        return isfileRemoved;
    }

    public void setIsfileRemoved(boolean isfileRemoved) {
        this.isfileRemoved = isfileRemoved;
    }

    public AbstractFile getFile() {
        return file;
    }

    public void setFile(AbstractFile file) {
        this.file = file;
    }


    private ConstructorService getConstructorServiceInstance()
    {
        return ConstructorService.newInstance();
    }

}
