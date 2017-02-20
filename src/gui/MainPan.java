package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.synth.SynthSeparatorUI;

import sqlite.GestionBDD;
import technique.KeyJtaListener;
import technique.LiaisonBdGui;

public class MainPan extends JPanel{
	
	private JTextArea jtaText;
	private JButton jbColler,jbCopier,jbClear;
	
	private Box buttonBox;
	private WordPan wp;
	
	private int limitText=10;
	private GestionBDD bdd;
	private Window w;
	private InfoPan ip;
	private Menu m;
	
	public MainPan(GestionBDD bdd,Window w)
	{
		this.bdd=bdd;
		this.w=w;
		this.setLayout(new BorderLayout());
		jtaText=new JTextArea(5, 5);
		jbColler=new JButton("Coller");
		jbCopier=new JButton("Copier");
		jbClear=new JButton("Effacer");
		wp=new WordPan(this);
		ip=new InfoPan();
		m=new Menu(this);
		
		buttonBox=Box.createVerticalBox();
		buttonBox.add(jbColler);
		buttonBox.add(jbCopier);
		buttonBox.add(jbClear);
		
		jtaText.setFont(new Font("Arial", Font.PLAIN, 16));
		jtaText.setLineWrap(true);
		
		jbCopier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringSelection ss = new StringSelection(jtaText.getText());
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
			}
		});
		
		jbColler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jtaText.setText(jtaText.getText()+(String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor));
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (UnsupportedFlavorException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		jbClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtaText.setText("");
			}
		});
		
		jtaText.getDocument().addDocumentListener(new DocumentListener()
				{
					public void changedUpdate(DocumentEvent arg0) {
					}
					public void insertUpdate(DocumentEvent arg0) {
						String[] table=(jtaText.getText().substring(0,jtaText.getCaretPosition()+1).replaceAll("'"," ")).split(" ");
						LiaisonBdGui.updateDocument(table[table.length-1], limitText, true);
					}
					public void removeUpdate(DocumentEvent arg0) {
					}
				});
		jtaText.addKeyListener(new KeyJtaListener());
		
		this.add(wp,BorderLayout.WEST);
		this.add(buttonBox, BorderLayout.EAST);
		this.add(jtaText, BorderLayout.CENTER);
		this.add(ip,BorderLayout.SOUTH);
		w.setJMenuBar(m);
		
		
	}
	
	public void changeCurentWord(String word)
	{
		String strrcv=jtaText.getText().substring(0,jtaText.getCaretPosition());
		//System.out.println("text: "+strrcv);
		String[] table=strrcv.split(" ");
		if(table.length>0)
			jtaText.setText( (jtaText.getText().substring(0,jtaText.getCaretPosition())) +
					word.substring(table[table.length-1].length()) + 
					(jtaText.getText().substring(jtaText.getCaretPosition())) );
	}
	public String getWordAtKey(int key)
	{
		return wp.getWordAt(key);
	}
	
	public void setInformations(String []info)
	{
		ip.setText(info);
	}
	public void setWords(String []texts)
	{
		wp.setWords(texts);
	}
	
	
}
