public class Item {
    //Member Variables
    private String name;
    private String type;
    private String description;
 
    //Constructor
    public Item(String pName, String pType, String pDescription) {
        name = pName;
        type = pType;
        description = pDescription;
    }
 
    //Getter Accessor Methods
    public String getName() {
        return name;
    }
 
    public String getType() {
        return type;
    }
 
    public String getDescription() {
        return description;
    }
 
    //Setter Mutator Methods
    public void setName(String newName) {
        newName = name;
    }
 
    public void setType(String newType) {
        newType = type;
    }
 
    public void setDescription(String newDescription) {
        newDescription = description;
    }
    
    public String toString() {
        return name + "[" + type + "]" + description;
    }
 }
 