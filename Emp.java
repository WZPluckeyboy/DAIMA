package 反射.反射与简单Java类;
//员工信息类（简单Java类）
public class Emp {
    private String ename;
    private String job;

    public String getName() {
        return ename;
    }

    public void setName(String ename) {

        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
        ", job='" + job + '\'' +
                '}';
    }
}
