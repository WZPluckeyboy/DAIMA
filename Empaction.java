package 反射.反射与简单Java类;

import java.lang.reflect.InvocationTargetException;

//操作Emp的类，提供给用户使用
public class EmpAction {
    private  Emp emp=new Emp ();
    public void setEmpValue(String value) throws InvocationTargetException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        BeanUtil.setBeanValue(this,value);

    }
    public Emp getEmp(){

        return emp;
    }
}
