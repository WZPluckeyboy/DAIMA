/*格式：
public static  返回值 方法名称（[参数类型 参数名称],[参数类型...参数名称]{
}
* */
public class 可变参数编程 {
public static int add(int...data){
 int result =0;
 for(int i=0;i<data.length;i++){
 result +=data[i];
  }
        return  result;
    }
    public static void main(String[] args) {
        System.out.println (add(3,5,7) );
        System.out.println (add(4,5,7,89,9 ,8));
    }
}