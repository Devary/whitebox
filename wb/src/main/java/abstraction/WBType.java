package abstraction;

public class WBType extends WBAbstractElement {
    private static final String[] types = {"comment","child","parent"};

    public WBType(String typeName) throws Exception{
        setValue(typeName);
    }


    private boolean typeExists(String typeName)
    {
        for (String type : types) {
            if (typeName.equals(type))
                return true;
        }
        return false;
    }

    @Override
    public String getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(String value) throws Exception  {
        if (typeExists(value))
            this.value = value;
        else
            throw new Exception("TYPE '"+ value +"' DOES NOT EXIST");
    }

    @Override
    boolean isValid(String value) {
        return super.isValid(value);
    }
}
