public class Main_0719_Proxy {

    public static void main(String[] args) {
        MiniPerson miniPerson = new MiniPerson(new Person());
        miniPerson.skill();
    }

}

interface Figure{
    void skill();
}
class Person implements Figure{

    @Override
    public void skill() {
        System.out.println("我是大人");
    }
}
class MiniPerson{
    private Figure figure;

    public MiniPerson(Figure figure){
        this.figure = figure;
    }
    public void skill() {
        System.out.println("我是小人");
        this.figure.skill();
    }
}