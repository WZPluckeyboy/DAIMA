һ��������
�����ࣺ�������󷽷�����  abstract  ����
1�������಻���Ա�ʵ����==�� Person p = new Person("bit",10);
2�����һ���ǳ�����̳��˳����࣬��ô����������д�������
 ���󷽷���
3������ǳ�����̳��˳����࣬��ô��Ϊ������ĳ�������Բ�ʵ��
  ���������ķ�����
4��private   abstract   ����ͬʱ����    final :����  ��
5��public > protected > ������Ȩ�� > private
��д������ʱ��
������ķ���Ȩ��һ��Ҫ���ڵ��ڻ���ķ���Ȩ��
 6��������������԰����ǳ��󷽷���
����ģ�����ģʽ
����ԭ��OPC����һ�����ʵ�����ࡢģ��ͺ���Ӧ�ö��⿪�š����޸Ĺرա�
ģ��ģʽ�ǳ������һ��ʵ��Ӧ�ó�����
�������������ǶԳ������Լ�ģ��˭ģʽ��Ӧ�ã�
���Ϲ�����̣�
1.�����Ʒ
2.ѡ����Ʒ
3.�ͷ���ѯ
4.����
5.֧��
6.����
7.�鿴����
import java.util.Scanner;
abstract class  OnlineShopping{
    public final void  BrowseGoods(){
        System.out.println ("1.�����Ʒ" );
    }
    public  final void SelectGoods(){
        System.out.println ("2.ѡ����Ʒ" );
    }
    public  abstract void CallService();
    public  final  void ComputerPrice(){
        System.out.println ("4.����" );
    }
    public abstract void OuderPay();
    public abstract  void SendService();
    public boolean isCallService(){
        return true;
    }
     final void process(){
        BrowseGoods();
        SelectGoods();
        if(isCallService()) {
            CallService ();
        }
         ComputerPrice();
        OuderPay();
        SendService();
    }
   }
   class Skycat extends OnlineShopping {
       @Override
       public void CallService() {
           System.out.println ( "3.���ã���è�ͷ�Ϊ�����" );
       }
       @Override
       public void OuderPay() {
           System.out.println ( "5.΢��֧��" );
       }
       @Override
       public void SendService() {
           System.out.println ( "6.Բͨ���ͣ�" );
       }

       public String Answer() {
           System.out.println ( "�Ƿ���Ҫ�ͷ����� �ǣ�y   ���ǣ�n" );
           Scanner scanner = new Scanner ( System.in );
           String str = scanner.nextLine ( );
           return str;
       }
       public boolean isCallService() {
           String str = Answer ( );
           if (str.equals ( "y" )) {
               return true;
           }
           else return false;
       }
   }
public class ������� {
    public static void main(String[] args) {
        Skycat sktcat=new Skycat();
        sktcat.process ();
    }
}
����ҵ������;
1.ȡ��
2.�����ҵ��
3.ҵ������
import java.util.Scanner;
abstract class BankTemplate1 {
public  final void takeNumber(){
    System.out.println ("1.ȡ��" );
}
public  abstract void  transact();
public abstract void evaluate();
public   boolean isEvaluate(){
    return  true;
}
 public    void  process() {
     takeNumber();
     transact();
     if(isEvaluate ()) {
         evaluate();
     }
 }
 }
 class User1 extends  BankTemplate1{
    @Override
    public void transact() {
        System.out.println ("2.���" );
    }
    @Override
    public void evaluate() {
        System.out.println ("3.ҵ������" );
    }
    public String Answer(){
        System.out.println ("�Ƿ���Ҫҵ�����ۣ� �ǣ�y     ��n" );
        Scanner scanner=new Scanner ( System.in );
        String str=scanner.nextLine ();
        return str;
    }
    public boolean isEvaluate(){
        String str=Answer ();
        if(str.equals ( "y" )){
            return true;
        }
        else return false;
    }
}
class User2 extends  BankTemplate1{
    @Override
    public void transact() {
        System.out.println ("2.ȡ��" );
    }
    @Override
    public void evaluate() {
        System.out.println ("3.ҵ������" );
    }
    public String Answer(){
        System.out.println ("�Ƿ���Ҫҵ�����ۣ� �ǣ�y     ��n" );
        Scanner scanner=new Scanner ( System.in );
        String str=scanner.nextLine ();
        return str;
    }
    public   boolean isEvaluate(){
        String str=Answer ();
        if(str.equals ( "y" )){
            return true;
        }
        else return false;
    }
}
public  class BankTemplate{
    public static void main(String[] args) {
        BankTemplate1 user1=new User1();
        user1.process ();
        System.out.println ("�ͻ�1�ѷ�����" );
        BankTemplate1 user2=new User2();
        user2.process ();

    }
}
