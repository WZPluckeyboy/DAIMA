public class Test {
    public static void leftRotateString(String str,int n){
        char[] arr = str.toCharArray();     //将目标字符串转换为字符数组
        char[] arr1 = new char[arr.length]; //定义一个等长的字符数组存储新的字符数组
        int i = 0;
        for (int j = n; j < arr.length; j++) {
            arr1[i] = arr[j];               //先将旋转位置之后的值赋给新的数组
            i++;
        }
        for (int j = 0; j < n; j++) {       //再将需要旋转的元素补到新的数组后面
            arr1[i] = arr[j];
            i++;
        }
        String str1 = new String(arr1);     //将数组转换为字符串
        System.out.println(str1);           //输出字符串
    }

    public static void main(String[] args) {
        leftRotateString("abcdef",2);
    }
}