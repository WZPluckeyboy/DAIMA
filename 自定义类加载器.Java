import java.io.*；
import java.io.IOException;
//自定义类加载器
 class MyClassLoader extends ClassLoader {
     //把类名变成数组
    private  byte[] loadData(String className) throws IOException {
        String classpath = "D:\\";    //环境变量的配置
        String classFile = classpath + className.replace(".", "\\\\") + ".class";
        FileInputStream in = new FileInputStream(classFile);
        ByteArrayOutputStream out = new ByteArrayOutputStream() ;
        byte[] buff = new byte[1024];
        int len = -1;
        while ((len = in.read(buff)) != -1) {
            out.write(buff, 0, len);
        }
        byte[] byteCodeData = out.toByteArray();
        return byteCodeData;
    }
    public Class loadClasses(String className) throws IOException {
        byte[] byteCodeData = loadData(className);//
        //Class类 -> Class文件 -> ByteCode二进制流
        return super.defineClass(className, byteCodeData, 0, byteCodeData.length);
    }
    }
public class TestMyClassLoader {
        public static void main(String[] args) throws IOException {
            MyClassLoader myClassLoader = new MyClassLoader();
            Class member1Cls1 = myClassLoader.loadClasses ("com.bittech.classloader.Member");
            Class member1Cls2 = Member.class;
            Class member1Cls3 = new Member().getClass();
            System.out.println(member1Cls1 == member1Cls2);
            System.out.println(member1Cls2 == member1Cls3);
        }
    }