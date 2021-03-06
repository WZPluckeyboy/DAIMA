面向对象编程-类与对象
1.⾯面向对象三⼤大特征
封装性：所谓封装，也就是把客观事物封装成抽象的类，并且类可以把⾃自⼰己的数据和⽅方法只让可信
的类或者对象操作，对不不可信的进⾏行行信息隐藏。简⽽而⾔言之就是，内部操作对外部⽽而⾔言不不可⻅见(保护
性)
继承性：继承是指这样⼀一种能⼒力力：它可以使⽤用现有类的所有功能，并在⽆无需重新编写原来的类的情
况下对这些功能进⾏行行扩展。
多态性：所谓多态就是指⼀一个类实例例的相同⽅方法在不不同情形有不不同表现形式。多态机制使具有不不同
内部结构的对象可以共享相同的外部接⼝口。（利利⽤用多态可以得到良好的设计）
2.面向对象名词扩展:
OOA：⾯面向对象分析
OOD：⾯面向对象设计
OOP：⾯面向对象编程
3.对象的初始化需要两步：
一、为对象开辟内存；
二、调用合适的构造函数（构造函数不止一个，构造函数可以发生重载）
4.对象属性的初始化方式有三种：
一、提供一系列的get和set方法（必须全为public形式)
二、提供合适的构造函数；
三、静态代码块和实例代码块。（静态代码块只会被初始化一次）；
四、对象的初始化顺序：先静态——实例代码块——构造函数；
五、static修饰的不依赖于对象。
6.对象的内存分析；
栈内存（虚拟机局部变量量表）：存放的是局部变量量（包含编译期可知的各种基本数据类型、对象引
⽤用-即堆内存的地址，可以简单的理理解为对象的名称），Java栈是与线程对应起来的，每当创建⼀一
个线程，JVM就会为这个线程创建⼀一个对应的Java栈。
堆内存：保存的是真正的数据，即对象的属性信息。
7.构造方法遵循的原则：
一.⽅方法名称必须与类名称相同
二.构造⽅方法没有返回值类型声明
三.每⼀个类中⼀一定⾄至少存在⼀一个构造⽅方法（没有明确定义，则系统⾃自动⽣生成⼀一个⽆无参构造）
8.构造方法的分类;
一、无参构造；
二、有参构造。
9.
一、this关键字
1. this调⽤用本类属性
2. this调⽤用本类⽅方法
3. this表示当前对象的引用
二、使⽤用this调⽤用构造⽅方法时请注意：
1. this调⽤用构造⽅方法的语句句必须在构造⽅方法⾸⾏
2. 使⽤用this调⽤用构造⽅方法时，请留留有出⼝；
10.内部类:
一、分类：静态内部类、本地内部类、匿名内部类、实例内部类
import java.sql.SQLOutput;

/**
 * 内部类：
 * 1.静态内部类
 * 2.实力内部类
 * 3.方法内部类
 * 4.匿名内部类
 */
/*class Test{
       public int data1=10;
        private int data2=20;
        int data3=30;//包访问权限
        public static int data4=40;
         public Test(){
             System.out.println ("OuterClass" );
        }
        public void function(){       //外部类方法
            System.out.println ("OuterClass.function" );
        }
        class InnerClass{
             public int data1=10;
             public  static final int A=100;
             public InnerClass(){
                 System.out.println ("InnerClass.init" );
             }
             public void fun1(){
                 System.out.println (data1 );
                 System.out.println (Test.this.data1 );//外部类数据的调用
                 System.out.println ("fun1" );
             }
        }
    }

public class 内部类 {
    public static void main(String[] args) {
        Test outer=new Test();   //实例化外部类
      Test.InnerClass innerClass=outer.new InnerClass ();   //实例化内部类得到内部类，内部类不能定义静态数据，因为先初始化静态代码块，处理顺序矛盾。但加final可以
        innerClass.fun1 ();
       // Test.InnerClass  int=new Test.InnerClass ();静态内部类访问方法，用外部类访问
    }
}*/

11.static
被static所修饰的代码块或函数不属于类，执行时会首先执行，调用时要用类名调用
12.继承（extends）作用为为了代码块的重用是（is-a）的关系；
13派生类继承了基类除构造函数外的一切，构造函数可通过super调用；
14.super的三种形式：super（），super.data，super.fun()；
15.向上转型：把派生类的对象赋给基类，如（Person p=new Student())
16.重写：函数名相同，参数列表相同，返回值相同（协变类型：返回值之间可以构成继承关系）；
17.多态:基类引用，引用了派生类对象，并且基类和派生类有同名的覆盖方法；
18.被final所修饰的类不允许被继承
19.实力内部类拥有外部类的this引用，因此有额外的内存消耗
20.//以上笔记的所有引例：
import java.sql.SQLOutput;

/*class Test{
    public int data1=10;
    public static int data2=20;
    static{
        data2=99;
        System.out.println ("static" );
    }
    {
        data1=100;
        System.out.println ("intance");
    }
}
public class Test2 {
    public static void main(String[] args) {
        Test test = new Test ( );  //实例化代码块
        System.out.println ( test.data1 );
        System.out.println ( test.data2 );
    }
}*///可以看出静态数据和静态代码块谁放在前面谁先被执行，动态数据与动态代码块亦如此，动态代码块与静态代码块都是用来初始化对象的例如（静态代码块初始化data2的，因此运行结果为data2=99；


/*class Person {
    private String name;
    private int age;
    public   int data = 10;
    public static int count=0;
    static{           //静态代码块只能用静态数据，不需调用可打印    ，初始化对象时，先静态代码块，再实例代码块，最后运行构造函数
        count=100;
        System.out.println("static{}");
    }
    {      //实例代码块（不能访问静态数据）
        this.data=99;
        System.out.println("instance{}");
    }
    public Person(String name,int age) {  //有参构造函数
        this.name = name;
        this.age = age;
        System.out.println("Person.init(String,int)");
    }

}
public class Test2{
    public static void main(String[] args) {
        Person person=new Person();  //实例化代码块


    }
}
*/

/*三、块静态代码和实例代码块(静态代码块只初始化一次)
class Person {
    private String name;
    private int age;
    public   int data = 10;
    public static int count=0;
    static{           //静态代码块只能用静态数据，不调用可打印
        count=100;
        System.out.println("static{}");
    }
    {//实例代码块（不能访问静态数据）
       this.data=99;
        System.out.println("instance{}");
    }


}
public class Test2{
    public static void main(String[] args) {
        Person person=new Person();
        System.out.println (person );

    }
}
*/

/*
//二.通过构造函数。（作用为初始化对象的)
// *    对象的产生需要以下2步：
// *         1、为对象开辟内存
// *         2、调用合适的构造函数---》构造函数不止一个。
class Person {
    private String name;
    private int age;
    public int data = 10;
    public static int count = 0;//静态用类明调例如（int n=Person.count)在方法区
    public Person(){
     this(name,age)//调用其他构造函数
        System.out.println("Person.init()");//不带有参数的构造函数
    }
    public Person(String name,int age) {  //有参构造函数
        this.name = name;
        this.age = age;
        System.out.println("Person.init(String,int)");
    }

    public static void function() {      //静态函数只能用类名调用
        System.out.println("Person.static.function()");
    }

}
public class Test2{
    public static void main(String[] args) {
        int n=Person.count;
        System.out.println (n );//静态不属于类，只能用类名调用
        Person.function();//用类名调用静态函数
        this.function();//调用类中不是静态的函数



        Person person =new Person();//实例化对象
        System.out.println (person );//打印无参构造函数
        Person person2 =new Person("bit",10); //实例化对象
        System.out.println (person2 );//有参构造函数打印

    }
}*/







//一.set/get方法
/*
class Person {
    private String name;
    private int age;

    public void getPersonInfo() {
        System.out.println ( "姓名：" + name + "年龄：" + age );
    }
    public void setAge(int age){
        this.age=age;
    }
    public int  getAge(){
        return age;
    }
    public void setName(String name){
        this.name=name;
    }
    public  String getName(){
        return name;
    }
}
public class Test2{
    public static void main(String[] args) {
        Person person =new Person();
        person.setName ( "bit" );
        person.setAge(10);
        System.out.println (  person.getName());
        System.out.println (  person.getAge());
    }
}*/