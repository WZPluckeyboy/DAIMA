һ�������쳣�����ʽ
1.public class Mac{
public static void main(String[] args) {
System.out.println ("[1].��ѧ���㿪ʼǰ" );
try{
System.out.println ("2.������ѧ���㣺"+10/0 );
}
catch(ArithmeticException e){
System.out.println  ("�쳣�ѱ�����" );
System.out.println ("3.��ѧ�������" );
}
}
2.  public class Mac{
public static void main(String[] args) {
 System.out.println ("[1].��ѧ���㿪ʼǰ" );
 try{
 System.out.println ("2.������ѧ���㣺"+10/0 );
        }
        catch(ArithmeticException e){
3.public class Mac{
    public static void main(String[] args) {
        System.out.println ("[1].��ѧ���㿪ʼǰ" );
        try{
            System.out.println ("2.������ѧ���㣺"+10/0 );
        }
        catch(ArithmeticException e){
            e.printStackTrace ();
        }
        finally {
            System.out.println ("[finally]�����Ƿ��쳣����ִ�д����" );
        }
        System.out.println ("3.��ѧ�������" );
    }
}
4.public class Mac {
    public static void main(String[] args) {
        System.out.println ( "[1].��ѧ���㿪ʼǰ" );
        try {
            int x = Integer.parseInt ( args[0] );
            int y = Integer.parseInt ( args[1] );
            System.out.println ( "[2].������ѧ���㣺" + x / y );
        } catch (ArithmeticException e) {
            e.printStackTrace ( );
        } finally {
            System.out.println ( "[finally]�����Ƿ��쳣����ִ�д����" );
        }
        System.out.println ( "3.��ѧ�������" );
    }
}
����throws�ؼ���(�������׳��쳣��
public class Mac{
    public static int calculate(int x,int y)throws Exception{
        return x/y;
    }
    public static void main(String[] args)throws Exception{
        System.out.println (calculate ( 10,0 ) );
    }
}
            e.printStackTrace ();
        }
        System.out.println ("3.��ѧ�������" );
    }
}
����throw �ؼ��֣���ֱ�ӱ�д������У���ʾ��Ϊ�쳣���׳�
public class Mac{
    public static void main(String[] args) {
        try{
            throw new Exception ( "�׳��쳣���棡" );
        }
        catch(Exception e){
            e.printStackTrace ();
        }
    }
}
  