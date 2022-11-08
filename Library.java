/* This is a stub for the Library class */
import java.util.Hashtable;

/** Builds a Library, an extension of the Building class */
public class Library extends Building {
  Hashtable<String, Boolean> collection;


/** Default constructor */
public Library() {
  this("<Name Unknown>", "<Address Unknown", 1);
}

/** Overloaded constructor, name only */
public Library(String name) {
  this();
  this.name = name;
}

/** Overloaded constructor, name and address only */
public Library(String name, String address) {
  this();
  this.name = name;
  this.address = address;
}

/** Full constructor for a Library
 * @param name the name of the library
 * @param address the address of the library
 * @param nFloors the number of floors in the library
 */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<>();
      System.out.println("You have built a library: 📖");
    }
  
  /** Main method */
    public static void main(String[] args) {
      Library Neilson = new Library("Neilson Library", "1 Neilson Drive Northampton MA 01063", 4);
      System.out.println(Neilson);
      Neilson.addTitle("The Picture of Dorian Gray");
      Neilson.addTitle("The Great Gatsby");
      Neilson.addTitle("Emma");
      Neilson.removeTitle("The Great Gatsby");
      Neilson.checkOut("Emma");
      Neilson.returnTitle("Emma");
      Neilson.containsTitle("The Picture of Dorian Gray");
      Neilson.isAvailable("The Picture of Dorian Gray");
      Neilson.printCollection();
      Neilson.showOptions();
      Neilson.enter();
      Neilson.goToFloor(3);
    }
  
  /** Add a book to the library
   * @param title the name of the book
    */
    public void addTitle(String title) {
      collection.put(title, true);
    }

  /** Remove a book from the library
   * @param title the name of the book
   * @return the title that was removed
   */
    public String removeTitle(String title) {
      collection.remove(title, true);
      return title;
    }

  /** Check a book out from the library
   * @param title the name of the book
   */
    public void checkOut(String title) {
      collection.replace(title, false);
    }

  /** Return a checked-out book to the library
   * @param title the name of the book
   */
    public void returnTitle(String title) {
      collection.replace(title,true);
    }

  /** Check if a certain book is in the library's collection
   * @param title the name of the book
   * @return T/F whether or not the book is in the library's collection
   */
    public Boolean containsTitle(String title) {
      return collection.contains(title);
    }

  /** Check if a certain book is available for checkout in the library
   * @param title the name of the book
   * @return T/F whether or not the book is available to be checked out
   */
    public Boolean isAvailable(String title) {
      return collection.get(title);
    }

  /** Print the entire collection of books in the library */
    public void printCollection() {
      System.out.println(collection.toString());
    }

  /** Overridden method from the Building class, prints out a list of available methods in a class */
    @Override
    public void showOptions() {
      super.showOptions();
      System.out.print(" + addTitle() \n + removeTitle() \n + checkOut() \n + returnTitle() \n + containsTitle() \n + isAvailable() \n + printCollection()");
    }

  /** Overridden method from the Building class, changes current floor
 * @param floorNum the floor you want to go to
 */
    @Override
    public void goToFloor(int floorNum) {
        super.goToFloor(floorNum);
    }
  }