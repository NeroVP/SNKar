import javax.swing.JFrame;

public class Fenetre extends JFrame{
	private static final long serialVersionUID = 2470447715064566929L;

	public Panneau pan;
	
	public Fenetre()
	{
		this.setTitle("infoVoiture");
		this.setSize(1000,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		pan = new Panneau();
		this.setContentPane(pan);
		this.setVisible(true);
		
	}
}
