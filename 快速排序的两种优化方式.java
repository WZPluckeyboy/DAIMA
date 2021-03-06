//越排越有序，当达到某个区间时可进行插入排序优化
import java.util.Arrays;
import java.util.Random;
public class 快速排序的优化1 {
    //先进性一次排序
    public static int pantion(int[] array, int low, int high) {
        int tmp=array[low];
        while(low<high){
            while((low<high)&& array[high]>=tmp){
                high--;
            }
            if(low>=high){
                break;
            }
            else{
                array[low]=array[high];
            }
            while((low<high)&&array[low]<tmp){
                low++;
            }
            if(low>=high){
                break;
            }
            array[high]=array[low];
        }
        array[low]=tmp;
        return low;
    }
    public static void insertSort1(int[] array,int start,int end){
        int tmp=0;
        for(int i=start+1;i<=end;i++){
            tmp=array[i];
            int j=0;
            for(j=i-1;j>=start;j--){
                if(array[j]>tmp){
                    array[j+1]=array[j];
                }else{
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    public static void quick(int[] array,int start,int end) {
        if(end-start+1<=16){
            insertSort1(array,start,end);
            return;
        }
        int par=pantion ( array,start,end );
        if(par>start+1){   //左边有两个以上元素
            quick ( array,start,par-1 );  //对左边进行递归
        }
        if(par<end-1){    //右边有两个以上元素
            quick ( array,par+1,end );   //对右边进行递归
        }
    }
    public static void quickSort(int[] array) {
        quick(array,0,array.length-1) ;

    }
    public static void main(String[] args) {
      Random random = new Random ( );
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt ( 1000000) + 1;
        }
        quickSort ( array );
        System.out.println ( Arrays.toString ( array ) );
    }
}
//用三数取中法对快速排序进行优化
import java.util.Arrays;
import java.util.Random;
public class 快速排序优化2 {
    //先进性一次排序
    public static int pantion(int[] array, int low, int high) {
        int tmp=array[low];
        while(low<high){
            while((low<high)&& array[high]>=tmp){
                high--;
            }
            if(low>=high){
                break;
            }
            else{
                array[low]=array[high];
            }
            while((low<high)&&array[low]<tmp){
                low++;
            }
            if(low>=high){
                break;
            }
            array[high]=array[low];
        }
        array[low]=tmp;
        return low;
    }
    public static void swap(int[] array,int start,int end){
        int tmp=array[start];
        array[start]=array[end];
        array[end]=tmp;
    }
    public static void medaianOfThree(int[] array,int low,int high){
        int mid =(low+high)/2;
        if(array[mid]>array[low]){
            swap(array,mid,low);
        }
        if(array[mid]>array[high]){
            swap ( array,mid,high );
        }
        if(array[low]>array[high]){
            swap ( array, low, high );
        }
    }
    public static void quick(int[] array,int start,int end) {
        int par=pantion ( array,start,end );
        if(par>start+1){   //左边有两个以上元素
            quick ( array,start,par-1 );  //对左边进行递归
        }
        if(par<end-1){    //右边有两个以上元素
            quick ( array,par+1,end );   //对右边进行递归
        }
    }
    public static void quickSort(int[] array) {
        quick(array,0,array.length-1) ;

    }
    public static void main(String[] args) {
        int[] array=new int[]{1,6,5,7,48,13,67,45};
       /* Random random = new Random ( );
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt ( 1000000) + 1;
        }*/
        quickSort ( array );
        System.out.println ( Arrays.toString ( array ) );
    }
}