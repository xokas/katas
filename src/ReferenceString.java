public class ReferenceString{
    private String value;

    public ReferenceString(String s) {
        this.value = s;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString(){
        return this.value;
    }
}
