
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item implements ItemInterface
{
    private String name;
    private float weight;
    private float volume;
    private float sellValue;
    private float buyValue;
    private ItemInterface decorator;
    
    /**
     * Constructor for objects of class Item
     */
    public Item()
    {
        this("<Item>", 1, 1, 1, 1);
    }
    
    public Item(String name, float weight, float volume, float sellValue, float buyValue) {
        this.name = name;
        this.weight = weight;
        this.volume = volume;
        this.sellValue = sellValue;
        this.buyValue = buyValue;
        this.decorator = null;
    }
    
    public String getName() {
        return name;
    }
    
    public String getLongName() {
        return getName() + (decorator == null?"":":" + decorator.getName());
    }
    
    public float getWeight() {
        return weight + (decorator == null?0:decorator.getWeight());
    }
    
    public float getVolume() {
        return volume + (decorator == null?0:decorator.getVolume());
    }
    
    public float getSellValue() {
        return sellValue + (decorator == null?0:decorator.getSellValue());
    }
    
    public float getBuyValue() {
        return buyValue + (decorator == null?0:decorator.getBuyValue());
    }
    
    //This changes the values of the item by adding a decorator
    public void addDecorator(ItemInterface decorator) {
        if(this.decorator == null) {
            this.decorator = decorator;
        }
        else {
            this.decorator.addDecorator(decorator); //This is a Linked List
        }
    }
    
    public boolean isContainer() {
        return false;
    }
    
    public void addItem(ItemInterface item) {
        
    }
    
    public ItemInterface removeItem(String itemName) {
        return null;
    }
    
    public String[] getList() {
        return null;
    }
    
    public String toString() {
        return getLongName() + ", weight: " + getWeight() + ", volume: " + getVolume();
    }
}
