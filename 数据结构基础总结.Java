一、数据结构基础
（1）数据结构定义
数据结构是计算机存储、组织数据的方式，指相互之间存在一种或多种特
定关系的数据集合。 
1）算法
   算法就是定义良好的计算过程，他取一个或一组的值为输入，并产生一个
或一组值作为输出，简单来说算法就是一系列的计算步骤，用来将输入数据转化
成输出结果。 
2）算法效率
算法效率分为两种
算法效率分为两种：
○1 时间效率，被称为时间复杂度
    时间复杂度的定义：在计算机科学中，算法的时间复杂度是一个函数，它
定量描述了该算法的运行时间。一个算法执行所耗费的时间，从理论上说，是不
能算出来的，只有你把你的程序放在机器上跑起来，才能知道。但是我们需要每
个算法都上机测试吗？是可以都上机测试，但是这很麻烦，所以才有了时间复杂
度这个分析方式。一个算法所花费的时间与其中语句的执行次数成正比例，算法
中的基本操作的执行次数，为算法的时间复杂度。 
○2 空间效率，被称为空间复杂度
    空间复杂度是对一个算法在运行过程中临时占用存储空间大小的量度 。空
间复杂度不是程序占用了多少 bytes 的空间，因为这个也没太大意义，所以空间
复杂度算的是变量的个数。空间复杂度计算规则基本跟实践复杂度类似，也使用
大 O 渐进表示法。
二、顺序表和链表
（1）顺序表
○1 定义
顺序表是用一段物理地址连续的存储单元依次存储数据元素的线性结构，一
般情况下采用数组存储。在数组上完成数据的增删查改。
○2 接口的实现
1）接口：
public interface ISequence {
boolean add(int pos,Object data); //在 pos 位置插入 data
int search(Object key); //查找关键字 key 找到返回 key 的下标，没有返回-1
boolean contains (Object key) ; //查找是否包含关键字 key 是否在顺序表当中
Object getPos(int pos); //得到 pos 位置的值
Object remove(Object key); //删除第一次出现的关键字 key
int size(); //得到顺序表的长度
void display(); //打印顺序表
void clear(); //清空顺序表以防内存泄露
}
2）实现
import java.util.Arrays;
class MySequenceImp implements ISequence{
private Object[] elem;
private int usedSize;
//默认的顺序表的容量
private static final int DEFAULT_SIZE = 10;
public MySequenceImp(){
this.elem=new Object[DEFAULT_SIZE];
this.usedSize=0;
}
public boolean isFull() {
if (this.usedSize == this.elem.length) {
return true;
}
return false;
}
@Override
public boolean add(int pos, Object data) { //在 pos 位置插入 data
if (pos < 0 || pos > this.usedSize) { //1、pos 的合法性 2、是否是满的顺
序表
return false;
}
if (isFull ( )) {
this.elem = Arrays.copyOf ( this.elem, this.elem.length * 2 );//让数组扩大原来长度
的 2 倍
}
for(int i=this.usedSize-1;i>=pos;i--){ //挪数据
this.elem[i+1]=this.elem[i];
}
this.elem[pos] = data;
this.usedSize++;
return true;
}
public boolean isEmpty() {
if(this.usedSize==0){
return true;
}
else return false;
}
@Override
public int search(Object key) {
if(key==null){
return -1;
}
if(isEmpty()){
throw new UnsupportedOperationException ( "顺序表为空" );
}
for(int i = 0; i<this.usedSize; i++){
if(this.elem[i].equals ( key )){
return i;
}
}
return -1;
}
@Override
public boolean contains(Object key) {
if(key==null){
return false;
}
if(isEmpty ()){
throw new UnsupportedOperationException ( "顺序表为空！" );
}
for (int i=0;i<this.usedSize;i++){
if(this.elem[i].equals ( key )){
return true;
}
}
return false;
}
@Override
public Object getPos(int pos) {
if(pos<0 ||pos>=this.usedSize || isEmpty ()){
return null;
}
return this.elem[pos];
}
@Override
public Object remove(Object key) {
int index=search ( key );
if(index==-1){
return null;
}
Object oldData=this.elem[index];
int i=0;
for(i=index;i<this.usedSize-1;i++){
this.elem[i]=this.elem[i+1];
}
this.elem[i+1]=null;
this.usedSize--;
return oldData;
}
@Override
public int size() {
return this.usedSize;
}
@Override
public void display() {
for(int i=0;i<this.usedSize;i++){
System.out.println (this.elem[i]+"" );
}
System.out.println ( );
}
@Override
public void clear() {
for(int i=0;i<this.usedSize;i++){
this.elem[i]=null;
}
this.usedSize=0;
}
}
public class MySequenceImp1 {
public static void main(String[] args) {
MySequenceImp mySequenceImp=new MySequenceImp ();
mySequenceImp.add(0,18);
mySequenceImp.add ( 1,"hello" ) ;
mySequenceImp.add ( 2,"bit" );
mySequenceImp.add ( 3,99 );
mySequenceImp.display ();
System.out.println (mySequenceImp.remove ( "bit" ) );
mySequenceImp.display ();
System.out.println (mySequenceImp.contains ( "wang" ));
mySequenceImp.clear ();
mySequenceImp.display ();;
}
}
（2）链表
1）无头单向非循环链表
接口：
public interface 无头单向非循环链表 {
//头插法
void addFist(int data);
//尾插法
void addLast(int data);
//任意位置插入，第一个数据节点为 0 号下标
boolean addindex(int index,int data);
//查找是否包含关键字 Key 在单链表当中
boolean contains(int key);
//删除第一次出现关键字 Key 的节点
int remove(int key);
//删除所有值为 Key 的节点
void removeAllKey(int key);
//得到单链表的长度
int getLength();
//
void display();
////清除单链表的内容
void clear();
}
实现：
public class 无头单链表的实现 implements 无头单向非循环链表 {
class Node {
private int data;
private Node next;
public Node(int data) {
this.data = data;
}
public Node getNext() {
return next;
}
}
private Node head;
public 无头单链表的实现() {
this.head = null;
}
@Override
public void addFist(int data) {
Node node = new Node ( data );
if (this.head == null) {
this.head = node;
} else {
node.next = this.head;
this.head = node;
}
}
@Override
public void addLast(int data) {
Node node = new Node ( data );
if (this.head == null) {
this.head = node;
} else {
Node cur = this.head;
while (cur.next != null) {
cur = cur.next;
}
cur.next = node;
}
}
//检查 Index 的合法性
private void checkIndex(int index) {
if (index < 0 || index > getLength ( )) {
throw new UnsupportedOperationException ( "index 不合法" );
}
}
//找到 Index-1 的位置，函数返回该位置节点的引用
private Node searchIndex(int index) {
int count = 0;
Node cur = this.head;
while (count < index - 1) {
cur = cur.next;
count++;
}
比特科技临潼火箭班
30
return cur;
}
@Override
public boolean addindex(int index, int data) {
checkIndex ( index );
if (index == 0) {
addFist ( data );
return true;
} else {
Node node = new Node ( data );
Node cur = searchIndex ( index );
node.next = cur.next;
cur.next = node;
return true;
}
}
@Override
public boolean contains(int key) {
Node cur = this.head;
while (cur != null) {
if (cur.data == key) {
return true;
}
cur = cur.next;
}
return false;
}
//查找 key 前驱
private Node searchPre(int key) {
Node pre = this.head;
if (pre.data == key) {
return this.head;
}
while (pre.next != null) {
if (pre.next.data == key) {
return pre;
}
pre = pre.next;
}
return null;
}
@Override
public int remove(int key) {
int oldData = 0;
比特科技临潼火箭班
31
Node pre = searchPre ( key );
if (pre == null) {
throw new UnsupportedOperationException ( "不存在" );
}
//头结点的时候
if (pre == head && pre.data == key) {
oldData = this.head.data;
this.head = this.head.next;
return oldData;
}
oldData = pre.next.data;
pre.next = pre.next.next;
return oldData;
}
@Override
public void removeAllKey(int key) {
if (this.head == null) {
return;
}
Node pre = this.head;
Node cur = this.head.next;
while (cur != null) {
if (cur.data == key) {
pre.next = cur.next;
cur = cur.next;
} else {
pre = cur;
cur = cur.next;
}
}
if (this.head.data == key) {
this.head = this.head.next;
}
}
@Override
public int getLength() {
int count = 0;
Node cur = this.head;
while (cur != null) {
count++;
cur = cur.next;
}
return count;
}
@Override
public void display() {
Node cur = this.head;
while (cur != null) {
System.out.print ( cur.data + " " );
cur = cur.next;
}
System.out.println ( );
}
@Override
public void clear() {
while (this.head != null) {
Node cur = this.head.next;
this.head.next = null;
this.head = cur;
}
}
public class 无头单向非循环链表的测试 {
public static void main(String[] args) {
无头单链表的实现 mySingleList = new 无头单链表的实现 ( );
mySingleList.addFist ( 10 );
mySingleList.addFist ( 20 );
mySingleList.addFist ( 30 );
mySingleList.addFist ( 40 );
mySingleList.addLast ( 10 );
mySingleList.addindex (1, 20 );
mySingleList.addindex (0, 30 );
mySingleList.addLast ( 40);
System.out.println ( mySingleList.contains ( 20 ));
mySingleList.display ();
mySingleList.remove ( 20 );
mySingleList.display ();
mySingleList.removeAllKey ( 20 );
}
}
循环链表和双向链表在此不一一举例。
 三、栈和队列
（1）栈
接口：
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
实现：
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
System.out.print (elem[top]+" " );
top--;
}
System.out.println ( );
}
}
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
（2）队列
接口：
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
实现：
public class MYQueue implements IMYQueue {
class Node{
private int data;
private Node next;
public Node(int data){
this.data=data;
this.next=null;
}
}
private Node front;
private Node rear;
private int usedsize;
public MYQueue(){
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
throw new UnsupportedOperationException ( "空队列" );
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
// 返回元素个
public int size() {
return this.usedsize;
}
}
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
}
四、排序
（1）直接插入排序
1）基本思想：
直接插入排序是一种简单的插入排序法，其基本思想是：把待排序的记录按其关
键码值的大小逐个插入到一
个已经排好序的有序序列中，直到所有的记录插入完为止，得到一个新的有序序
列 。
实际中我们玩扑克牌时，就用了插入排序的思想
（2）当插入第 i(i>=1)个元素时，前面的 array[0],array[1],…,array[i-1]已
经排好序，此时用 array[i]的排序码与 array[i-1],array[i-2],…的排序码顺
序进行比较，找到插入位置即将 array[i]插入，原来位直接插入排序的特性总结：
1. 元素集合越接近有序，直接插入排序算法的时间效率越高
2. 时间复杂度：O(N^2)
3. 空间复杂度：O(1)，它是一种稳定的排序算法
4. 稳定性：稳定
置上的元素顺序后移
import java.util.Arrays;
//直接插入排序越有序越快
public class Test {
public static void insertSort(int[] array){
int tmp=0;
for(int i=1;i<array.length;++i) {
tmp=array[i];
int j=0;
for(j=i-1;j>=0;--j){
if(array[j]>tmp){
array[j+1] =array[j];
}
else{
break;
}
}
array[j+1]=tmp;
}
}
public static void main(String[] args) {
int[] array={45,56,78,90,23,2,46,18,67} ;
insertSort( array);
System.out.println (Arrays.toString ( array ) );
}
}
2）希尔排序
希尔排序法又称缩小增量法。希尔排序法的基本思想是：先选定一个整数，把待
排序文件中所有记录分成个组，所有距离为的记录分在同一组内，并对每一组内
的记录进行排序。然后，取，重复上述分希尔排序的特性总结：
1. 希尔排序是对直接插入排序的优化。
2. 当 gap > 1 时都是预排序，目的是让数组更接近于有序。当 gap == 1 时，数
组已经接近有序的了，这样就会很快。这样整体而言，可以达到优化的效果。我们实现后可以进行性能测试的对比
3. 希尔排序的时间复杂度不好计算，需要进行推导，推导出来平均时间复杂度：
O(N^1.3—N^2）
4. 稳定性：不稳定
组和排序的工作。当到达=1 时，所有记录在统一组内排好序。
public class Test {
public static void shell(int[] array, int gap) {
int tmp = 0;
for (int i = gap; i < array.length; i++) {
tmp = array[i];
int j = 0;
for (j = i - gap; j >= 0; j--) {
if (array[j] > tmp) {
array[j + gap] = array[j];
} else {
break;
}
}
array[j + gap] = tmp;
}
}
public static void shellSort(int[] array) {
long start=System.currentTimeMillis ();
int[] drr = {5, 3, 1};
for (int i = 0; i < drr.length; i++) {
shell ( array, drr[i] );
}
long end=System.currentTimeMillis ();
System.out.println (end-start );
}
public static void main(String[] args) {
Random random = new Random ( );
int[] array = new int[100000];
for (int i = 0; i < array.length; i++) {
array[i] = random.nextInt ( 100000) + 1;
}
shellSort ( array );
System.out.println ( Arrays.toString ( array ) );
}
}
（3）选择排序
（1）基本思想：
每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起
始位置，直到全部待排序的
数据元素排完 。
（2）直接选择排序:
在元素集合 array[i]--array[n-1]中选择关键码最大(小)的数据元素
若它不是这组元素中的最后一个(第一个)元素，则将它与这组元素中的最后一
（第一个）元素交换
在剩余的 array[i]--array[n-2]（array[i+1]--array[n-1]）集合中，重复上述
步骤，直到集合剩余 1 个元素
直接选择排序的特性总结：
1. 直接选择排序思考非常好理解，但是效率不是很好。实际中很少使用
2. 时间复杂度：O(N^2)
3. 空间复杂度：O(1)
4. 稳定性：不稳定
import java.util.Arrays;
public class Test {
public static void selectSort(int[] array) {
for (int i = 0; i < array.length; i++) {
for (int j = i + 1; j < array.length; j++) {
if (array[j] < array[i]) {
int tmp = array[i];
array[i] = array[j];
array[j] = tmp;
}
}
}
}
public static void main(String[] args) {
int[] array = {10, 8, 5, 25, 60, 89, 54, 36};
selectSort ( array );
System.out.println ( Arrays.toString ( array ) );
}
}
（4）堆排序
堆排序(Heapsort)是指利用堆积树（堆）这种数据结构所设计的一种排序算法，
它是选择排序的直接选择排序的特性总结：
1. 堆排序使用堆来选数，效率就高了很多。
2. 时间复杂度：O(N*logN)
3. 空间复杂度：O(1)
4. 稳定性：不稳定
一种。它是通过堆来进行选择数据。需要注意的是排升序要建大堆，排降序建小
堆。
import java.util.Arrays;
import java.util.Random;
public class Test{
public static void adjust(int[] array,int start,int end){ //一次调整, 时间复杂度为 log2n
int tmp=array[start];
for(int i=2*start+1;i<=end;i=i*2+1){
//1.找到左右孩子的最大值的下标；
if((i<end)&&array[i]<array[i+1]){
i++;//已经找到左右孩子里面的最大值下标
}
if(array[i]>tmp) { //和父节点进行比较
array[start]=array[i];
start=i;
}
if(array[i]<tmp){
array[start]=tmp;
}
}
array[start]=tmp;
}
public static void heapSort(int[] array){
for(int i=(array.length-1-1)/2;i>=0;i--){
adjust(array,i,array.length-1);
}
//以上为把一棵树调整为大根堆
//接下来进行交换
for(int j=0;j<array.length-1;j++){
int tmp=array[array.length-1-j];
array[array.length-1-j]=array[0];
array[0]=tmp;
adjust ( array,0,array.length-1-j-1 );
}
}
public static void main(String[] args) {
int[] array={7,9,6,8,25,34,16,28,45,96,21} ;
heapSort ( array );
System.out.println (Arrays.toString(array) );
}
（5）快速排序
快速排序是 Hoare 于 1962 年提出的一种二叉树结构的交换排序方法，其基本
思想为：任取待排序元素序列中的某元素作为基准值，按照该排序码将待排序集
合分割成两子序列，左子序列中所有元素均小于基准值，右子序列中所有元素均
大于基准值，然后最左右子序列重复该过程，直到所有元素都排列在相应位置上
为止。
将区间按照基准值划分为左右两半部分的常见方式有：
1. hoare 版本
2. 挖坑法
3. 前后指针版本
快速排序的特性总结：
1. 快速排序整体的综合性能和使用场景都是比较好的，所以才敢叫快速排序
2. 时间复杂度：O(N*logN)
3. 空间复杂度：O(logN)
4. 稳定性：不稳定
import java.util.Arrays;
import java.util.Random;
public class Test {
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
public static void quick(int[] array,int start,int end) {
int par=pantion ( array,start,end );
if(par>start+1){ //左边有两个以上元素
quick ( array,start,par-1 ); //对左边进行递归
}
if(par<end-1){ //右边有两个以上元素
quick ( array,par+1,end ); //对右边进行递归
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
（6）归并排序
基本思想：归并排序（MERGE-SORT）是建立在归并操作上的一种有效的排序算法, 该算法是采用分治法（Divide andConquer）的一个非常典型的应用。将已有序
的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间
有序。若将两个有序表合并成一个有序表，称为二路归并。 归并排序核心步骤
归并排序的特性总结：
1. 归并的缺点在于需要 O(N)的空间复杂度，归并排序的思考更多的是解决在磁
盘中的外排序问题。
2. 时间复杂度：O(N*logN)
3. 空间复杂度：O(N)
4. 稳定性：稳定
import java.util.Arrays;
import java.util.Random;
public class Test {
public static void merge(int[] array,int start,int mid,int end){
int[] tmpArray=new int[array.length];
int tmpIndex=start;
int start2=mid+1;
int i=start;
while(start<=mid&&start2<=end){ //保证两个归并段都有数据
if(array[start]<=array[start2]) {
tmpArray[tmpIndex++]=array[start++];
}
else{
tmpArray[tmpIndex++] =array[start2++];
}
}
while(start<=mid){ //说明第二归并段已无数据,第一归并段还有数据
tmpArray[tmpIndex++] =array[start++];
}
while(start2<=end){//说明第一归并段已无数据，第二归并段还有数据
tmpArray[tmpIndex++] =array[start2++];
}
while(i<=end){ //把已排好的有序数组 tmpArray 拷贝到 array 中
array[i]=tmpArray[i];
i++;
}
}
public static void mergeSort(int[] array,int start,int end){
if(start>=end){
return;
}
int mid=(start+end)/2;
mergeSort(array,start,mid);//递归左边
mergeSort(array,start+1,end);//递归右边，分解的过程
//肯定是一个一个的有序序列
merge(array,start,mid,end);//合并的过程
}
public static void main(String[] args) {
int[] array={10,14,18,4,7,90,45,34};
Random random = new Random ( );
int[] array = new int[10];
for (int i = 0; i < array.length; i++) {
array[i] = random.nextInt ( 1000000) + 1;
}
mergeSort (array,0,array.length-1 );
System.out.println ( Arrays.toString ( array ) );
}
}