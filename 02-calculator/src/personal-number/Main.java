
public class Main {
    public static void main(String[] args) {

        Item val9 = new Item (ItemType.VALUE, 9);
        Item val0 = new Item (ItemType.VALUE, 0);
        Item val2 = new Item (ItemType.VALUE, 2);
        Item val5 = new Item (ItemType.VALUE, 5);
        Item val1 = new Item (ItemType.VALUE, 1);
        Item val7 = new Item (ItemType.VALUE, 7);
        Item val10 = new Item (ItemType.VALUE,10);

        Item add = new Item(ItemType.ADD, 0);
        Item spec = new Item (ItemType.SPECIAL, 0);
        Item sub = new Item (ItemType.SUB, 0);
        Item mod = new Item (ItemType.MOD10, 0);

        Item[] expr = {val10, val9, spec, val0, add, val0, spec, add, val1, add,
        val2, spec, add, val5, add, val2, spec, add, val9, add, val5, spec, add, mod, sub};

        Calculator calculate = new Calculator(expr);

        System.out.println(calculate.run());

    }
}