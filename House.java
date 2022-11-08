import java.util.ArrayList;

/** Builds a House, an extension of the Building class */
public class House extends Building {
  ArrayList<String> residents;
  boolean hasDiningRoom;
  boolean hasElevator;

/** Default constructor */
  public House() {
    this("<Name Unknown", "<Address Unknown>", 1, false, false);
  }

/** Overloaded constructor, name only
 * @param name name of the house
  */
  public House(String name) {
    this();
    this.name = name;
  }

/** Overloaded constructor, name and address only
 * @param name name of the house
 * @param address address of the house
 */
public House(String name, String address) {
  this();
  this.name = name;
  this.address = address;
}

  /** Full constructor for a house
   * @param name the name of the house
   * @param address the address of the house
   * @param nFloors the number of floors in the house
   * @param hasDiningRoom whether or not the house has a dining room
   * @param hasElevator whether or not the house has an elevator
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.residents = new ArrayList<String>();
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /** Main method */
  public static void main(String[] args) {
    House Cushing = new House("Cushing House", "1 Paradise Road Northampton MA 01063", 4, true, false);
    System.out.println(Cushing);
    Cushing.moveIn("Teia Shannon");
    Cushing.moveIn("The Creepy Bunny Head");
    System.out.println(Cushing.residents);
    Cushing.moveOut("Teia Shannon");
    System.out.println(Cushing.residents);
    Cushing.isResident("Teia Shannon");
    Cushing.showOptions();
    Cushing.enter();
    Cushing.goToFloor(3);
  }

  /** Add a resident to a house
   * @param name the name of the resident
   */
  public void moveIn(String name) {
    residents.add(name);
  }

  /** Remove a resident from the house
   * @param name the name of the resident
   * @return a string stating the name of the resident who has moved out
   */
  public String moveOut(String name) {
    residents.remove(name);
    System.out.println(name + " has moved out");
    return name;
  }

/** Check if someone is a resident of the house
 * @param name the name of the resident
 * @return T/F whether or not they are a resident of the house
*/
  public Boolean isResident(String name) {
    Boolean residentStatus = residents.contains(name);
    if (residentStatus = true) {
      System.out.println(name + " is a resident");
    }
    else if (residentStatus = false) {
      System.out.println(name + " is not a resident");
    }
    return residentStatus;
    }

/** Overridden method from the Building class, prints out a list of available methods in a class */
@Override
public void showOptions() {
  super.showOptions();
  System.out.print(" + moveIn() \n + moveOut() \n + isResident()");
}

/** Overridden method from the Building class, changes current floor
 * @param floorNum the floor you want to go to
 */
@Override
public void goToFloor(int floorNum) {
  if (hasElevator) {
    super.goToFloor(floorNum);
  }
  else {
    System.out.println("Sorry, this house does not have an elevator. Take the stairs!");
  }
}
}


