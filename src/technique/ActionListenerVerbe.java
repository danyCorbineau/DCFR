package technique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import graphique.BoiteVerbe;
import graphique.BoxRecherchePan;

public class ActionListenerVerbe implements ActionListener{
	public static BoxRecherchePan brp=new BoxRecherchePan();
	public static JTextField jtf=new JTextField();
	public static JButton jbValide=new JButton("Rechercher");
	public static JLabel message=new JLabel("Chercher un verbe");
	public static ActionListenerRechercheVerbe alrv=new ActionListenerRechercheVerbe();
	public static DocumentListenerTextRechercheVerbe dltrv=new DocumentListenerTextRechercheVerbe();
	
	public static BoiteVerbe bv=new BoiteVerbe("Recherche verbe");
	public static JList<String> jl=new JList<>();
	
	public void actionPerformed(ActionEvent arg0) {
		
		jtf.getDocument().addDocumentListener(dltrv);
		
		brp.add(message);
		brp.add(jtf);
		
		brp.add(jbValide);
		brp.add(new JScrollPane(jl));
		
		bv.add(brp);
		
		jbValide.addActionListener(alrv);
		
		bv.setVisible(true);
	}
	
	
	

}
