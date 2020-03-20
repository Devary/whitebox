package Services;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstructorService implements IConstructorService{
    private File file;
    private static String WB_EXTENSION = ".wb";
    private String FILE_LOCATION_PATTERN = "^(?:[\\w]\\:(\\[a-z_\\-\\s0-9\\.]+)*)";
    private String REMOTE_LOCATION_PATTERN = "\\\\[a-z_\\-\\s0-9\\.]+(\\[a-z_\\-\\s0-9\\.]+)+";

    private Pattern locationPattern = Pattern.compile(FILE_LOCATION_PATTERN);
    private boolean isValidationEnabled;

    public static ConstructorService newInstance() {

        return new ConstructorService();
    }
    @Override
    public boolean generateFile(String fileName, String filePath)
    {
        if ( isValidationEnabled() && !validateFilePath(filePath))
        {
            return false;
        }
        String fileString = fileName+WB_EXTENSION;
        if (null != filePath)
        {
            fileString = filePath+"/"+fileString;
        }
        File newFile = new File(fileString);
        try {
            newFile.getParentFile().mkdirs();
            if (newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
            } else {
                System.out.println("File already exists.");
            }
            setFile(newFile);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public boolean validateFilePath(String filePath)
    {
        boolean isValid = false;
        if (null== filePath)
            return isValid;
        Matcher locationMatcher = locationPattern.matcher(filePath);
        if (locationMatcher.matches()) {
            return isValid;
        }

        locationPattern = Pattern.compile(REMOTE_LOCATION_PATTERN);
        locationMatcher = locationPattern.matcher(filePath);

        return locationMatcher.matches();
    }

    @Override
    public void writeIn(String text,File file)
    {
        FileWriter writer = null;
        try {
            writer = new FileWriter(file.getAbsolutePath());
            writer.write(text);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public StringBuilder getFileContent(File file) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            reader.lines().forEach(x->{
                stringBuilder.append(x);
                stringBuilder.append("\n");
            });
           //clean
            stringBuilder.replace(stringBuilder.lastIndexOf("\n"),stringBuilder.lastIndexOf("\n")+1,"");
            reader.close();
            return stringBuilder;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    boolean isValidationEnabled()
    {
        return this.isValidationEnabled;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setValidationEnabled(boolean validationEnabled) {
        isValidationEnabled = validationEnabled;
    }
}
