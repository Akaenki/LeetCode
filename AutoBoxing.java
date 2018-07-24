public class AutoBoxing {
    public static void main(String[] args) {
        double a = 1.0%0, b = 1.0%0; //NaN;
        System.out.println(a == b); //flase;
        Double x = new Double(a), y = new Double(b);
        System.out.println(x.equals(y)); //true;
        a = 0.0; b = -0.0;
        System.out.println(a == b); //true;
        x = new Double(a); y = new Double(b);
        System.out.println(x.equals(y)); //false;
    }
}