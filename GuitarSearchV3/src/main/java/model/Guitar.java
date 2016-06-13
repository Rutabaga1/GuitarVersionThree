package main.java.model;
public class Guitar {

  private String serialNumber;
  private double price;
  GuitarSpec spec;
  private String inventoryNum;

  public Guitar(String serialNumber, double price, GuitarSpec spec) {
    this.serialNumber = serialNumber;
    this.price = price;
    this.spec = spec;
  }
  
  public Guitar(String serialNumber, double price, GuitarSpec spec,String inventoryNum) {
	    this.serialNumber = serialNumber;
	    this.price = price;
	    this.spec = spec;
	    this.inventoryNum = inventoryNum;
	  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(float newPrice) {
    this.price = newPrice;
  }

  public GuitarSpec getSpec() {
    return spec;
  }

public String getInventoryNum() {
	return inventoryNum;
}

}
