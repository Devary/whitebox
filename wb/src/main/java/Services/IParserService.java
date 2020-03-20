package Services;

import java.util.ArrayList;
import java.util.HashMap;

public interface IParserService {
    public boolean validateFile();
    public void parseParents();
    public void parseChildren();
    public void parseComments();
    public void parse();

}
