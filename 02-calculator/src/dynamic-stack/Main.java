
public class Main {
    public static void main(String[] args) {

        Item val1 = new Item (ItemType.VALUE, 3);
        Item add1 = new Item (ItemType.ADD, 0);
        Item mul1 = new Item (ItemType.MUL, 0);

        Item[] expr = {val1, val1, val1, val1, val1, val1, add1, val1, mul1};
        Calculator calculate = new Calculator(expr);

        System.out.println(calculate.run());

    }
}
