package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{
	
	private JMenu jmChercher = new JMenu("Chercher");
	private MainPan mp;
	
	private JMenuItem  jmiVerb=new JMenuItem ("Verbe");
	
	public Menu(MainPan mp)
	{
		this.mp=mp;
		
		jmChercher.add(jmiVerb);
		
		jmiVerb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("rehcerche verbe");
			}
		});
		
		this.add(jmChercher);
	}

}
