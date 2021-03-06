//定义接口
public interface IMYQueue {
        // 判断这个队列是否为空
        boolean empty();
        // 返回队首元素，但不出队列
        int peek();
        // 返回队首元素，并且出队列
        int poll();
        // 将 item 放入队列中
        void add(int item);
        // 返回元素个数
        int size();
}
/********************************************************
*********************************************************
*********************************************************
*********************************************************/
//接口的实现
public class MYQueue implements IMYQueue {
    class Node{
        private int data;
        private  Node next;
        public  Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    private Node front;
    private Node rear;
    private  int usedsize;
   public  MYQueue(){
       this.front=null;
       this.rear=null;
        this.usedsize=0;
    }
    @Override
    // 判断这个队列是否为空
    public boolean empty() {
       return this.usedsize==0;
    }
    @Override
    // 返回队首元素，但不出队列
    public int peek() {
       if(empty ()){
           throw new  UnsupportedOperationException ( "空队列" );
       }
       int data=this.front.data;
       return data;
    }
    @Override
    // 返回队首元素，并且出队列
    public int poll() {
       if(empty ()){
           throw new UnsupportedOperationException ( "空队列" );
       }
      int data=this.front.data;
       if(usedsize==1){
           this.front=null;
           this.rear=null;
       }
       else {
           this.front=this.front.next;
       }
      this.usedsize--;
     return data;
    }
    @Override
    // 将 item 放入队列中
    public void add(int item) {
        Node node =new Node(item);
       if(empty ()){
           this.front=node;
           this.rear=node;
       }
       else{
           this.rear.next=node;
           this.rear=node;
       }
       this.usedsize++; 
   }
    @Override
    // 返回元素个数
    public int size() {
        return this.usedsize;
    }
}
/********************************************************
*********************************************************
*********************************************************
*********************************************************/
//main函数对以上方法的实现
public class Testqueue {
    public static void main(String[] args) {
        MYQueue myQueue=new MYQueue ();
        myQueue.add ( 10 );
        myQueue.add ( 20 );
        myQueue.add ( 30 );
        myQueue.add ( 40 );
        myQueue.add ( 50);
        myQueue.add ( 60 );
        myQueue.add ( 70 );
        myQueue.add ( 80);
        System.out.println ("*******************************" );
        System.out.println (myQueue.size () );
        System.out.println ("*******************************" );
        System.out.println (myQueue.poll () );
        System.out.println (myQueue.peek () );
        System.out.println ("*******************************" );
        System.out.println (myQueue.size () );
    }
