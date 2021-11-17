import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        //return true;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE

        // Checking openingTime and closingTime against currentTime.
        // If currentTime falls in between opening and closing time returns true else false.
        LocalTime currentTime = getCurrentTime();

        if((openingTime == currentTime || currentTime.compareTo(openingTime) > 0) &&(currentTime.compareTo(closingTime)<0))
            return true;
        else
            return false;
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
       // return null;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE

        //adding menu item of Item class in List of menu and returning the same.

        menu.add(new Item("Sweet Corn Soup", 250));
        menu.add(new Item("Veg Crispy",800));
        menu.add(new Item("Veg Cheese Ball",2800));
        menu.add(new Item("Panner Tikka",1800));
        menu.add(new Item("Dumplings",900));
        menu.add(new Item("Mushroom Tikka",880));
        menu.add(new Item("Panner do Pyaza",1100));
        menu.add(new Item("Spring Roll",700));
        menu.add(new Item("Veg Cutlet",500));
        menu.add(new Item("Roti",80));
        menu.add(new Item("Butter Roti",100));
        menu.add(new Item("Nan",120));
        menu.add(new Item("Butter Nan",200));
        menu.add(new Item("Garlic Nan",250));
        menu.add(new Item("Diwani Handi",780));
        menu.add(new Item("Veg Dum Biryani",980));

        return menu;

    }
//This Method will get sum of price of selected item in order.
    public double getOrderValue(List<Item> orderList){
        double orderValue = 0.0;
        for(Item item:orderList){
            orderValue = orderValue + item.getPrice();
        }
        return orderValue;
    }
    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

}
