package c;

import java.io.*; 
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 *
 * @author Nathanaël Jourdane
 */
public class Xml
{
	Document document;
	public Xml()
	{
		this.document = null;

		try
		{
			// création d'un constructeur de documents
			DocumentBuilder constructeur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			File xml = new File("test.xml"); // lecture du contenu du fichier XML avec DOM
			this.document = constructeur.parse(xml);
		}
		catch(ParserConfigurationException pce)
		{
			System.out.println("Erreur de configuration du parseur DOM");
			System.out.println("lors de l'appel à fabrique.newDocumentBuilder();");
		}
		catch(SAXException se)
		{
			System.out.println("Erreur lors du parsing du document");
			System.out.println("lors de l'appel à construteur.parse(xml)");
		}
		catch(IOException ioe)
		{
			System.out.println("Erreur d'entrée/sortie");
			System.out.println("lors de l'appel à construteur.parse(xml)");
		}
	}
	
	public String getParam(String _param)
	{
		//this.document.getElementsByTagName(_param);
		return "";
	}
	
	private void affTout()
	{
		// Extraction de la liste des éléments présents dans la racine de l'arbre xml.
		NodeList nodes = this.document.getDocumentElement().getChildNodes();
		for(int i=0 ; i<nodes.getLength()/2 ; i++)
		{
			System.out.println(i + " : " + nodes.item(i*2+1).getTextContent());
		}
	}
}
