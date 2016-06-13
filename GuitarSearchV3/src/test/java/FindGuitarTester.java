package test.java;
import java.util.Iterator;
import java.util.List;
import main.java.model.*;

public class FindGuitarTester {

  public static void main(String[] args) {
    // Set up Rick's guitar inventory
    Inventory inventory = new Inventory();
    initializeInventory(inventory);

    GuitarSpec whatErinLikes = 
      new GuitarSpec(Builder.MARTIN, "red", Type.ELECTRIC, "6");
    List<Guitar> matchingGuitars = inventory.search(whatErinLikes);
    if (!matchingGuitars.isEmpty()) {
      System.out.println("Erin, you might like these guitars:");
      for (Iterator<Guitar> i = matchingGuitars.iterator(); i.hasNext(); ) {
        Guitar guitar = i.next();
        GuitarSpec spec = guitar.getSpec();
        System.out.println("  We have a " +
          spec.getBuilder() + " " + spec.getColor() + " " +
          spec.getType() + " guitar.\n     "+
          " the number of strings:  "+spec.getNumStrings() + "\n"+
          "  You can have it for only $" +
          guitar.getPrice() + "!\n  ----");
      }
    } else {
      System.out.println("Sorry, Erin, we have nothing for you.");
    }
  }

  private static void initializeInventory(Inventory inventory) {
    inventory.addGuitar("11277", 3999.95, 
      new GuitarSpec(Builder.TAYLOR, "blue", Type.ACOUSTIC, "6"));
    inventory.addGuitar("V95693", 1499.95, 
      new GuitarSpec(Builder.MARTIN, "red", Type.ELECTRIC, "6"));
    inventory.addGuitar("V9512", 1549.95, 
      new GuitarSpec(Builder.MARTIN, "red", Type.ELECTRIC, "6"));
    inventory.addGuitar("122784", 5495.95, 
      new GuitarSpec(Builder.MARTIN, "blue", Type.ACOUSTIC, "6"));
    inventory.addGuitar("76531", 6295.95, 
      new GuitarSpec(Builder.MARTIN, "blue", Type.ACOUSTIC, "6"));
    inventory.addGuitar("70108276", 2295.95, 
      new GuitarSpec(Builder.GIBSON, "black", Type.ELECTRIC, "6"));
    inventory.addGuitar("82765501", 1890.95, 
      new GuitarSpec(Builder.GIBSON, "black", Type.ELECTRIC, "6"));
    inventory.addGuitar("77023", 6275.95, 
      new GuitarSpec(Builder.MARTIN, "brown", Type.ACOUSTIC, "6"));
    inventory.addGuitar("1092", 12995.95, 
      new GuitarSpec(Builder.CORT, "brown", Type.ACOUSTIC, "12"));
    inventory.addGuitar("566-62", 8999.95, 
      new GuitarSpec(Builder.TAKAMINE, "brown", Type.ACOUSTIC, "12"));
    inventory.addGuitar("6 29584", 2100.95, 
      new GuitarSpec(Builder.CORT, "brown", Type.ELECTRIC,"6"));
  }
}
