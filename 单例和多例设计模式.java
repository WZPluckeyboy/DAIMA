һ���������ģʽ�ķ��ࣺ
1.����ʽ�������ģʽ��
���磺class Singleton {
private  static  Singleton  INSTANCE=new Singleton();
private Singleton(){
System.out.println ("singleton.init()" );
}
public  static Singleton getInstance(){
return INSTANCE;
}
public void print(){
System.out.println ("Singleton.getInstance ()" );
System.out.println ("Hello Word" );
    }
}
public class Mac{
public static void main(String[] args) {
Singleton singleton =null;
singleton=Singleton.getInstance ();
singleton.print ();
}
}
2.����ʽ�������ģʽ
���磺class Singleton{
private  static Singleton instance;
private Singleton(){
System.out.println ("singleton.init()" );
}
public  static Singleton getInstance(){
if(instance==null){
instance=new Singleton ();
}
return instance;
}
public void print(){
System.out.println ("Singleton.getInstance ()" );
}
}
public  class Mac{
public static void main(String[] args) {
Singleton singleton=null;
singleton=Singleton.getInstance ();
singleton.print ();
}
}
�����������ģʽ
����;class Sex{
private  String title;
public   static final int MALE_FLAG=1;
public   static  final int FEMALE_FLAG=2;
private  static  final Sex  MALE=new Sex("��");
private  static  final Sex FEMALE=new Sex("Ů");
private  Sex(String title){
this.title=title;
}
public static Sex getInstance(int flag){
switch(flag){
case MALE_FLAG:
return MALE;
case FEMALE_FLAG:
return  FEMALE;
default:
return null;
}
}
public String tostring(){
return this.title;
}
}
public class Mac{
public static void main(String[] args) {
Sex male=Sex.getInstance (Sex.MALE_FLAG );
System.out.println ("male" );
}
}
