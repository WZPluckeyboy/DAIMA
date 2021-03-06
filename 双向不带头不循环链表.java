//定义接口
public interface 双向不循环链表 {
    //头插法
    void addFirst(int data);
    //尾插法
    void addLast(int data);
    //任意位置插入,第一个数据节点为0号下标
    boolean addindex(int index,int data);
    //查找是否包含关键字key是否在单链表当中
    boolean contains(int key);
    //删除第一次出现关键字为key的节点
    int remove(int key);
    //删除所有值为key的节点
    void removeAllKey(int key);
    //得到单链表的长度
    int getLength();
    void display();
    void clear();
}
//接口的实现
public class DoubleLinkedListImpl implements IDoubleLinked {
class Node{
private int data;
private  Node next;
private  Node prev;
public  Node(int data){
this.data=data;
this.next=null;
this.prev=null;
}
}
private Node head;
private  Node last;
public DoubleLinkedListImpl(){
this.head=null;
this.last=null;
}
@Override
 public void addFirst(int data) {
        Node node=new Node ( data );
        if(this.head==null){
            this.head=node;
            this.last=node;
        }
        else{
            node.next=this.head;
            this.head.prev=node;
            this.head=node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node=new Node(data);
        if(this.head==null){
            this.head=node;
            this.last=node;
        }
        else{
            this.last.next=node;
            node.prev=this.last;
            this.last=node;
        }

    }
    //判断index是否合法
    private  void checkIndex(int index){
        if(index<0||index>getLength ()){
            throw new UnsupportedOperationException ("Index不合法！"  );
        }
    }
    private  Node searchIndex(int index){
        checkIndex ( index );
        Node cur=this.head;
        for(int count=0;count<index;++count){
            cur=cur.next;
        }
        return  cur;
    }

    @Override
    public boolean addindex(int index, int data) {
        if(index==0){
            addFirst ( data );
            return true;
        }
        if(index==getLength ()){
            addLast ( data );
            return true;
        }
       Node  node=new Node ( data );
            Node cur=searchIndex ( index );
            node.next=cur;
            node.prev=cur.prev;
            node.next.prev=node;
            node.prev.next=node;
            return false;
    }

    @Override
    public boolean contains(int key) {
        Node cur=this.head;
        while(cur!=null){
            if(cur.data==key){
                return  true;
            }
            cur=cur.next;
        }
        return false;
    }

    @Override
    public int remove(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                int oldData = cur.data;
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next == null) {
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }
                }
                return oldData;

            }
            cur = cur.next;
        }
        return  -1;
    }


    @Override
    public void removeAllKey(int key) {
        Node cur=this.head;
while(cur!=null){
    if(cur.data==key){
        if(cur==this.head){
            this.head=this.head.next;
            this.head.prev=null;
        }
        else{
            cur.prev.next=cur.next;
            if(cur.next!=null){
                cur.next.prev=cur.prev;
            }
            else{
                this.last=cur.prev;
            }
        }
    }
    cur=cur.next;
}

    }

    @Override
    public int getLength() {
        int count=0;
        Node cur=this.head;
        while(cur!=null){
           count++;
           cur=cur.next;
        }
        return count;


    }

    @Override
    public void display() {
       Node cur=this.head;
       while(cur!=null){
           System.out.print (cur.data+" " );
          cur=cur.next;
       }
        System.out.println ( );

    }

    @Override
    public void clear() {
while(this.head.next!=null){
    Node cur=this.head.next;
    this.head.next=cur.next;
    cur.prev=null;
}
this.head=null;
this.last=null;
    }
}
//测试
public class Test {
    public static void main(String[] args) {
DoubleLinkedListImpl doubleLinked=new DoubleLinkedListImpl();
doubleLinked.addFirst ( 10 );
doubleLinked.addFirst ( 20 );
        doubleLinked.addFirst ( 30 );
        doubleLinked.addFirst ( 40 );
        doubleLinked.addFirst ( 50 );
        doubleLinked.addindex ( 0,60 );
        doubleLinked.addLast ( 90 );
        doubleLinked.addLast ( 100 );
        doubleLinked.addLast ( 70 );
        doubleLinked.addLast ( 60 );
        doubleLinked.remove ( 4 );
        doubleLinked.removeAllKey ( 2);
         doubleLinked.display ();
        System.out.println (doubleLinked.getLength ());

    }
}
