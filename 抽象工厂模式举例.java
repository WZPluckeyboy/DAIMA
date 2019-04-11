package ���󹤳�ģʽ;

public interface Computer {
    void printComputer();
}
class MacbookProcComputer implements Computer{
    @Override
    public void printComputer() {
        System.out.println ("����һ��ƻ�����ԣ�" );

    }
}
class SurfacebookComputer implements  Computer{
    @Override
    public void printComputer() {
        System.out.println ("����һ�������˱ʼǱ����ԣ�" );

    }
}
interface  OperateingSystem{
    void printSystem();
}
class MacSystem implements OperateingSystem{
    @Override
    public void printSystem() {
        System.out.println ("����һ��ƻ��ϵͳ��" );
    }
}
class SurfaceSystem implements OperateingSystem{

    @Override
    public void printSystem() {
        System.out.println ("����һ��������ϵͳ��" );
    }
}
interface ProductionFactory{
    Computer createComputer();
    OperateingSystem createSystem();

}
class AppleFactory implements ProductionFactory{
    @Override
    public Computer createComputer() {
        return new MacbookProcComputer ();
    }
    @Override
    public OperateingSystem createSystem() {
        return new MacSystem ();
    }
}
 class AlineFactory implements ProductionFactory{

     @Override
     public Computer createComputer() {
         return new SurfacebookComputer ();
     }

     @Override
     public OperateingSystem createSystem() {
         return new SurfaceSystem ();
     }
 }
 class Client{
    public  void buyComputer(Computer computer){
        computer.printComputer ();
    }
    public void use(OperateingSystem s){
        s.printSystem ();
    }
}
public class Test {
    public static void main(String[] args) {
     ProductionFactory factory=new AppleFactory ();
     Client client =new Client ();
     client.buyComputer ( factory.createComputer () );
     client.use ( factory.createSystem() );

        };

    }
