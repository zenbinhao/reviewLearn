package study_0924;

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


    }
}
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
class LinkList{
    private PersonNode head = new PersonNode(0,"");

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
    //显示函数
    public void list(){
        PersonNode temp = head.next;

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
}
