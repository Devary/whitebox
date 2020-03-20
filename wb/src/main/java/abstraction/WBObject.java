package abstraction;

import java.security.Key;
import java.time.Instant;
import java.util.Date;

public class WBObject {
    private WBType type;
    private WBKey key;
    private WBValue value;
    private Date creationDate;
    private Date deletetionDate;
    private Date modificationDate;

    public WBObject(WBType type, WBKey key, WBValue value) {
        this.type = type;
        this.key = key;
        this.value = value;
        this.creationDate = Date.from(Instant.now());
        this.deletetionDate = null;
        this.modificationDate = null;
    }

    public WBType getType() {
        return type;
    }

    public void setType(WBType type) {
        this.type = type;
    }

    public WBKey getKey() {
        return key;
    }

    public void setKey(WBKey key) {
        this.key = key;
    }

    public WBValue getValue() {
        return value;
    }

    public void setValue(WBValue value) {
        this.value = value;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getDeletetionDate() {
        return deletetionDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }
}

