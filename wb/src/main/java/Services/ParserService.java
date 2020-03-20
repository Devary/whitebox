package Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParserService implements IParserService {
    public ArrayList<String> parents = null;
    public ArrayList<String> children = null;
    public ArrayList<String> comments = null;
    public ConstructorService constructorService;
    private boolean isValidationRequired;
    File file = null;

    public ParserService(ConstructorService constructorService) {
        this.isValidationRequired = true;
        parents = new ArrayList<>();
        children = new ArrayList<>();
        comments = new ArrayList<>();
        this.constructorService = constructorService;
        file = this.constructorService.getFile();
        parse();
    }

    @Override
    public boolean validateFile() {
        if (isValidationRequired)
        {
            //todo : validaion with regex
        }
        //to be removed after updating validation
        return true;
    }

    @Override
    public void parseParents() {

    }

    @Override
    public void parseChildren() {

    }

    @Override
    public void parseComments() {

    }

    @Override
    public void parse() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            final String[] str = new String[1];
            reader.lines().forEach(x->{
                /*if (x.startsWith("#"))
                    str[0] = x.replace("#","");
                comments.add(str[0]);
                 */
                String[] split = x.split(":");
                if (!x.equals("") && !x.startsWith("#") )
                {
                    if (split[0].equals("c"))
                    {
                        children.add(split[1]);
                    }
                    else
                    {
                        parents.add(split[1]);
                    }
                }

            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getParents() {
        return parents;
    }

    public void setParents(ArrayList<String> parents) {
        this.parents = parents;
    }

    public ArrayList<String> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<String> children) {
        this.children = children;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }
}
