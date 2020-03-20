package abstraction;

import java.rmi.server.UID;
import java.util.UUID;

public class WBAbstractElement {
    UUID id =  UUID.randomUUID();
    boolean isValid;
    public String value;


    public String getValue() {
        return value;
    }

    public void setValue(String value) throws Exception {
        this.value = value;
    }

    public WBAbstractElement() {
    }

    boolean isValid(String value)
    {
        ////check if match to element criteria
        return true;
    }


}
