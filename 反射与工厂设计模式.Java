package 反射;
interface  IFuit{
    void eat();
}
class Apple implements IFuit{
    @Override
    public void eat() {
        System.out.println ("吃苹果" );
    }
}
class Orange implements IFuit{
    @Override
    public void eat() {
        System.out.println ("吃橘子" );
    }
}
class FruitFactory{
 private FruitFactory(){
 }
public static IFuit getFuitInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
 Class classz =  Class.forName ( className );
  return (IFuit) classz.newInstance ();
    }
}


public class 反射与工厂模式 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException { ;
        IFuit fuit=FruitFactory.getFuitInstance ( "反射.Apple" );
        fuit.eat ();
    }
}

