
public class Main {
    public static void main(String[] args) {

        Item val1 = new Item (ItemType.VALUE, 1);
        Item val2 = new Item (ItemType.VALUE, 2);
        Item val3 = new Item (ItemType.VALUE, 3);
        Item val4 = new Item (ItemType.VALUE, 4);
        Item val5 = new Item (ItemType.VALUE, 5);

        Item add = new Item (ItemType.ADD, 0);
        Item mul = new Item (ItemType.MUL, 0);
        Item sub = new Item (ItemType.SUB, 0);
        Item div = new Item (ItemType.DIV, 0);

        Item[] expr = {val1, val2, val3, val4, val5,
                    val1, val2, val3, val4, val5,
                    add, mul, sub, div, add, mul, sub};

        Calculator calculate = new Calculator(expr);

        System.out.println(calculate.benchmark());

    }
}
