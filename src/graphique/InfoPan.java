package graphique;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPan extends JPanel{
		
		public InfoPan()
		{
			
		}
		public void affInfoWord(String info[])
		{
			this.removeAll();
			GridLayout gl=new GridLayout(3,2);
			
			this.setLayout(gl);
			gl.setHgap(5);
			gl.setVgap(5);
			for(String i : info)
				this.add(new JLabel(i));
		}
		
}
