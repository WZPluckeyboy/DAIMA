.自定义Annotation
/*@Retention ( RUNTIME )
@interface MyAnnotation{
  String name() default "zhangsan" ;
  int age() default 10;
}
@MyAnnotation(name="zhangsan",age=40)
@Deprecated
class  Member implements Serializable{
  public String toString(){
    System.out.println ("this is a Member" );
    return "this is a Member";
  }
}
public class 反射取得Annotation {
  public static void main(String[] args) {
    Annotation[] ant = Member.class.getAnnotations ( );
    for (Annotation a : ant) {
      System.out.println ( a );
    }
  }
}