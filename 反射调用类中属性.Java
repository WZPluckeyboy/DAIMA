package 反射.反射与类操作;
import java.lang.reflect.Field;
class  Person2{
    public int age;
}
public class 反射调用类中属性 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        /*Class<Person> cls=Person.class;
        Person per=  cls.newInstance ();
        //获取指定属性
        Field field=cls.getField ( "age" );
        field.set(per,20);
        System.out.println (field.get ( per ) );
        System.out.println (field.getType () );//取得参数类型
        //获取全部属性
        Field[] fields=cls.getFields ();
        for(Field field2: fields){
            System.out.println (field2 );
        }*/
    }
}