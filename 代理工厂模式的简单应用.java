public interface ISubject {
    public void buyComputer();
}
lass  RealSubject  implements ISubject {
    @Override
    public void buyComputer() {
        System.out.println ("2.��һ̨�����˵���" );
    }
}
public class ProxySubject implements ISubject {
    private ISubject subject;
    public  ProxySubject(ISubject subject){
        this. subject=subject;
    }
    public void produceComputer(){
        System.out.println ("1.���������˵���" );
    }
    public  void  afterSale(){
        System.out.println ("3.�ۺ����" );
    }
    @Override
    public void buyComputer() {
        produceComputer ();
      this. subject. buyComputer ();
      afterSale ();

    }
}
public class Factory {
    public static ISubject getInstance(){
        return new ProxySubject ( new RealSubject () );
    }
}
public class Test {
    public static void main(String[] args) {
        ISubject subject=Factory.getInstance ();
        subject.buyComputer ();
    }
}
