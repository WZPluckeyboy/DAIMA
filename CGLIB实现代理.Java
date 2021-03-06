package 反射.反射与代理设计模式;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;
//无接口实现动态代理
class  Message{
    public  void send(){
        System.out.println ("www.bit.java.reflact" );
    }
}
class ClassProxy implements MethodInterceptor {
    private  Object target; //真实主题对象
    public ClassProxy(Object target){
        this.target=target;
    }
    public void prehandle(){
        System.out.println ("处理业务前" );
    }
    public void afterhandle(){
        System.out.println ("处理业务后" );
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        this.prehandle ();
        Object ret=method.invoke (this.target,objects);
        this.afterhandle ();
        return ret;
    }
}
public class Test {
    public static void main(String[] args) {
        Message message=new Message ();
        //负责代理关系的代理处理类
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass ( message.getClass () );
        //代理对象，以上就动态配置好类与类之间的关系的代理关系
       enhancer.setCallback ( new ClassProxy ( message ) );
       Message temp= (Message) enhancer.create ();
       temp.send ();
    }

    }