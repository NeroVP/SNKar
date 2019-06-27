import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class Main {
	public static void main(String[] args) {
		String i;
		Fenetre fenetre = new Fenetre();
		SerialTest main = new SerialTest();
		main.initialize();
		Thread t = new Thread() {
			public void run() {
//the following line will keep this app alive for 1000 seconds,
//waiting for events to occur and responding to them (printing incoming messages to console).
				try {
					Thread.sleep(1000000);
				} catch (InterruptedException ie) {
				}
			}
		};
		t.start();
		System.out.println(" Started ");
	
	while (true) {
		
		String url = "jdbc:mysql://localhost/sncar?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&autoReconnect=true&useSSL=false";

		String login = "root";

		String passwd = "";



		Connection cn = null;

		java.sql.Statement st = null;

		ResultSet rs = null;

		String data = null;



		// System.out.print(i);



		try {

			Class.forName("com.mysql.jdbc.Driver");



			cn = DriverManager.getConnection(url, login, passwd);



			st = cn.createStatement();



			String sql = "SELECT position FROM donnee";



			rs = st.executeQuery(sql);



			while (rs.next()) {

				data = rs.getString("position");

				// System.out.println(rs.getString("position"));

			}



		} catch (SQLException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} finally {

			try {

				cn.close();

				st.close();

			} catch (SQLException e) {

				e.printStackTrace();

			}

		}
		i = data;
		//fenetre.pan.run();
		fenetre.pan.Deplacement(i);
		fenetre.pan.repaint();
		}
	
	}
}
		

