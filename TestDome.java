package 反射.反射与简单Java类;
//现在所有的操作是通过TestDemo类调⽤EmpAction类实现的，⽽EmpAction类的主要作⽤是在于定位
//要操作的属性类型。同时该程序应该符合于所有简单的Java类开发形式，因此对于我们的设计⽽⾔必须
//有⼀个单独的类(BeanOperation)(实现此适配。
//范例：Emp类设计（简单Java类）

import java.lang.reflect.InvocationTargetException;

public class TestDome {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        String str="emp.ename:dange|emp.job:Java Coder";
        EmpAction empAction=new EmpAction ();
        empAction.setEmpValue ( str);
        System.out.println (empAction.getEmp () );

    }
}
