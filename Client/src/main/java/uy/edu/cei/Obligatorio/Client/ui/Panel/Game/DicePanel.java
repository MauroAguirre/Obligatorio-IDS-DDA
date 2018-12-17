package uy.edu.cei.Obligatorio.Client.ui.Panel.Game;

import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DicePanel extends JPanel {


	private static final long serialVersionUID = 1L;
	private JLabel img;
	private int estado;
	private int numero;
	
	public int getNumero() {
		return this.numero;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public boolean getEstado() {
		if(estado==0)
			return true;
		return false;
	}
	public DicePanel(int estado,int num) {
		this.estado = estado;
		this.numero = num;
		setLayout(null);
		this.setSize(40, 40);
		img = new JLabel();
		img.setLocation(0, 0);
		img.setSize(40,40);
		add(img);
		URL url = this.getClass().getClassLoader().getResource("die"+estado+num+".png");
		ImageIcon image = new ImageIcon(url);
		img.setIcon(image);
		img.setVisible(true);
		
	}
	public void cambiarNumero(int num) {
		this.numero=num;
		URL url = this.getClass().getClassLoader().getResource("die"+0+num+".png");
		ImageIcon image = new ImageIcon(url);
		img.setIcon(image);
		repaint();
	}
	public void cambiarEstado() {
		if(estado==0)
			estado = 1;
		else
			estado = 0;
		URL url = this.getClass().getClassLoader().getResource("die"+this.estado+this.numero+".png");
		ImageIcon image = new ImageIcon(url);
		img.setIcon(image);
		repaint();
	}
	public void reseteo() {
		URL url = this.getClass().getClassLoader().getResource("die"+0+"1"+".png");
		ImageIcon image = new ImageIcon(url);
		img.setIcon(image);
		repaint();
	}
	public void cambiarRandom() {
		if(estado!=2) {
			URL url = this.getClass().getClassLoader().getResource("die"+this.estado+numerosRandom(1,6)+".png");
			ImageIcon image = new ImageIcon(url);
			img.setIcon(image);
			repaint();
		}
	}
	private int numerosRandom(int minimo, int maximo){
	       return ThreadLocalRandom.current().nextInt(minimo,maximo);
	}
}
