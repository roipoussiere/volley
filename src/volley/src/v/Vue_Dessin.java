package v;

import java.awt.*;

import javax.swing.*;

public class Vue_Dessin extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Vue_Terrain vt;
	
	public Vue_Dessin(Vue_Terrain _vt)
	{
		this.vt = _vt;
		
		if (this.vt.getQuadri()) // Quadrillage complet
		{
			System.out.println("Quadrillage complet");
		}
		else // Quadrillage partiel
		{
			System.out.println("Quadrillage partiel");
		}
	}
	
	public void paint(Graphics _g)
	{
		int tc = this.vt.getTCase();
		int h = (int) (this.getSize().getHeight());
		int l = (int) (this.getSize().getWidth());
		System.out.println("hauteur : " + h + " - largeur : " + l);
		
		_g.setColor(Color.black);
		
		if (this.vt.getDemi())
		{
			System.out.println("Quadrillage du demi terrain.");
			for (int i=0 ; i<11 ; i++) // lignes horizontales
			{
				_g.drawLine(i*tc, 0, i*tc, h);			
			}
			for (int i=0 ; i<11 ; i++) // lignes horizontales
			{
				_g.drawLine(0, i*tc, l, i*tc);			
			}
		}
		else
		{
			System.out.println("Quadrillage du terrain complet.");
			for (int i=0 ; i<11 ; i++) // lignes horizontales
			{
				_g.drawLine(i*tc, 0, i*tc, h);			
			}
			for (int i=0 ; i<11 ; i++) // lignes horizontales
			{
				_g.drawLine(0, i*tc, l, i*tc);			
			}
		}
	}
}