package projet.isen.java2.db.daos;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceFactory {

	private static MysqlDataSource dataSource;
	
	/*
	 * this function is setting our data source information {name of the server, the port used, the database name, the user name and the password}
	 * @param: String strNum
	 * @return : Boolean
	 * @author : Ouassim AKEBLI
	 * */
	public static DataSource getDataSource() {
		if(dataSource == null) {
			dataSource = new MysqlDataSource();
			dataSource.setServerName("localhost");
			dataSource.setPort(3306);
			dataSource.setDatabaseName("projetjava2");
			dataSource.setUser("root");
			dataSource.setPassword("");
		}
		return dataSource;
	}
}
