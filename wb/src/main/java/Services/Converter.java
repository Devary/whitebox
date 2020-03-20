package Services;

import abstraction.WBObject;
import org.json.simple.JSONObject;

import javax.xml.crypto.dsig.XMLObject;
import java.util.*;

public class Converter extends ParserService implements IConverter {

    public Converter(ConstructorService constructorService) {
        super(constructorService);
    }

    @Override
    public List<String> asArrayList() {
        List<String> arrayList = new ArrayList<>();
        if (!parents.isEmpty())
            getParents().forEach(x -> {
                arrayList.add("p:"+x);
            });
        if (!children.isEmpty())
            getChildren().forEach(x -> {
                arrayList.add("c:"+x);
            });
        return arrayList;
    }

    @Override
    public JSONObject asJson() {
        return null;
    }

    @Override
    public XMLObject asXML() {
        return null;
    }

    @Override
    public String asString() {
        return null;
    }

    @Override
    public WBObject fromXML() {
        return null;
    }

    @Override
    public WBObject fromJson() {
        return null;
    }

    @Override
    public WBObject fromString() {
        return null;
    }

    @Override
    public WBObject fromArrayList() {
        return null;
    }
}
