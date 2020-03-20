package abstraction;

public class WBKey extends WBAbstractElement{
    @Override
    public String getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(String value) throws Exception{
        super.setValue(value);
    }

    public WBKey(String value) throws Exception{
        setValue(value);
    }

    @Override
    boolean isValid(String value) {
        ///TODO : contain only [a..Z][1..9]-_
        return super.isValid(value);
    }
}
