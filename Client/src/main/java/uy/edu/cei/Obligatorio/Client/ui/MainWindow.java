package uy.edu.cei.Obligatorio.Client.ui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import uy.edu.cei.Obligatorio.Client.Controller.GameController;
import uy.edu.cei.Obligatorio.Client.Controller.LoginController;
import uy.edu.cei.Obligatorio.Client.Controller.MainController;
import uy.edu.cei.Obligatorio.Client.Controller.RealPanelController;
import uy.edu.cei.Obligatorio.Client.ui.Panel.GeneralaPanel;
import uy.edu.cei.Obligatorio.Client.ui.Panel.LoginPanel;
import uy.edu.cei.Obligatorio.Client.ui.Panel.MainPanel;
import uy.edu.cei.Obligatorio.Client.ui.Panel.RegistryPanel;
import uy.edu.cei.Obligatorio.Client.ui.Panel.WaitingPanel;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;

public class MainWindow{

	private JFrame frame;
	private static MainWindow instancia;
	
	public static MainWindow getInstancia() {
		if(instancia == null)
			instancia = new MainWindow();
		return instancia;
	}
	
	public JFrame getFrame() {
		return frame;
	}

	private MainWindow(){
		initialize();
	}
	
	public void cambiarVentana(String ventana) {
		switch(ventana) {
			case "main":
				MainController mainController = MainController.getInstancia();
				frame.setContentPane(mainController.darPanel());
				frame.setVisible(true);
				mainController.intro();
				break;
			case "login":
				LoginController loginController = LoginController.getInstancia();
				frame.setContentPane(loginController.darPanel());
				frame.setVisible(true);
				loginController.intro();
				break;
			case "registry":
				//falta el controller
				RegistryPanel panel3 = new RegistryPanel();
				frame.setContentPane(panel3);
				frame.setVisible(true);
				break;
			case "kill":
				frame.dispose();
				break;
			case "waiting":
				frame.setContentPane(new WaitingPanel());
				frame.setVisible(true);
				break;
			case "real":
				RealPanelController realController = RealPanelController.getInstancia();
				frame.setContentPane(realController.darPanel());
				frame.setVisible(true);
				break;
			case "game":
				GameController gameController = GameController.getInstancia();
				frame.setContentPane(gameController.darPanel());
				frame.setVisible(true);
				break;
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 645,510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		//
		try {
	         // Open an audio input stream.
			 URL url = this.getClass().getClassLoader().getResource("probando.wav");
			 AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	         // Get a sound clip resource.
	         Clip clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioIn);
	         //clip.loop(0);
	         
	         
	         //lo siguientes es para que se loope
	         //clip.loop(Clip.LOOP_CONTINUOUSLY);
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	}
	public static void main(String[] args) {
	      new MainWindow();
	}
}
