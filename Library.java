/* This is a stub for the Library class */
import java.util.Hashtable;

public class Library extends Building {
  Hashtable<String, Boolean> collection;
  boolean hasElevator;

    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<>();
      this.hasElevator = hasElevator;
      System.out.println("You have built a library: 📖");
    }
  
    public static void main(String[] args) {
      Library Neilson = new Library("Neilson Library", "1 Neilson Drive Northampton MA 01063", 4, true);
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
    }
  
    public void addTitle(String title) {
      collection.put(title, true);
    }

    public String removeTitle(String title) {
      collection.remove(title, true);
      return title;
    }

    public void checkOut(String title) {
      collection.replace(title, false);
    }

    public void returnTitle(String title) {
      collection.replace(title,true);
    }

    public Boolean containsTitle(String title) {
      return collection.contains(title);
    }

    public Boolean isAvailable(String title) {
      return collection.get(title);
    }

    public void printCollection() {
      System.out.println(collection.toString());
    }

    @Override
    public void showOptions() {
      super.showOptions();
      System.out.print(" + addTitle() \n + removeTitle() \n + checkOut() \n + returnTitle() \n + containsTitle() \n + isAvailable() \n + printCollection()");
    }
  }