package 顺序表和链表;
import java.util.Scanner;
//取出该数的每一位求其平方和
public class 快乐数 {
public static int function(int num) {
int ret = 0;
 while (num != 0) {
 ret = ret + ( num % 10 ) * ( num % 10 );
 num = num / 10;
}
return ret;
}
//判断该数是否为快乐数
public static boolean isHappy(int n) {
if (n <= 0) {
return false;
}
while (n != 1) {
n = function ( n );
if (n == 16) {
return false;
}
}
return true;
}
//主函数（输入一个数）
public static void main(String[] args) {
Scanner scanner=new Scanner ( System.in );
int num=scanner.nextInt ();
System.out.println ( isHappy ( num ) );
}
}