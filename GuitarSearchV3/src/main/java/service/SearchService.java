package main.java.service;

import java.util.List;

import main.java.guitarDAO.DataFactory;
//import java.util.List;
import main.java.guitarDAO.IGuitar;
import main.java.model.*;

public class SearchService {
	private IGuitar guitarDAO=DataFactory.createIGiutarDAO();
	
    public Inventory getGuitars(){
    	return guitarDAO.getGuitars();
	}
    
    public List<Guitar> getAllGuitars(){
    	return guitarDAO.getAllGuitars();
	}
    
    public void addNewGuitars(Guitar guitar,String inventoryNum){
    	guitarDAO.addNewGuitar(guitar,inventoryNum);
    }
    
    public void deleteGuitars(String[] inventoryNum){
    	guitarDAO.deleteGuitar(inventoryNum);
    }
}
