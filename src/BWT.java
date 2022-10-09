public class BWT {

    private String str;
    private int position;
    public BWT(String str, int position) {
        this.str = str;
        this.position = position;
    }

    public int hashCode(){
        return new StringBuilder(this.str).append(position).toString().hashCode();
    }

    public boolean equals(Object b){
        return this.hashCode() == b.hashCode();
    }
}
