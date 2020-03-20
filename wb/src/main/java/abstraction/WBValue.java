package abstraction;

public class WBValue extends WBAbstractElement {

    public WBValue(String value) throws Exception{
        if (isValid(value))
        setValue(value);
    }

    @Override
    public boolean isValid(String value) {

        ///TODO : contain only [a..Z][1..9]-_
        return super.isValid(value);
    }

}
