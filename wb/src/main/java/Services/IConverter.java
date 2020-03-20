package Services;

import abstraction.WBObject;
import org.json.simple.JSONObject;

import javax.xml.crypto.dsig.XMLObject;
import java.util.List;

public interface IConverter {
    //TODO : implement all methods
    public List<String> asArrayList();
    public JSONObject asJson();
    public XMLObject asXML();
    public String asString();

    public WBObject fromXML();
    public WBObject fromJson();
    public WBObject fromString();
    public WBObject fromArrayList();

}
