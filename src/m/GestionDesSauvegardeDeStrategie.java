package m;
import java.io.*;

public class GestionDesSauvegardeDeStrategie {
	
	
	public GestionDesSauvegardeDeStrategie(){}
	
		
		public void SerializerStrategie(String _path, Strategie _strat)
		{
	 
			Strategie strat =_strat;
				try {
					FileOutputStream fichier = new FileOutputStream(_path+".ste");
					ObjectOutputStream oos = new ObjectOutputStream(fichier);
					oos.writeObject(strat);
					oos.flush();
					oos.close();
				}
				catch (java.io.IOException e) 
				{
					e.printStackTrace();
				}
			
		}
		
		public Strategie DeSerializerStrategie(String _path)
		{
			
			Strategie strat = null;
				try {
					FileInputStream fichier = new FileInputStream(_path);
					ObjectInputStream ois = new ObjectInputStream(fichier);
					strat = (Strategie) ois.readObject();
	
					}
					catch (java.io.IOException e)
					{
						e.printStackTrace();
					}
					catch (ClassNotFoundException e)
					{
						e.printStackTrace();
					}
				return strat;
			
		}
	}


