public class Item {

    public ItemType type;
    public int value = 0;

    public Item (ItemType type, int value){
        this.type = type;
        this.value = value;
    }
    public ItemType type(){
        return this.type;
    }
    public int getValue(){
        return this.value;
    }
}
