package main.java.guitarDAO;

public class DataFactory {
	private static String daoName = "main.java.sqliteDAO";

	public static IGuitar createIGiutarDAO() {
		IGuitar result = null;
		try {
			Object o = Class.forName(daoName + "." + "IGuitarDAOImpl").newInstance();
			result = (IGuitar)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
