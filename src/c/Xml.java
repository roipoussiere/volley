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
	
	public Xml()
	{
		try
		{
			// création d'une fabrique de documents
			DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();

			// création d'un constructeur de documents
			DocumentBuilder constructeur = fabrique.newDocumentBuilder();

			// lecture du contenu d'un fichier XML avec DOM
			File xml = new File("~/test.xml");
			Document document = constructeur.parse(xml);

			Element racine = document.getDocumentElement();
			printNode(racine);
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
	
	public static void printNode(Node node)
	{
		System.out.println(node);
		NodeList nodes = node.getChildNodes();
		for(int i=0 ; i<nodes.getLength() ; i++)
		{
			Node n = nodes.item(i);
			printNode(n);
		}
	}
}
