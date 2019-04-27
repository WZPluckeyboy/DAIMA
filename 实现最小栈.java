import java.util.Stack;
class MinStack{
    Stack<Integer> stack1;
    Stack <Integer> minstack;
    public MinStack() {
        stack1 = new Stack <Integer> ( );
        minstack = new Stack <Integer> ( );
    }
    public void push(int x) {
stack1.push ( x );
if(minstack.isEmpty ()||x<=minstack.peek ()){
    minstack.push ( x );
}
    }
    public void pop() {
        if(stack1.pop ()==minstack.peek()){
            minstack.pop ();
        }
    }
    public int top() {
        return stack1.peek ();
    }
    public int getMin() {
return  minstack.peek ();
    }
}
public class 实现一个最小栈 {
    public static void main(String[] args) {
        MinStack num=new MinStack ();
        num.push ( -2 );
        num.push ( 0 );
        num.push ( -3 );
        System.out.println (num.top () );
        System.out.println (num.getMin () );

    }
}