
public class Main {
    public static void main(String[] args) {

        Item val1 = new Item (ItemType.VALUE, 3);
        Item val2 = new Item (ItemType.VALUE, 4);
        Item val3 = new Item (ItemType.VALUE, 2);

        Item add1 = new Item(ItemType.ADD, 0);
        Item mul1 = new Item(ItemType.MUL, 0);

        Item[] expr = {val1, val2, add1, val3, val2, add1, mul1};

        Calculator calculate = new Calculator(expr);

        System.out.println(calculate.run());

    }
}
