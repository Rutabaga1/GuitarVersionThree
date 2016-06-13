package main.java.sqliteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import main.java.guitarDAO.IGuitar;
import main.java.model.*;
import main.java.util.DBUtil;


public class IGuitarDAOImpl implements IGuitar{
	
	
	@Override
	public Inventory getGuitars() {
		Connection conn = DBUtil.getSqliteConnection();
		PreparedStatement stmt=null;
		SQLException ex=null;
		Inventory inventory=null;
		try{
			
			stmt=conn.prepareStatement("SELECT serialNumber,type,price,numStrings,color,builder FROM Guitar where inventoryNum!=0");
			/*stmt.setString(1, admin.getCname());
			stmt.setString(2, admin.getCplace());*/
			ResultSet rs=stmt.executeQuery();
			inventory = new Inventory();
			while(rs.next()){
			    inventory.addGuitar(rs.getString("serialNumber"), Double.valueOf(rs.getString("price")), 
			    		new GuitarSpec(Builder.fromString(rs.getString("builder")),rs.getString("color"),
			    				Type.fromString(rs.getString("type")),rs.getString("numStrings")));
				
			}
			}catch(SQLException e){
				ex=e;
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
				}
			if(ex!=null){
				throw new RuntimeException(ex);
			}
			}
		return inventory;
	}
	
	@Override
	public List<Guitar> getAllGuitars() {
		Connection conn = DBUtil.getSqliteConnection();
		PreparedStatement stmt=null;
		SQLException ex=null;
		List<Guitar> Guitars=null;
		Guitar guitar=null;
		try{
			
			stmt=conn.prepareStatement("SELECT serialNumber,type,price,numStrings,color,builder,inventoryNum FROM Guitar");
			/*stmt.setString(1, admin.getCname());
			stmt.setString(2, admin.getCplace());*/
			ResultSet rs=stmt.executeQuery();
			Guitars=new ArrayList<Guitar>();
			while(rs.next()){
				guitar=new Guitar(rs.getString("serialNumber"), Double.valueOf(rs.getString("price")), 
			    		new GuitarSpec(Builder.fromString(rs.getString("builder")),rs.getString("color"),
			    			Type.fromString(rs.getString("type")),rs.getString("numStrings")),rs.getString("inventoryNum"));
				Guitars.add(guitar);
			}
			}catch(SQLException e){
				ex=e;
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
				}
			if(ex!=null){
				throw new RuntimeException(ex);
			}
			}
		return Guitars;
	}
	
	@Override
	public void addNewGuitar(Guitar guitar,String inventoryNum) {
		Connection conn=null;
		PreparedStatement stmt=null;
		SQLException ex=null;
		
		try{
			conn=DBUtil.getSqliteConnection();
			stmt=conn.prepareStatement("INSERT INTO Guitar(serialNumber,type,price,numStrings,color,builder,inventoryNum) VALUES(?,?,?,?,?,?,?)");
			stmt.setString(1, guitar.getSerialNumber());
			stmt.setString(2,guitar.getSpec().getType().toString());
			stmt.setString(3, String.valueOf(guitar.getPrice()));
			stmt.setString(4, guitar.getSpec().getNumStrings());
			stmt.setString(5,guitar.getSpec().getColor());
			stmt.setString(6, guitar.getSpec().getBuilder().toString());
			stmt.setString(7,inventoryNum);
			
			stmt.executeUpdate();
			}catch(SQLException e){
				ex=e;
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
				}
			if(ex!=null){
				throw new RuntimeException(ex);
			}
			}
	}

	@Override
	public void deleteGuitar(String[] serialNumbers) {
		Connection conn=null;
		PreparedStatement stmt=null;
		SQLException ex=null;
		try{
			conn=DBUtil.getSqliteConnection();
				for(int i=0;i<serialNumbers.length;i++){
					stmt=conn.prepareStatement("DELETE FROM Guitar WHERE serialNumber=?");
					stmt.setString(1,serialNumbers[i]);
					//stmt.setString(2, administrator.getPassword());
					stmt.executeUpdate();
				}
			}catch(SQLException e){
				ex=e;
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
				}
			if(ex!=null){
				throw new RuntimeException(ex);
			}
			}
		DeleteFile del=new DeleteFile();
		for(int i=0;i<serialNumbers.length;i++){//É¾³ýÍ¼Æ¬ÎÄ¼þ
			del.deleteFile(serialNumbers[i]);
		}
	}
	
	
}
