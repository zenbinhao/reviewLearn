package study_0924;
//单链表
//java.util.LinkedList  单链表

//import java.util.Queue; 队列

import java.util.Stack;

public class LinkedList {
    public static void main(String[] args) {
        PersonNode personNode1 = new PersonNode(1,"小曾");
        PersonNode personNode2 = new PersonNode(2,"小下");
        PersonNode personNode3 = new PersonNode(3,"小是");
        PersonNode personNode4 = new PersonNode(4,"小个");

        LinkList linkList = new LinkList();
        //随意添加
//        linkList.add(personNode1);
//        linkList.add(personNode4);
//        linkList.add(personNode3);
//        linkList.add(personNode2);


        //排序添加
        linkList.addPx(personNode1);
        linkList.addPx(personNode4);
        linkList.addPx(personNode3);
        linkList.addPx(personNode2);

        linkList.list();

        linkList.update(new PersonNode(1,"曾斌昊"));

        linkList.list();

//        linkList.delete(1);
//        linkList.delete(2);
//        linkList.delete(3);
//        linkList.delete(4);
//
//        linkList.list();

        System.out.println("单链表的翻转");
        LinkList linkList1 = new LinkList();
        linkList1.setHead(linkList.reverseAdd());
        linkList1.list();

        System.out.println("\n\n\n使用String 字符串拼接逆序打印");
        linkList1.reversePr();
        System.out.println("\n\n\n使用数据结构 栈进行逆序打印");
        linkList1.reversePr1();

    }
}
//个人类
class PersonNode{
    int no;
    String name;
    PersonNode next;

    public PersonNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}

//带头单链表管理类
class LinkList{
    private PersonNode head = new PersonNode(0,"");

    public PersonNode getHead() {
        return head;
    }

    public void setHead(PersonNode head) {
        this.head = head;
    }

    //添加节点函数
    public void add(PersonNode person){
        //创建一个指针  存放地址
        //其辅助作用，因为不能直接操作head  会导致head的数据以及内存地址改变
        PersonNode temp = head;

        //通过while循环找到链表的最后位置
        while (true){
            //如果 temp.next对象的内存地址为空 则结束循环  说明temp为链表的最后一个节点
            if (temp.next==null){
                break;
            }
            //如果不是空则继续找到链表的末尾
            temp = temp.next;
        }

        //找到了链表的末尾
        temp.next = person;
    }

    //按顺序
    //添加节点函数
    public void addPx(PersonNode person){
        //创建一个指针  存放地址
        //其辅助作用，因为不能直接操作head  会导致head的数据以及内存地址改变
        PersonNode temp = head;

        //通过while循环找到链表的最后位置
        while (true){
            //如果 temp.next对象的内存地址为空 则结束循环  说明temp为链表的最后一个节点
            if (temp.next==null){
                break;
            }
            if(temp.next.no>person.no){
                break;
            }
            //如果不是空则继续找到链表的末尾
            temp = temp.next;
        }

        //找到了链表的末尾  或者找到了大小适配的节点位置
        PersonNode next = temp.next;
        person.next=next;
        temp.next = person;
//        temp.next = person;
    }

    //根据编号修改函数
    public void update(PersonNode newPersonNode){
        PersonNode temp = head;
        //标志位 判断是否找到修改的编号  因为存在无匹配编号的情况存在
        boolean flag = false;
        while (true){
            if(temp.no == newPersonNode.no){
                //找到相同编号则修改标志位
                flag =true;
                //并退出遍历查找
                break;
            }
            //指针的下一个地址为空
            if(temp.next==null){
                break;
            }
            // 通过循环 指针后移进行单链表遍历
            temp = temp.next;
        }
        //找到对应内存地址后 进行修改值
        if (flag){
            temp.name = newPersonNode.name;
            System.out.println("成功修改");
        }else {
            System.out.printf("没找到编号为的%d数据信息，无法修改",newPersonNode.no);
        }

    }

    public void delete(int no){
        // 辅助指针
        PersonNode temp = head;
        // 需要一个标志位看是否找到对应需要删除的 编号才可以进行删除操作
        boolean flag = false;
        //通过while循环寻找 需要删除的节点的前一个节点
        while (true){
            //找到对应节点的前一个节点
            if(temp.next.no==no){
                flag =true;
                break;
            }
            if(temp.next==null){
                break;
            }
            temp = temp.next;
        }
        //存在对应节点 进行删除 原来被覆盖的引用的temp.next对象 将会被gc自动回收
        if(flag){
            // 对应节点的引用进行覆盖
            temp.next = temp.next.next;
            System.out.println("成功删除");
        }else {
            System.out.println("未找到可以删除的对应编号");
        }
    }

    public PersonNode reverseAdd(){
        //新头
        PersonNode newHead = new PersonNode(0,"");
        PersonNode temp = head.next;
        while(temp!=null){
            //存下当前那个
            PersonNode a = temp;
            //移动到下一个
            temp = temp.next;

            //头插法
            a.next = newHead.next;
            newHead.next = a;
        }
        return newHead;
    }

    //显示函数
    public void list(){
        PersonNode temp = head.next;
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //通过while循环找到链表的最后位置
        while (true){
            //如果 temp.next对象的内存地址为空 则结束循环  说明temp为链表的最后一个节点
            if (temp==null){
                break;
            }

            System.out.println(temp);
            //如果不是空则继续找到链表的末尾
            temp = temp.next;
        }
    }

    //逆序打印
    public void reversePr(){
        //辅助指针
        PersonNode temp = head.next;
        String sum = "";
        while (temp!=null){
            sum = temp.toString()+"\n"+ sum;
            temp = temp.next;
        }
        System.out.println(sum);
    }
    public void reversePr1(){
        //栈对象
        Stack<PersonNode> personNodes = new Stack<>();
        //辅助指针
        PersonNode temp = head.next;
        while (temp!=null){
            //入栈  先入后出
            personNodes.add(temp);
            temp = temp.next;
        }
        while (!personNodes.isEmpty()){
            //出栈
            System.out.println(personNodes.pop().toString());
        }
    }
}
