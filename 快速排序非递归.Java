import java.util.Arrays;
import java.util.Random;

//用栈进行快排非递归
public class Test{
    public static int partion(int[] array, int low, int high) {
        int tmp = array[low];
        while (low < high) {
            while (( low < high ) && array[high] >= tmp) {
                high--;
            }
            if (low == high) {
                break;
            } else {
                array[low] = array[high];
            }
            while (( low < high ) && array[low] <= tmp) {
                low++;
            }
            if (low == high) {
                break;
            } else {
                array[high] = array[low];
            }
        }
        array[low] = tmp;
        return low;
    }
  public  static  void quickSort(int[] array)  {
      int[] stack=new int[array.length*2];
      int top=0;
      int low=0;
      int high=array.length-1;
      int par=partion(array,low,high);//先进行一趟快速排序
      //判断当前左右两边是否有两个以上数据
      if(par>low+1){       //说明左边有两个以上元素
          stack[top++]=low;
          stack[top++]=par-1;
      }
      if(par<high-1){         //说明右边有两个以上元素
          stack[top++]=par+1;
          stack[top++]=high;
      }
      //以上代码执行完毕，两边的数对已经全部入站，接下来需要判断栈是否为空。若不为空，取出两个数对进行partion（）
      while(top>0){
          high=stack[--top];
          low=stack[--top];
          par=partion ( array,low,high );
          if(par>low+1){       //说明左边有两个以上元素
              stack[top++]=low;
              stack[top++]=par-1;
          }
          if(par<high-1){         //说明右边有两个以上元素
              stack[top++]=par+1;
              stack[top++]=high;
          }

      }
  }

    public static void main(String[] args) {
        Random random=new Random();
        int[] array=new int[10000] ;
        for(int i=0;i<array.length;i++){
            array[i]=random.nextInt ( 10000 )+1;
        }
        quickSort ( array );
        System.out.println (Arrays.toString ( array ) );
    }
}