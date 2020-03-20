package Services;

import java.util.HashMap;

public interface IParserService {
    boolean validateFile();
    void parseParents();
    void parseChildren();
    void parseComments();
    void parse();

}
