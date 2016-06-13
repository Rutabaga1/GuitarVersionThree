package main.java.model;
public enum Builder { 

  TAYLOR, MARTIN, GIBSON, YAMAHA, CORT, TAKAMINE, ANY;

  public String toString() {
    switch(this) {
      case TAYLOR:   return "Taylor";
      case MARTIN:   return "Martin";
      case GIBSON:   return "Gibson";
      case YAMAHA: return "Yamaha";
      case CORT:    return "Cort";
      case TAKAMINE:     return "Takamine";
      default:       return "allBuilder";
    }
  }
  
  
  public static Builder fromString(String name) {
	    for (Builder e : Builder.values()) {
	        if (e.toString().equals(name)) {
	            return e;
	        }
	    }
	    return null;
}
}

