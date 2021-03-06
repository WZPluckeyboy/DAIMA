import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
//先定义一个自定义注解
@Retention ( RUNTIME )
@interface  MyAnnotation1{
    public Class<?> target3() ;
}
interface  IFruite{
    public  void eat() ;
}
class Apple implements IFruite{
    @Override
    public void eat() {
        System.out.println ("吃一个苹果！" );
    }
}
@MyAnnotation1(target3 = Apple.class)
class Factory{
    public static <T> T getIntance() throws IllegalAccessException, InstantiationException {
      MyAnnotation1 mt =Factory.class.getAnnotation (MyAnnotation1.class) ;
      return (T)mt.target3().newInstance();
    }
}
public class Annotation与工厂设计模式 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        IFruite fruite=Factory.getIntance ();
      fruite.eat ();
    }
}