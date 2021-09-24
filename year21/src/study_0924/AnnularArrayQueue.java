package study_0924;

import java.util.Scanner;
/*
 * 一个简单环形队列
 * */
public class AnnularArrayQueue {
    public static void main(String[] args) {
        //定义队列长度
        AnnularQueue arrayQueue = new AnnularQueue(3);
        //队列

        boolean flag = true;
        while (flag){
            System.out.println("输入一个字母进行操作\n" +
                    "a(添加数据)\n" +
                    "b(取出数据)\n" +
                    "c(查看队列中所有数据)\n" +
                    "d(查看队列中当前头部的数据)\n" +
                    "e(退出程序)");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.next().charAt(0)){
                case 'a':
                    System.out.println("请输入想添加的数字");
                    int value = scanner.nextInt();
                    try{
                        arrayQueue.addQueue(value);
                        System.out.println("添加成功");
                    }
                    catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'b':
                    try{
                        arrayQueue.getData();
                    }
                    catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'c':
                    try{
                        arrayQueue.pr();
                    }
                    catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'd':
                    try{
                        System.out.println("当前头部的数据为："+arrayQueue.headData());
                    }
                    catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    flag =false;
                    break;
                default:
                    break;
            }

        }
    }

}
//队列类 （自定义队列）
class AnnularQueue{
    //存储上限
    private int maxSize;
    //队列头  相当于读指针
    private int font;
    //队列尾  相当于写指针
    private int rear;
    //用于存储的数组
    private int[] arr;

    //构造函数->  创建队列
    public AnnularQueue(int maxSize) {
        this.maxSize = maxSize;
        this.font = 0;
        this.rear = 0;
        this.arr = new int[maxSize];
    }
    //方法函数->  判断队列是否满
    public boolean isFull(){
        return (this.rear+1)%this.maxSize == this.font;
    }
    //队列是否为空
    public boolean isEmpty(){
        return this.rear == this.font;
    }
    //队列添加数据
    public void addQueue(int data){
        if(isFull()){
            throw new RuntimeException("队列已满！");
        }
        //数组从零开始存
        this.arr[this.rear] = data;
        this.rear++;
        if(this.rear>this.maxSize-1){
            this.rear=0;
        }
        /*
        * 或者 通过越界取模即可
        * */

//        this.rear = (this.rear+1) % maxSize;
    }
    //队列取出数据
    public void getData(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        System.out.println("取出的数据为:"+this.arr[this.font]);
        this.arr[this.font]=-1;
        this.font++;
        if(this.font>this.maxSize-1){
            this.font=0;
        }
    }
    //当前头部的数据
    public int headData(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return this.arr[this.font+1];
    }
    //查看队列中所有数据
    void pr(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int count = 0;
        for(int i: arr){
            count ++;
            if(i>0){
                System.out.printf("arr[%d] = %d\n",count,i);
            }
        }
    }
}
