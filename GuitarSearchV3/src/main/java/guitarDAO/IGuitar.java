package main.java.guitarDAO;

import main.java.model.Guitar;
import java.util.List;
import main.java.model.Inventory;

public interface IGuitar {
		void addNewGuitar(Guitar guitar,String inventoryNum);
		Inventory getGuitars();
		List<Guitar> getAllGuitars();
		void deleteGuitar(String[] serialNumber);
		//List<Guitar> getGuitars(Guitar userGuitar);
		
		
		//List<Guitar> getInventoryGuitars();
}
