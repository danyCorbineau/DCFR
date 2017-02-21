package graphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class WindowVerbe extends JDialog{
	
	public WindowVerbe(String verbe)
	{
		super((JFrame)null, verbe, true);
		this.setSize((int) ((int)200*3), 80*3);
	    this.setLocationRelativeTo(null);
	    this.setResizable(true);
	    
	    String []tempsIndicatif={"Présent", "Passé composé", "Imparfait", "Plus-que-parfait", "Passé simple", "Passé antérieur", "Futur simple", "Futur antérieur"};
	    
	    JTabbedPane jtp=new JTabbedPane();
	    jtp.add(
	    		new PanMode(
	    			tempsIndicatif,
	    			new String[][]{
	    				new String[]{" "},
	    				new String[]{" "},
	    				new String[]{" "},
	    				new String[]{" "},
	    				new String[]{" "},
	    				new String[]{" "},
	    				new String[]{" "},
	    				new String[]{" "}
	    			}
	    		),
	    		"Indicatif");
	    
	    /*jtp.add(new PanMode(),"Conditionnel");
	    jtp.add(new PanMode(),"Impératif");
	    jtp.add(new PanMode(),"Infinitif");
	    jtp.add(new PanMode(),"Participe");
	    jtp.add(new PanMode(),"Gerondif");*/
	    
	    this.add(jtp);
	    
	    this.setVisible(true);
	}
	
	public class PanMode extends JPanel{
		public PanMode(String[]temps , String[] ... cong) {
			this.setLayout(new GridLayout(3,temps.length/3+1));
			
			for(int j=0;j<temps.length;j++)
			{
				this.add(new BoiteTemps(temps[j],cong[j]));
			}
		}
		
		public class BoiteTemps extends JPanel{
			public BoiteTemps(String temps,String cong[])
			{
				this.setBorder(BorderFactory.createLineBorder(Color.black));
				
				TitledBorder title;
				title = BorderFactory.createTitledBorder(
		                this.getBorder(),temps);
				this.setBorder(title);
				
				
				
				this.add(new JTextField("azerty"));
				
			}
		}
		
	}
	
	
	
	
}

