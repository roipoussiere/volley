
package v_vues;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import v_ecouteurs.AL_Joueurs;


/**
 * Vue contenant les élements de l'onglet Joueur.
 * @author Chalut xavier
 */
public class Vue_Joueurs extends JDialog
{
	private static final long serialVersionUID = 1L;
	private Vue_Fenetre vf;
	private AL_Joueurs alJ;
	
	// Composants de la fenêtre
	private JTabbedPane jtpj;	//onglet des equipes 
	private JLabel jbT1,jbT2,jbT3,jbT4; // label des titres de liste
	private JLabel jbJ1e1,jbJ2e1,jbJ3e1,jbJ4e1,jbJ5e1,jbJ6e1; // label de l'equpe 1
	private JLabel jbJ1e2,jbJ2e2,jbJ3e2,jbJ4e2,jbJ5e2,jbJ6e2; // label de l'equpe 2
	private JLabel jbTse1,jbTse2; // Selection total des équipes
	private JTextField jtfJ1e1,jtfJ2e1,jtfJ3e1,jtfJ4e1,jtfJ5e1,jtfJ6e1; // nom des joueurs de l'équipe 1
	private JTextField jtfJ1e2,jtfJ2e2,jtfJ3e2,jtfJ4e2,jtfJ5e2,jtfJ6e2; // nom des joueurs de l'équipe 2
	private JCheckBox jcbJ1e1,jcbJ2e1,jcbJ3e1,jcbJ4e1,jcbJ5e1,jcbJ6e1; // checkbox pour equipe 1
	private JCheckBox jcbJ1e2,jcbJ2e2,jcbJ3e2,jcbJ4e2,jcbJ5e2,jcbJ6e2; // checkbox pour equipe 2
	private JCheckBox jcbTse1,jcbTse2; // checkbox de selection total des équipes
	private JRadioButton jrbJ1e1,jrbJ2e1,jrbJ3e1,jrbJ4e1,jrbJ5e1,jrbJ6e1; // bouton radio pour meneur equipe 1
	private JRadioButton jrbJ1e2,jrbJ2e2,jrbJ3e2,jrbJ4e2,jrbJ5e2,jrbJ6e2; // bouton radio pour meneur equipe 2
	
	private ButtonGroup bgMeneurEqu1,bgMeneurEqu2;
	
	/**
	 * Création du JFrame et de tous ses composants.
	 * @param _vf La vue de la fenêtre principale.
	 */
		public Vue_Joueurs (Vue_Fenetre _vf)
		{
		super (_vf, "Joueurs", true);
		this.vf = _vf;
		this.setSize(400, 300);
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		
		
		this.jtpj = new JTabbedPane();
		 
		JPanel jpT,jp1,jp2,jp3,jp4,jp5,jp6;
		JPanel panel1;
		JPanel panBas;
	
		// Gestion des composants de l'onglet "Equipe 1" 
		
		JPanel panelE1;
		panelE1 = new JPanel();
		panelE1.setLayout(new BorderLayout());
		this.bgMeneurEqu1 = new ButtonGroup();
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(7,1));
			jpT = new JPanel();
			jpT.setLayout(new FlowLayout(FlowLayout.CENTER));
				this.jbT1 = new JLabel(""); 
				jpT.add(this.jbT1);
				this.jbT2 = new JLabel("Noms"); 
				jbT2.setBorder(BorderFactory.createEmptyBorder(0, 145, 0, 5));
				jpT.add(this.jbT2);
				this.jbT3 = new JLabel("Afficher"); 
				jbT3.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 10));
				jpT.add(this.jbT3);
				this.jbT4 = new JLabel("Meneur");
				jbT4.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 20));
				jpT.add(this.jbT4);
				panel1.add(jpT);
			jp1 = new JPanel();
			jp1.setLayout(new FlowLayout(FlowLayout.CENTER,25,0));
				this.jbJ1e1 = new JLabel("Joueur 1"); 
				jp1.add(this.jbJ1e1);
				this.jtfJ1e1 = new JTextField(10); 
				jp1.add(this.jtfJ1e1);
				this.jcbJ1e1 = new JCheckBox(); 
				jp1.add(this.jcbJ1e1);
				this.jrbJ1e1 = new JRadioButton();
				jrbJ1e1.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
				this.bgMeneurEqu1.add(this.jrbJ1e1);
				jp1.add(this.jrbJ1e1);
			panel1.add(jp1);
			jp2 = new JPanel();
			jp2.setLayout(new FlowLayout(FlowLayout.CENTER,25,0));
				this.jbJ2e1 = new JLabel("Joueur 2"); 
				jp2.add(this.jbJ2e1);
				this.jtfJ2e1 = new JTextField(10); 
				jp2.add(this.jtfJ2e1);
				this.jcbJ2e1 = new JCheckBox(); 
				jp2.add(this.jcbJ2e1);
				this.jrbJ2e1 = new JRadioButton();
				jrbJ2e1.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
				this.bgMeneurEqu1.add(this.jrbJ2e1);
				jp2.add(this.jrbJ2e1);
			panel1.add(jp2);
			jp3 = new JPanel();
			jp3.setLayout(new FlowLayout(FlowLayout.CENTER,25,0));
				this.jbJ3e1 = new JLabel("Joueur 3"); 
				jp3.add(this.jbJ3e1);
				this.jtfJ3e1 = new JTextField(10); 
				jp3.add(this.jtfJ3e1);
				this.jcbJ3e1 = new JCheckBox(); 
				jp3.add(this.jcbJ3e1);
				this.jrbJ3e1 = new JRadioButton();
				jrbJ3e1.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
				this.bgMeneurEqu1.add(this.jrbJ3e1);
				jp3.add(this.jrbJ3e1);
			panel1.add(jp3);
			jp4 = new JPanel();
			jp4.setLayout(new FlowLayout(FlowLayout.CENTER,25,0));
				this.jbJ4e1 = new JLabel("Joueur 4"); 
				jp4.add(this.jbJ4e1);
				this.jtfJ4e1 = new JTextField(10); 
				jp4.add(this.jtfJ4e1);
				this.jcbJ4e1 = new JCheckBox(); 
				jp4.add(this.jcbJ4e1);
				this.jrbJ4e1 = new JRadioButton();
				jrbJ4e1.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
				this.bgMeneurEqu1.add(this.jrbJ4e1);
				jp4.add(this.jrbJ4e1);
			panel1.add(jp4);		
			jp5 = new JPanel();
			jp5.setLayout(new FlowLayout(FlowLayout.CENTER,25,0));
				this.jbJ5e1 = new JLabel("Joueur 5"); 
				jp5.add(this.jbJ5e1);
				this.jtfJ5e1 = new JTextField(10); 
				jp5.add(this.jtfJ5e1);
				this.jcbJ5e1 = new JCheckBox(); 
				jp5.add(this.jcbJ5e1);
				this.jrbJ5e1 = new JRadioButton();
				jrbJ5e1.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
				this.bgMeneurEqu1.add(this.jrbJ5e1);
				jp5.add(this.jrbJ5e1);
			panel1.add(jp5);		
			jp6 = new JPanel();
			jp6.setLayout(new FlowLayout(FlowLayout.CENTER,25,0));
				this.jbJ6e1 = new JLabel("Joueur 6"); 
				jp6.add(this.jbJ6e1);
				this.jtfJ6e1 = new JTextField(10); 
				jp6.add(this.jtfJ6e1);
				this.jcbJ6e1 = new JCheckBox(); 
				jp6.add(this.jcbJ6e1);
				this.jrbJ6e1 = new JRadioButton();
				jrbJ6e1.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
				this.bgMeneurEqu1.add(this.jrbJ6e1);
				jp6.add(this.jrbJ6e1);
			panel1.add(jp6);
			panBas = new JPanel();
				this.jbTse1 = new JLabel("Sélectionner tous les joueurs"); 
				panBas.add(this.jbTse1);
				this.jcbTse1 = new JCheckBox(); 
				panBas.add(this.jcbTse1);
	
			panelE1.add(panel1,BorderLayout.NORTH);
			panelE1.add(panBas,BorderLayout.SOUTH);
		this.jtpj.addTab("Equipe 1", panelE1);

		
		
		// Gestion des composants de l'onglet "Equipe 2" 
		
		JPanel panelE2;
		panelE2 = new JPanel();
		panelE2.setLayout(new BorderLayout());
		JPanel panel2;
		this.bgMeneurEqu2 = new ButtonGroup();
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(7,1));
			jpT = new JPanel();
			jpT.setLayout(new FlowLayout(FlowLayout.CENTER));
				this.jbT1 = new JLabel(""); 
				jpT.add(this.jbT1);
				this.jbT2 = new JLabel("Noms"); 
				jbT2.setBorder(BorderFactory.createEmptyBorder(0, 145, 0, 5));
				jpT.add(this.jbT2);
				this.jbT3 = new JLabel("Afficher"); 
				jbT3.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 10));
				jpT.add(this.jbT3);
				this.jbT4 = new JLabel("Meneur");
				jbT4.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 20));
				jpT.add(this.jbT4);
				panel2.add(jpT);
			jp1 = new JPanel();
			jp1.setLayout(new FlowLayout(FlowLayout.CENTER,25,0));
				this.jbJ1e2 = new JLabel("Joueur 1"); 
				jp1.add(this.jbJ1e2);
				this.jtfJ1e2 = new JTextField(10); 
				jp1.add(this.jtfJ1e2);
				this.jcbJ1e2 = new JCheckBox(); 
				jp1.add(this.jcbJ1e2);
				this.jrbJ1e2 = new JRadioButton();
				jrbJ1e2.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
				this.bgMeneurEqu2.add(this.jrbJ1e2);
				jp1.add(this.jrbJ1e2);
			panel2.add(jp1);	
			jp2 = new JPanel();
			jp2.setLayout(new FlowLayout(FlowLayout.CENTER,25,0));
				this.jbJ2e2 = new JLabel("Joueur 2"); 
				jp2.add(this.jbJ2e2);
				this.jtfJ2e2 = new JTextField(10); 
				jp2.add(this.jtfJ2e2);
				this.jcbJ2e2 = new JCheckBox(); 
				jp2.add(this.jcbJ2e2);
				this.jrbJ2e2 = new JRadioButton();
				jrbJ2e2.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
				this.bgMeneurEqu2.add(this.jrbJ2e2);
				jp2.add(this.jrbJ2e2);
			panel2.add(jp2);
			jp3 = new JPanel();
			jp3.setLayout(new FlowLayout(FlowLayout.CENTER,25,0));
				this.jbJ3e2 = new JLabel("Joueur 3"); 
				jp3.add(this.jbJ3e2);
				this.jtfJ3e2 = new JTextField(10); 
				jp3.add(this.jtfJ3e2);
				this.jcbJ3e2 = new JCheckBox(); 
				jp3.add(this.jcbJ3e2);
				this.jrbJ3e2 = new JRadioButton();
				jrbJ3e2.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
				this.bgMeneurEqu2.add(this.jrbJ3e2);
				jp3.add(this.jrbJ3e2);
			panel2.add(jp3);
			jp4 = new JPanel();
			jp4.setLayout(new FlowLayout(FlowLayout.CENTER,25,0));
				this.jbJ4e2 = new JLabel("Joueur 4"); 
				jp4.add(this.jbJ4e2);
				this.jtfJ4e2 = new JTextField(10); 
				jp4.add(this.jtfJ4e2);
				this.jcbJ4e2 = new JCheckBox(); 
				jp4.add(this.jcbJ4e2);
				this.jrbJ4e2 = new JRadioButton();
				jrbJ4e2.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
				this.bgMeneurEqu2.add(this.jrbJ4e2);
				jp4.add(this.jrbJ4e2);
			panel2.add(jp4);		
			jp5 = new JPanel();
			jp5.setLayout(new FlowLayout(FlowLayout.CENTER,25,0));
				this.jbJ5e2 = new JLabel("Joueur 5"); 
				jp5.add(this.jbJ5e2);
				this.jtfJ5e2 = new JTextField(10); 
				jp5.add(this.jtfJ5e2);
				this.jcbJ5e2 = new JCheckBox(); 
				jp5.add(this.jcbJ5e2);
				this.jrbJ5e2 = new JRadioButton();
				jrbJ5e2.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
				this.bgMeneurEqu2.add(this.jrbJ5e2);
				jp5.add(this.jrbJ5e2);
			panel2.add(jp5);		
			jp6 = new JPanel();
			jp6.setLayout(new FlowLayout(FlowLayout.CENTER,25,0));
				this.jbJ6e2 = new JLabel("Joueur 6"); 
				jp6.add(this.jbJ6e2);
				this.jtfJ6e2 = new JTextField(10); 
				jp6.add(this.jtfJ6e2);
				this.jcbJ6e2 = new JCheckBox(); 
				jp6.add(this.jcbJ6e2);
				this.jrbJ6e2 = new JRadioButton();
				jrbJ6e2.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
				this.bgMeneurEqu2.add(this.jrbJ6e2);
				jp6.add(this.jrbJ6e2);
			panel2.add(jp6);
			panBas = new JPanel();
				this.jbTse2 = new JLabel("Sélectionner tous les joueurs"); 
				panBas.add(this.jbTse2);
				this.jcbTse2 = new JCheckBox(); 
				panBas.add(this.jcbTse2);
			
			
			panelE2.add(panel2,BorderLayout.NORTH);
			panelE2.add(panBas,BorderLayout.SOUTH);
		this.jtpj.addTab("Equipe 2", panelE2);
		
		this.add(this.jtpj); // Ajout des onglets dans la fenetre
		
		
		
		// Abonnnement au listener
		alJ = new AL_Joueurs(this); //Ecouteur de fenetre
		this.jcbTse1.addActionListener(alJ);
		this.jcbTse2.addActionListener(alJ);	
		this.setVisible(true);
	}
	
	public JTextField getJtfJ1e1() 
	{
		return jtfJ1e1;
	}

	public JTextField getJtfJ2e1() 
	{
		return jtfJ2e1;
	}

	public JTextField getJtfJ3e1() 
	{
		return jtfJ3e1;
	}

	public JTextField getJtfJ4e1() 
	{
		return jtfJ4e1;
	}

	public JTextField getJtfJ5e1()
	{
		return jtfJ5e1;
	}

	public JTextField getJtfJ6e1() 
	{
		return jtfJ6e1;
	}

	public JTextField getJtfJ1e2() 
	{
		return jtfJ1e2;
	}

	public JTextField getJtfJ2e2() 
	{
		return jtfJ2e2;
	}

	public JTextField getJtfJ3e2() 
	{
		return jtfJ3e2;
	}

	public JTextField getJtfJ4e2() 
	{
		return jtfJ4e2;
	}

	public JTextField getJtfJ5e2()
	{
		return jtfJ5e2;
	}

	public JTextField getJtfJ6e2() 
	{
		return jtfJ6e2;
	}

	public JCheckBox getJcbJ1e1()
	{
		return jcbJ1e1;
	}

	public JCheckBox getJcbJ2e1() 
	{
		return jcbJ2e1;
	}

	public JCheckBox getJcbJ3e1() 
	{
		return jcbJ3e1;
	}

	public JCheckBox getJcbJ4e1() 
	{
		return jcbJ4e1;
	}

	public JCheckBox getJcbJ5e1() 
	{
		return jcbJ5e1;
	}

	public JCheckBox getJcbJ6e1() 
	{
		return jcbJ6e1;
	}

	public JCheckBox getJcbJ1e2() 
	{
		return jcbJ1e2;
	}

	public JCheckBox getJcbJ2e2() 
	{
		return jcbJ2e2;
	}

	public JCheckBox getJcbJ3e2() 
	{
		return jcbJ3e2;
	}

	public JCheckBox getJcbJ4e2()
	{
		return jcbJ4e2;
	}

	public JCheckBox getJcbJ5e2() 
	{
		return jcbJ5e2;
	}

	public JCheckBox getJcbJ6e2() 
	{
		return jcbJ6e2;
	}

	public JRadioButton getJrbJ1e1()
	{
		return jrbJ1e1;
	}

	public JRadioButton getJrbJ2e1()
	{
		return jrbJ2e1;
	}

	public JRadioButton getJrbJ3e1() 
	{
		return jrbJ3e1;
	}

	public JRadioButton getJrbJ4e1()
	{
		return jrbJ4e1;
	}

	public JRadioButton getJrbJ5e1() 
	{
		return jrbJ5e1;
	}

	public JRadioButton getJrbJ6e1()
	{
		return jrbJ6e1;
	}

	public JRadioButton getJrbJ1e2() 
	{
		return jrbJ1e2;
	}

	public JRadioButton getJrbJ2e2()
	{
		return jrbJ2e2;
	}

	public JRadioButton getJrbJ3e2()
	{
		return jrbJ3e2;
	}

	public JRadioButton getJrbJ4e2() 
	{
		return jrbJ4e2;
	}

	public JRadioButton getJrbJ5e2() {
		return jrbJ5e2;
	}

	public JRadioButton getJrbJ6e2() {
		return jrbJ6e2;
	}



	/**
	 * Getter checkbox de selection de tous les joueurs de l'equipe 1.
	 * @return Checkbox.
	 */
	public JCheckBox getJcbTse1()
	{
		return this.jcbTse1;
	}
	
	/**
	 * Getter checkbox de selection de tous les joueurs de l'equipe 2.
	 * @return Checkbox.
	 */
	public JCheckBox getJcbTse2()
	{
		return this.jcbTse2;
	}
	
	/**
	* Getter de la vue Fenêtre.
	* @return La vue Fenêtre.
	*/
	public Vue_Fenetre getC()
	{
	return this.vf;
	}
	
	public void majVueJoueurs ()
	{
		
		/*
		 * 	Recuperation des noms des joueurs dans le controleur 
		 * 		/!\ NE FONCTIONNE PAS ENCORE /!\ 		
		 * 
			this.jtfJ1e1.setText (this.c.getJoueur1E1());
			this.jtfJ1e1.setText (this.c.getJoueur2E1());
			this.jtfJ1e1.setText (this.c.getJoueur3E1());
			this.jtfJ1e1.setText (this.c.getJoueur4E1());
			this.jtfJ1e1.setText (this.c.getJoueur5E1());
			this.jtfJ1e1.setText (this.c.getJoueur6E1());
			
			this.jtfJ1e1.setText (this.c.getJoueur1E2());
			this.jtfJ1e1.setText (this.c.getJoueur2E2());
			this.jtfJ1e1.setText (this.c.getJoueur3E2());
			this.jtfJ1e1.setText (this.c.getJoueur4E2());
			this.jtfJ1e1.setText (this.c.getJoueur5E2());
			this.jtfJ1e1.setText (this.c.getJoueur6E2());
		*/
	}
}