import java.util.Arrays;
//直接插入排序越有序越快
public class 直接插入排序 {
    public static void inserSort(int[] array) {
        int tmp;
        for (int i = 1; i < array.length; i++) {
            int j=0;
            tmp = array[i];
            for ( j = i - 1; j >= 0; j--) {
          if(array[j]>tmp){
          array[j+1]=array[j];
          }
         else{
           break;
            }
            }
            array[j+1]=tmp;
        }
    }
    public static void main(String[] args) {
        int[] array={5,9,8,10,45,6,5,78,54,35,46};
        inserSort (array  );
        System.out.println ( Arrays.toString ( array ));
    }
}