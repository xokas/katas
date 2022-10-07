public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int a = 1;
        changeValue(a);
        System.out.println(a);

        String b = "1";
        changeValue(b);
        System.out.println(b);

        String c = "1";
        changeValueReference(c);
        System.out.println(c);

        String d = "1";
        changeValueReference2(d);
        System.out.println(d);

        ReferenceString e = new ReferenceString("1");
        changeValueReference3(e);
        System.out.println(e);
    }

    private static void changeValue(int a) {
        a = 2;
    }

    private static void changeValue(String b) {
        b = "2";
    }

    private static void changeValueReference(String c){
        c = new String("2");
    }

    private static void changeValueReference2(String d){
        d.concat("c");
    }

    private static void changeValueReference3(ReferenceString e){
        e.setValue("2");
    }
}
