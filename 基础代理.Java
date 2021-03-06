package 反射.反射与代理设计模式;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
interface  ISubject{
    public void eat();
}
class  realSubject implements ISubject{  //主要业务
    @Override
    public void eat() {
        System.out.println ("饿了要吃饭" );
    }
}
 class ProxySubject implements ISubject{
    private ISubject subject;
    public  ProxySubject(ISubject subject){
        this.subject=subject;
    }
    public void prepare(){
        System.out.println ("准备吃饭" );
    }
    public  void afterEat(){
        System.out.println ("洗刷刷" );
    }
     @Override
     public void eat() {
        this.prepare ();
        this.subject.eat ();//
        this.afterEat ();
     }
 }
 class  Factory {
     private Factory() {
     }
     //方法一：
     public static <T> T getInstance(String realClassName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
         Class cls = Class.forName ( realClassName );
         return (T) cls.newInstance ( );
     }

     public static <T> T getInstance(String proxyClassName, Object targent) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
         Class cls1 = Class.forName ( proxyClassName );
         Constructor constructor = cls1.getConstructor ( cls1.getInterfaces ( )[0] );
         return (T) constructor.newInstance ( targent );
     }
     public static <T> T getInstance(String proxyClassName, String realClassName) {
         T realObject= null;
         try {
             realObject = Factory.getInstance ( realClassName );
         } catch (ClassNotFoundException e) {
             e.printStackTrace ( );
         } catch (IllegalAccessException e) {
             e.printStackTrace ( );
         } catch (InstantiationException e) {
             e.printStackTrace ( );
         }
         T proxyObject= null;
         try {
             proxyObject = Factory.getInstance ( proxyClassName,realObject );
         } catch (ClassNotFoundException e) {
             e.printStackTrace ( );
         } catch (NoSuchMethodException e) {
             e.printStackTrace ( );
         } catch (IllegalAccessException e) {
             e.printStackTrace ( );
         } catch (InvocationTargetException e) {
             e.printStackTrace ( );
         } catch (InstantiationException e) {
             e.printStackTrace ( );
         }
         return proxyObject;

     }
 }
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException {
        //方法一的测试
        /*ISubject subject= subject = Factory.getInstance ("反射.反射与代理设计模式.ProxySubject"
                    ,Factory.getInstance ( "反射.反射与代理设计模式.realSubject" ) );
        subject.eat();*/
        //方法二测试
ISubject subject=Factory.getInstance ( "反射.反射与代理设计模式.ProxySubject",
        "反射.反射与代理设计模式.realSubject" );
subject.eat ();
    }
}
