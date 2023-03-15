package homework3;

public class Main {
    public static void main(String[] args) {
        MyList li = new MyList();
        li.add(1);
        li.add(2);
        li.add(3);
        li.add(4);
        li.add(5);
        li.print();
        li.revert();
        li.print();
    }
}
