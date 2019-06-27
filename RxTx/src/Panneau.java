import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panneau extends JPanel implements Runnable{
	private Image imgMap, img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11
	, img12, img13, img14, img15, img16;
	private ImageIcon icoMap, ico1, ico2, ico3, ico4, ico5, ico6, ico7, ico8, ico9, ico10
	, ico11, ico12, ico13, ico14, ico15, ico16;
	private int pos = 0;
	private double vitesse;
	private boolean voitureEnMarche = true;
	Titan titan = new Titan();
	JLabel lab;
	
	/*public void update(Observable o, Object arg)
	{
		Deplacement();
	}*/
	
	public void Deplacement(String i)
	{
		switch(i){
			default:
			case "1":
				titan.setLocation(690, 230);
			break;
			case "2":
				titan.setLocation(690, 388);
			break;
			case "3":
				titan.setLocation(690, 495);
			break;
			case "4":
				titan.setLocation(353, 495);
			break;
			case "5":
				titan.setLocation(265, 495);
			break;
			case "6":
				titan.setLocation(265, 388);
			break;
			case "7":
				titan.setLocation(265, 297);
			break;
			case "8":
				titan.setLocation(265, 230);
			break;
			case "9":
				titan.setLocation(353, 230);
			break;
			case "10":
				titan.setLocation(353, 297);
			break;
			case "11":
				titan.setLocation(547, 297);
			break;
			case "12":
				titan.setLocation(547, 230);
			break;
			case "13":
				titan.setLocation(634, 230);
			break;
			case "14":
				titan.setLocation(634, 388);
			break;
			case "15":
				titan.setLocation(634, 435);
			break;
			case "16":
				titan.setLocation(353, 435);
			break;

		}
	}
	public Panneau()
	{
		super();
		
		icoMap = new ImageIcon(getClass().getResource("/img/Map.png"));
		this.imgMap = this.icoMap.getImage();
		ico1 = new ImageIcon(getClass().getResource("/img/1.png"));
		this.img1 = this.ico1.getImage();
		ico2 = new ImageIcon(getClass().getResource("/img/2.png"));
		this.img2 = this.ico2.getImage();
		ico3 = new ImageIcon(getClass().getResource("/img/3.png"));
		this.img3 = this.ico3.getImage();
		ico4 = new ImageIcon(getClass().getResource("/img/4.png"));
		this.img4 = this.ico4.getImage();
		ico5 = new ImageIcon(getClass().getResource("/img/5.png"));
		this.img5 = this.ico5.getImage();
		ico6 = new ImageIcon(getClass().getResource("/img/6.png"));
		this.img6 = this.ico6.getImage();
		ico7 = new ImageIcon(getClass().getResource("/img/7.png"));
		this.img7 = this.ico7.getImage();
		ico8 = new ImageIcon(getClass().getResource("/img/8.png"));
		this.img8 = this.ico8.getImage();
		ico9 = new ImageIcon(getClass().getResource("/img/9.png"));
		this.img9 = this.ico9.getImage();
		ico10 = new ImageIcon(getClass().getResource("/img/10.png"));
		this.img10 = this.ico10.getImage();
		ico11 = new ImageIcon(getClass().getResource("/img/11.png"));
		this.img11 = this.ico11.getImage();
		ico12 = new ImageIcon(getClass().getResource("/img/12.png"));
		this.img12 = this.ico12.getImage();
		ico13 = new ImageIcon(getClass().getResource("/img/13.png"));
		this.img13 = this.ico13.getImage();
		ico14 = new ImageIcon(getClass().getResource("/img/14.png"));
		this.img14 = this.ico14.getImage();
		ico15 = new ImageIcon(getClass().getResource("/img/15.png"));
		this.img15 = this.ico15.getImage();
		ico16 = new ImageIcon(getClass().getResource("/img/16.png"));
		this.img16 = this.ico16.getImage();
		lab = new JLabel("Vitesse de la voiture : "+ vitesse);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		
		g2.drawImage(this.imgMap, 200, 150, null);
		g2.drawImage(this.img1, 700, 240, null);
		g2.drawImage(this.img2, 700, 398, null);
		g2.drawImage(this.img3, 700, 505, null);
		g2.drawImage(this.img4, 363, 505, null);
		g2.drawImage(this.img5, 275, 505, null);
		g2.drawImage(this.img6, 275, 398, null);
		g2.drawImage(this.img7, 275, 307, null);
		g2.drawImage(this.img8, 275, 240, null);
		g2.drawImage(this.img9, 363, 240, null);
		g2.drawImage(this.img10, 363, 307, null);
		g2.drawImage(this.img11, 557, 307, null);
		g2.drawImage(this.img12, 557, 240, null);
		g2.drawImage(this.img13, 644, 240, null);
		g2.drawImage(this.img14, 644, 398, null);
		g2.drawImage(this.img15, 644, 445, null);
		g2.drawImage(this.img16, 363, 445, null);
		g2.drawImage(this.titan.getImgTitan(), titan.getLocation().x, titan.getLocation().y, null);
	}
	
	/*public static void lireBDD()
	{
		
		String url = "jdbc:mysql://localhost/sncar?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&autoReconnect=true&useSSL=false";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = (Statement) cn.createStatement();
			String sql = "SELECT position FROM donnee";
			rs = ((java.sql.Statement) st).executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getString("position"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				//st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}*/
	
	public double getVitesse() {
		return vitesse;
	}
	public void setVitesse(double vitesse) {
		this.vitesse = vitesse;
	}
	
	
	public JLabel getLab() {
		return lab;
	}
	public void setLab(JLabel lab) {
		this.lab = lab;
	}
	
	@Override
	public void run() {
		
		while(this.voitureEnMarche == true)
		{	
			vitesse = (Math.random()*(0.0+2.5));
			lab.setText("Vitesse de la voiture : "+ vitesse);
			add(getLab());
			//Deplacement(pos++);
			//repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
