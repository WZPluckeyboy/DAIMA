/*foreach的格式:
for(数据类型 临时变量：数组（集合））{
临时变量表示的是数组中的每一个元素
}
* */
public class foreach {
    public static void main(String[] args) {
        int[] array = new int[]{3, 8, 9, 67, 89, 56, 78, 89};
        int sum=0;
        int index=0;
        for (int i : array) {
                sum += i;
                System.out.println ( "index=" + index + " value=" + i );
                index++;
        }
        System.out.println ("sum="+ sum );
    }
}
