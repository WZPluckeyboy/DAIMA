package 四大并发工具类的使用;
/*闭锁，CountDownLatch类位于java.util.concurrent包下，利⽤它可以实现类似计数器的功能。⽐如有⼀个任
务A，它要等待其他4个任务执⾏完毕之后才能执⾏，此时就可以利⽤CountDownLatch来实现这种功能
了。*/
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class CountDownLatchDemo implements  Runnable {
private CountDownLatch countDownLatch;
public CountDownLatchDemo(CountDownLatch countDownLatch){
    this.countDownLatch=countDownLatch;
}
    @Override
    public void run() {
        System.out.println (Thread.currentThread ().getName ()+"已经到达" );
        countDownLatch.countDown ();
    }
}
public  class TestCountDownLatch{
     private  void test() throws InterruptedException {
         CountDownLatch countDownLatch =new CountDownLatch ( 3 );
         System.out.println (" 比赛开始！" );
         new Thread ( new CountDownLatchDemo ( countDownLatch)," 运动员A"  ).start ();
         TimeUnit.SECONDS.sleep ( 1 );
         new Thread ( new CountDownLatchDemo ( countDownLatch)," 运动员B"  ).start ();
         TimeUnit.SECONDS.sleep ( 1 );
         new Thread ( new CountDownLatchDemo ( countDownLatch)," 运动员C"  ).start ();
         countDownLatch.await();
         System.out.println ("比赛结束" );
     }

    public static void main(String[] args) {
        TestCountDownLatch testCountDownLatch=new TestCountDownLatch ();
        try {
            testCountDownLatch.test ();
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        }
    }

}
