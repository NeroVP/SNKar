import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Titan extends JComponent {
	
	private Image imgTitan;
	private ImageIcon icoTitan;
	
	public Titan() {
		this.setIcoTitan(new ImageIcon(getClass().getResource("/img/Titan.png")));
		this.imgTitan = this.icoTitan.getImage();
	}

	public Image getImgTitan() {
		return imgTitan;
	}

	public void setImgTitan(Image imgTitan) {
		this.imgTitan = imgTitan;
	}

	public ImageIcon getIcoTitan() {
		return icoTitan;
	}

	public void setIcoTitan(ImageIcon icoTitan) {
		this.icoTitan = icoTitan;
	}
}
