package technique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDeDonne {
	private Connection c = null;
	
	public BaseDeDonne(String base)
	{
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:"+base+".db");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("Getclass error");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connexion error ");
		}
	}
	
	public void closeDbConnexion()
	{
		if(c!=null)
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public String[] selectWord(String start, int lim,boolean order)// when typing
	{
		ResultSet rs=null;
		Statement stmt;
		String rqt;
		
		String text[]=new String[lim];
		
		if (order)
			rqt="SELECT ortographe FROM lexique WHERE ortographe LIKE '"+start+"%' ORDER BY frequence_livre DESC LIMIT "+lim+";";
		else
			rqt="SELECT ortographe FROM lexique WHERE ortographe LIKE '"+start+"%' LIMIT "+lim+";";
				
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery(rqt);
			
			for(int j=0;rs.next();j++)
				text[j]=rs.getString(1);
			
			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return text;
	}
	
	public String[] selectWordComplet(String word) // when clic info
	{
		ResultSet rs=null;
		String ret[] = null;
		String rqt;
		Statement stmt;
		rqt="SELECT ortographe AS Orthographe,lemme AS Lemme, categorie_grammatical AS \"Catégorie grammaticale\", genre AS Genre, nombre AS Nombre, infoverbe AS \"Information verbe\" FROM lexique WHERE ortographe='"+word+"';";
		
		try {
			stmt = c.createStatement();
			
			rs = stmt.executeQuery(rqt);
			
			if(rs.next())
			{
				ret=new String[rs.getMetaData().getColumnCount()];
				for(int j=1;j<rs.getMetaData().getColumnCount()+1;j++)
					ret[j-1]=rs.getMetaData().getColumnLabel(j)+" : "+rs.getString(j);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public boolean verbeExist(String verbe)
	{
		ResultSet rs=null;
		String rqt;
		Statement stmt;
		rqt="SELECT ortographe FROM lexique WHERE ortographe='"+verbe+"' AND categorie_grammatical LIKE '%V%' AND infoverbe LIKE '%inf%';";
		boolean ret=false;
		
		try {
			stmt = c.createStatement();
			
			rs = stmt.executeQuery(rqt);
			
			if(rs.next())
			{
				System.out.println(rs.getString(1));
				ret=true;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public String[] listVerb(String word)
	{
		ResultSet rs=null;
		String rqt;
		Statement stmt;
		rqt="SELECT ortographe FROM lexique WHERE ortographe LIKE '"+word+"%' AND categorie_grammatical LIKE '%V%' AND infoverbe LIKE '%inf%' LIMIT 6;";
		String ret[]=null;
		
		try {
			stmt = c.createStatement();
			
			rs = stmt.executeQuery(rqt);
			
			ret=new String[6];
			for(int j=0;rs.next();j++)
			{
				ret[j]=rs.getString(1);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
}
