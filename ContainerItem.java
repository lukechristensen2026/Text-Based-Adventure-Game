
import java.util.ArrayList;

public class ContainerItem extends Item {

    //Member Variables
    ArrayList<Item> items;

    //Constructor
    public ContainerItem(String pName, String pType, String pDescription) {
        super(pName, pType, pDescription);
        items = new ArrayList<>();
    }

    //addItem Method
    public void addItem(Item item) {
        items.add(item);
    }

    //hasItem Method
    public boolean hasItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
        
        /*
        for (int i = 0, i <items.size(); i++)
        {
            if(items.get(i).getName().equalsIgnoreCase(itemName)) {
                return true;
            }
            return false;
    
        }
        */   
    }

    //removeItem Method
    public Item removeItem(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(itemName)) {
                return items.remove(i);
            }
        }
        return null;
    }

    //Override toString Method
    /////Last thing
    @Override
    public String toString() {
        String result = getName() + " [ " + getType() + " ] : " + getDescription() + "that contains:\n";
        for(int i=0; i < items.size(); i++)
        {
            result += "+ " + items.get(i).getName() + "\n";
        }
        return result;
    }
}
