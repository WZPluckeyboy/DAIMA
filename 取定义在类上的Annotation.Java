1.取定义在类上的所有Annotation
@SuppressWarnings ( value = "serial")
@Deprecated
class  Member implements Serializable{
    public String toString(){
        System.out.println ("this is a Member" );
        return "this is a Member";
    }
}
public class Test {
    public static void main(String[] args) {
        Annotation[] ant= Member.class.getAnnotations ();
        for(Annotation a: ant){
            System.out.println (a );
        }
    }
}