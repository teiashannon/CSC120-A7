/** Builds a Cafe, extension of the Building class */
public class Cafe extends Building {
    int nCoffeeOunces;
    int nSugarPackets;
    int nCreams;
    int nCups;
/** Default constructor */
public Cafe() {
    this("<Name Unknown>", "<Address Unknown>", 1, 0, 0, 0, 0);
}

/** Overloaded constructor, name only */
public Cafe(String name) {
    this();
    this.name = name;
}

/** Overloaded constructor, name and address only */
public Cafe(String name, String address) {
    this();
    this.name = name;
}

/** Constructor for a Cafe
 * @param name the name of the cafe
 * @param address the address of the cafe
 * @param nFloors the number of floors in the cafe
 * @param nCoffeeOunces the number of ounces of coffee currently in stock
 * @param nSugarPackets the number of sugar packets currently in stock
 * @param nCreams the number of creams currently in stock
 * @param nCups the number of cups currently in stock
 */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }
    
/** Main method */
    public static void main(String[] args) {
        Cafe ShelburneFalls = new Cafe("Shelburne Falls", "322 Russell St Hadley MA 01035", 1, 12, 25, 25, 50);
        System.out.println(ShelburneFalls);
        ShelburneFalls.sellCoffee(12, 2, 3);
        ShelburneFalls.sellCoffee(12, 4, 1);
        ShelburneFalls.showOptions();
        ShelburneFalls.enter();
        ShelburneFalls.goToFloor(4);
    }

/** Sell a cup of coffee
 * @param size the number of ounces of coffee sold
 * @param sugars the number of sugars sold
 * @param creams the number of creams sold
 */
    public void sellCoffee(int size, int sugars, int creams) {
        if (size > nCoffeeOunces) {
            restock(nCoffeeOunces, nSugarPackets, nCreams, nCups);
        }
        nCoffeeOunces = nCoffeeOunces - size;
        if (sugars > nSugarPackets) {
            restock(nCoffeeOunces, nSugarPackets, nCreams, nCups);
        }
        nSugarPackets = nSugarPackets - sugars;
        if (creams > nCreams) {
            restock(nCoffeeOunces, nSugarPackets, nCreams, nCups);
        }
        nCreams = nCreams - creams;
        if (nCups == 0) {
            restock(nCoffeeOunces, nSugarPackets, nCreams, nCups);
        }
        nCups = nCups - 1;
        System.out.println("A " + size + " ounce coffee with " + sugars + " sugars " + "and " + creams + " creams is ready.");
    }

/** Restock the inventory when it becomes sold out
 * @param nCoffeeOunces number of ounces of coffee in stock
 * @param nSugarPackets number of sugar packets in stock
 * @param nCreams number of creams in stock
 * @param nCups number of cups in stock
 */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        nCoffeeOunces = nCoffeeOunces + 100;
        nSugarPackets = nSugarPackets + 50;
        nCreams = nCreams + 50;
        nCups = nCups + 250;
        System.out.println("The supplies are restocked.");
    }
/** Overridden method from the Building class, prints out a list of available methods in a class */
    @Override
    public void showOptions() {
        super.showOptions();
        System.out.print(" + sellCoffee()");
    }
/** Overridden method from the Building class, changes current floor
 * @param floorNum the floor you want to go to
 */
    @Override
    public void goToFloor(int floorNum) {
        System.out.println("Sorry, this cafe does not have any additional floors for customers!");
    }
}
