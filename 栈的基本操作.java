//先定义接口
public interface IMYstack {
    // 将 item 压入栈中
    void push(int item);
    // 返回栈顶元素，并且出栈
    int pop();
    // 返回栈顶元素，但不出栈
    int peek();
    // 判断这个栈是否为空栈
    boolean empty();
    // 返回元素个数
    int size();
}
/**********************************************************
***********************************************************
***********************************************************
***********************************************************/
//对所有接口的实现
public class MyStackImpl implements IMYstack {
    private int top;//永远指向可以存放数据元素的下标
    private int[] elem;//数组
    private int usedSize;//数据元素的个数
    public MyStackImpl(int size){
        if(size<0){
            throw new UnsupportedOperationException ( "栈的容量不合理！" );
        }
        else {
           this. usedSize =0;
           this. top = 0;
            elem = new int[size];
        }
    }
    public boolean isFull(){
        return this.usedSize==this.elem.length;
    }
    @Override
    // 将 item 压入栈中
    public void push(int item) {
        if(isFull ()){
            throw new UnsupportedOperationException ( "栈已满！" );
        }
            this.elem[this.top++] = item;
        this.usedSize++;
    }
    @Override
    // 返回栈顶元素，并且出栈
    public int pop() {
        if(empty ()){
            System.out.println ("栈为空，无元素可出栈！" );
            return 0;
        }
        int data=this.elem[this.top-1];
       this.top--;
       this.usedSize--;
        return  data;
    }
    @Override
    // 返回栈顶元素，但不出栈
    public int peek() {
        if(empty()){
            throw new UnsupportedOperationException("栈为空");
        }
        return this.elem[this.top-1];
    }
    @Override
    // 判断这个栈是否为空栈
    public boolean empty() {

return this.top==0;
    }
    @Override
    // 返回元素个数
    public int size() { 
        return this.usedSize;
    }
    public void clear(){
        while(top!=-1){
            elem[top]='\0';
            top--;
        }
        this.usedSize=0;
    }
    //打印栈
    public void display(){
        while(top!=-1){
            System.out.print (elem[top]+"  " );
            top--;
        }
        System.out.println ( );
    }
}
/*****************************************************
******************************************************
******************************************************
******************************************************/
//main函数对栈的实现
public class MYstackTest {
    public static void main(String[] args) {
        MyStackImpl myStackImpl=new MyStackImpl ( 20);
myStackImpl.push ( 10 );
        myStackImpl.push ( 90 );
        myStackImpl.push ( 20);
        myStackImpl.push ( 30);
        myStackImpl.push ( 40);
        myStackImpl.push ( 50);
        myStackImpl.push ( 60 );
        myStackImpl.push ( 70 );
        myStackImpl.push ( 70);
        myStackImpl.push ( 80 );
        myStackImpl.display ();
        System.out.println ( myStackImpl.pop ());
        System.out.println ("#######################" );
        System.out.println ( myStackImpl.size ());
    }
}