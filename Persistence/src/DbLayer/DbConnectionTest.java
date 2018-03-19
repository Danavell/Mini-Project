package DbLayer;

public class DbConnectionTest {

	public void test() {
		DbConnection dbCon = DbConnection.getInstance();
		if(dbCon != null)
		{
			System.out.println("Conecction to DB is ok");
		}
		else{
		    //fail("Can not connect to the DB");
		}
	}

}
