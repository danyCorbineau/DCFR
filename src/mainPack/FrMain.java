package mainPack;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import graphique.ButtonPan;
import graphique.CenterPan;
import graphique.InfoPan;
import graphique.MainPan;
import graphique.Menu;
import graphique.Window;
import graphique.WordPan;
import graphique.ZoneSaisie;
import technique.ActionListenerColler;
import technique.ActionListenerCopier;
import technique.ActionListenerInformations;
import technique.BaseDeDonne;
import technique.DocumentListenerText;
import technique.FrWindowListener;
import technique.KeyListenerText;

public class FrMain {
	public static Window w;
	public static MainPan mp;
	public static CenterPan cp;
	public static ButtonPan bp;
	public static WordPan wp;
	public static InfoPan ip;
	public static Menu m;
	
	public static FrWindowListener fwl;
	public static ActionListenerColler alCol;
	public static ActionListenerCopier alCop;
	public static DocumentListenerText dlt;
	public static ActionListenerInformations ali;
	public static KeyListenerText klt;
	
	
	public static JButton bpColler, bpCopier, bpInfo;
	public static JTextArea cpText;
	public static JMenuItem mChercheVerbe;
	public static JList wpList;
	
	
	public static BaseDeDonne bdd;
	public static ApliParam ap;
	
	public static void main(String[] args) {
		w=new Window();
		mp=new MainPan();
		cp=new CenterPan();
		bp=new ButtonPan();
		wp=new WordPan();
		ip=new InfoPan();
		m=new Menu();
		
		/*
		 * Listener
		 */
		fwl=new FrWindowListener();
		alCol=new ActionListenerColler();
		alCop=new ActionListenerCopier();
		dlt=new DocumentListenerText();
		ali=new ActionListenerInformations();
		klt=new KeyListenerText();
		
		/*
		 * button +
		 */
		bpColler=new JButton("Coller");
		bpCopier=new JButton("Copier");
		bpInfo=new JButton("Informations");
		cpText=new ZoneSaisie();
		mChercheVerbe=new JMenuItem("Verbe");
		wpList=new JList<String>();
		
		/*
		 * Base de données
		 */
		bdd=new BaseDeDonne("testLex");
		ap=new ApliParam();
		
		/*
		 * window initialisation	,	main pan initialisation	,	button pan initialisation	,	center pan initialisation	,	menu bar initialisation
		 */
		w.addPanelAndBar(mp, m);
		
		mp.addPanels(new JPanel[]{cp,ip,bp,wp});

		bp.addButons(new JButton[]{bpColler,bpCopier,bpInfo});

		cp.addJTextArea(cpText);
		
		wp.addList(wpList);

		m.addButton(new JMenuItem[]{mChercheVerbe});
		
		
		
		/*
		 * Add Listeners
		 */
		w.addWindowListener(fwl);
		bpColler.addActionListener(alCol);
		bpCopier.addActionListener(alCop);
		cpText.getDocument().addDocumentListener(dlt);
		bpInfo.addActionListener(ali);
		cpText.addKeyListener(klt);
		
		w.setVisible(true);
		
	}
	
	

}
