package main.java.model;
public enum Type { 

  ACOUSTIC, ELECTRIC,ANY;

  public String toString() {
    switch(this) {
      case ACOUSTIC: return "acoustic";
      case ELECTRIC: return "electric";
      default:       return "allType";
    }
  }
  
  public static Type fromString(String name) {
	    for (Type e : Type.values()) {
	        if (e.toString().equals(name)) {
	            return e;
	        }
	    }
	    return null;
}
}
