public class Test {
    public static String reverseSentence(String str) {
        StringBuffer sb = new StringBuffer(str).reverse();
return sb.toString ();
    }
    public static void main(String[] args) {
        String str="i am biter ";
        String restr=reverseSentence ( str );
        System.out.println ("逆置后字符串为："+restr );
    }