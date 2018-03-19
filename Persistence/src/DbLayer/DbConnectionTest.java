package DBLayer;

public class DbConnectionTest {

	public static void main(String[] args) {
		
		try {
			DbConnection.getInstance().connect();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
}