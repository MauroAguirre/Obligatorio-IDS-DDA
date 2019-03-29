package uy.edu.cei.Obligatorio.Client.Controller;

import java.awt.Color;
import java.rmi.RemoteException;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JLabel;

import uy.edu.cei.Obligatorio.Client.App.EventQueueClient;
import uy.edu.cei.Obligatorio.Client.ui.MainWindow;
import uy.edu.cei.Obligatorio.Client.ui.Panel.Game.DicePanel;
import uy.edu.cei.Obligatorio.Client.ui.Panel.Game.GamePanel;
import uy.edu.cei.Obligatorio.Common.Notifications.GameNotification;
import uy.edu.cei.Obligatorio.Domain.SalaModel;
import uy.edu.cei.Obligatorio.Domain.UsuarioModel;

public class GameController implements MasterController{
	private static GameController instancia;
	private static GamePanel panel;
	private SalaModel sala;
	private boolean conteo;
	private int turno;
	private int jugada;
	private int juego;
	private int puntaje1;
	private int puntaje2;
	
	public static GameController getInstancia() {
		if(instancia == null) {
			instancia = new GameController();
			panel = new GamePanel();
		}
		return instancia;
	}
	
	public GamePanel darPanel() {
		return panel;
	}
	public SalaModel getSala() {
		return this.sala;
	}
	public void setSala(SalaModel sala) {
		this.sala = sala;
	}
	@Override
	public void respuesta(GameNotification gn) {
		switch(gn.getType()) {
			case DICE_PUSH:
				moverDados(true,gn);
				break;
			case DICE_PULL:
				moverDados(false,gn);
				break;
			case YOUR_TURN:
				if(juego==22) {
					if(puntaje1>puntaje2) {
						panel.getLblAccion().setText("Gano jugador 1");
					}
					else {
						panel.getLblAccion().setText("Gano jugador 2");
					}
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					MainWindow main = MainWindow.getInstancia();
					main.cambiarVentana("main");
				}
				juego++;
				System.out.println(juego);
				//alegar los dados
				panel.getDice1().setBounds(-130, 0, 40, 40);
				panel.getDice2().setBounds(-130, 0, 40, 40);
				panel.getDice3().setBounds(-130, 0, 40, 40);
				panel.getDice4().setBounds(-130, 0, 40, 40);
				panel.getDice5().setBounds(-130, 0, 40, 40);
				panel.getDice1().setEstado(0);
				panel.getDice2().setEstado(0);
				panel.getDice3().setEstado(0);
				panel.getDice4().setEstado(0);
				panel.getDice5().setEstado(0);
				//
				jugada=0;
				panel.getLblPuntaje2().setText(Integer.toString((puntaje2+(int)gn.getDato())));
				panel.setModificable(true);
				panel.getLblAccion().setText("Tira los dados");
				conteo();
				turno = 0;
				break;
			case DICE_SELECTED:
				panel.getLblPuntaje1().setText(Integer.toString((puntaje1+(int)gn.getDato())));
				panel.setModificable(false);
				panel.getLblAccion().setText("Juega el otro jugador");
				break;
			default:
		}
	}
	@Override
	public void intro() {
		// TODO Auto-generated method stub
		
	}
	public void jugar(int i) {
		
	}
	public void moverDados(boolean jugable,GameNotification gn) {
		panel.setModificable(false);
		new Thread(new Runnable() {
			public void run() {
				int x=0;
				while(x!=100) {
					if(gn.getDisponibles()[0]) {
						panel.getDice1().setBounds(-70+x*2, 130, 40, 40);
						panel.getDice1().cambiarRandom();
					}
					if(gn.getDisponibles()[1]) {
						panel.getDice2().setBounds(-20+x*2, 180, 40, 40);
						panel.getDice2().cambiarRandom();
					}
					if(gn.getDisponibles()[2]) {
						panel.getDice3().setBounds(30+x*2, 230, 40, 40);
						panel.getDice3().cambiarRandom();
					}
					if(gn.getDisponibles()[3]) {
						panel.getDice4().setBounds(280, 480-x*2, 40, 40);
						panel.getDice4().cambiarRandom();
					}
					if(gn.getDisponibles()[4]) {
						panel.getDice5().setBounds(330, 530-x*2, 40, 40);
						panel.getDice5().cambiarRandom();
					}
					panel.repaint();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					x++;
				}
				if(gn.getDisponibles()[0]) 
					panel.getDice1().cambiarNumero(gn.getDatos()[0]);
				if(gn.getDisponibles()[1])
					panel.getDice2().cambiarNumero(gn.getDatos()[1]);
				if(gn.getDisponibles()[2])
					panel.getDice3().cambiarNumero(gn.getDatos()[2]);
				if(gn.getDisponibles()[3])
					panel.getDice4().cambiarNumero(gn.getDatos()[3]);
				if(gn.getDisponibles()[4])
					panel.getDice5().cambiarNumero(gn.getDatos()[4]);
				panel.repaint();
				if(jugable) {
					panel.getLblAccion().setText("Tira o fija los dados");
					panel.setModificable(true);
					conteo();
				}
			}	
		}).start();
	}
	public void reseteoOpcion() {
		if(panel.getlblSumaDeUnos().getText()!="")
			panel.getlblSumaDeUnos().setForeground(Color.BLACK);
		if(panel.getLblSumaDeDos().getText()!="")
			panel.getLblSumaDeDos().setForeground(Color.BLACK);
		if(panel.getLblSumaDeTres().getText()!="")
			panel.getLblSumaDeTres().setForeground(Color.BLACK);
		if(panel.getLblSumaDeCuatros().getText()!="")
			panel.getLblSumaDeCuatros().setForeground(Color.BLACK);
		if(panel.getLblSumaDeCincos().getText()!="")
			panel.getLblSumaDeCincos().setForeground(Color.BLACK);
		if(panel.getLblSumaDeSeis().getText()!="")
			panel.getLblSumaDeSeis().setForeground(Color.BLACK);
		if(panel.getLblEscalera().getText()!="")
			panel.getLblEscalera().setForeground(Color.BLACK);
		if(panel.getLblFull().getText()!="")
			panel.getLblFull().setForeground(Color.BLACK);
		if(panel.getLblPoker().getText()!="")
			panel.getLblPoker().setForeground(Color.BLACK);
		if(panel.getLblGenerala().getText()!="")
			panel.getLblGenerala().setForeground(Color.BLACK);
		if(panel.getLblGeneralaDoble().getText()!="")
			panel.getLblGeneralaDoble().setForeground(Color.BLACK);
			
	}
	public void cambiarOpcion(int num,boolean deleteo) {
		reseteoOpcion();
		switch(num) {
			case 1:
				if(!deleteo) {
					panel.getlblSumaDeUnos().setBackground(Color.blue);
					panel.getlblSumaDeUnos().setForeground(Color.BLUE);
				}
				else
					panel.getlblSumaDeUnos().setText("");
				break;
			case 2:
				if(!deleteo) {
					panel.getLblSumaDeDos().setBackground(Color.blue);
					panel.getLblSumaDeDos().setForeground(Color.BLUE);
				}
				else
					panel.getLblSumaDeDos().setText("");
				break;
			case 3:
				if(!deleteo) {
					panel.getLblSumaDeTres().setBackground(Color.blue);
					panel.getLblSumaDeTres().setForeground(Color.BLUE);
				}
				else
					panel.getLblSumaDeTres().setText("");
				break;
			case 4:
				if(!deleteo) {
					panel.getLblSumaDeCuatros().setBackground(Color.blue);
					panel.getLblSumaDeCuatros().setForeground(Color.BLUE);
				}
				else
					panel.getLblSumaDeCuatros().setText("");
				break;
			case 5:
				if(!deleteo) {
					panel.getLblSumaDeCincos().setBackground(Color.blue);
					panel.getLblSumaDeCincos().setForeground(Color.BLUE);
				}
				else
					panel.getLblSumaDeCincos().setText("");
				break;
			case 6:
				if(!deleteo) {
					panel.getLblSumaDeSeis().setBackground(Color.blue);
					panel.getLblSumaDeSeis().setForeground(Color.BLUE);
				}
				else
					panel.getLblSumaDeSeis().setText("");
				break;
			case 7:
				if(!deleteo) {
					panel.getLblEscalera().setBackground(Color.blue);
					panel.getLblEscalera().setForeground(Color.BLUE);
				}
				else
					panel.getLblEscalera().setText("");
				break;
			case 8:
				if(!deleteo) {
					panel.getLblFull().setBackground(Color.blue);
					panel.getLblFull().setForeground(Color.BLUE);
				}
				else
					panel.getLblFull().setText("");
				break;
			case 9:
				if(!deleteo) {
					panel.getLblPoker().setBackground(Color.blue);
					panel.getLblPoker().setForeground(Color.BLUE);
				}
				else
					panel.getLblPoker().setText("");
				break;
			case 10:
				if(!deleteo) {
					panel.getLblGenerala().setBackground(Color.blue);
					panel.getLblGenerala().setForeground(Color.BLUE);
				}
				else
					panel.getLblGenerala().setText("");
				break;
			case 11:
				if(!deleteo) {
					panel.getLblGeneralaDoble().setBackground(Color.blue);
					panel.getLblGeneralaDoble().setForeground(Color.BLUE);
				}
				else
					panel.getLblGeneralaDoble().setText("");
				break;
		}
		jugada=num;
		panel.repaint();
	}
	public boolean borrar(int num) {
		switch(num) {
			case 1:
				if(!panel.getlblSumaDeUnos().getText().equals("")) {
					panel.getlblSumaDeUnos().setText("");
					return true;
				}
				break;
			case 2:
				if(!panel.getLblSumaDeDos().getText().equals("")) {
					panel.getLblSumaDeDos().setText("");
					return true;
				}
			case 3:
				if(!panel.getLblSumaDeTres().getText().equals("")) {
					panel.getLblSumaDeTres().setText("");
					return true;
				}
				break;
			case 4:
				if(!panel.getLblSumaDeCuatros().getText().equals("")) {
					panel.getLblSumaDeCuatros().setText("");
					return true;
				}
				break;
			case 5:
				if(!panel.getLblSumaDeCincos().getText().equals("")) {
					panel.getLblSumaDeCincos().setText("");
					return true;
				}
				break;
			case 6:
				if(!panel.getLblSumaDeSeis().getText().equals("")) {
					panel.getLblSumaDeSeis().setText("");
					return true;
				}
				break;
			case 7:
				if(!panel.getLblEscalera().getText().equals("")) {
					panel.getLblEscalera().setText("");
					return true;
				}
				break;
			case 8:
				if(!panel.getLblFull().getText().equals("")) {
					panel.getLblFull().setText("");
					return true;
				}
				break;
			case 9:
				if(!panel.getLblPoker().getText().equals("")) {
					panel.getLblPoker().setText("");
					return true;
				}
				break;
			case 10:
				if(!panel.getLblGenerala().getText().equals("")) {
					panel.getLblGenerala().setText("");
					return true;
				}
				break;
			case 11:
				if(!panel.getLblGeneralaDoble().getText().equals("")) {
					panel.getLblGeneralaDoble().setText("");
					return true;
				}
				break;
		}
		return false;
	}
	public void primero() {
		juego=0;
		jugada=0;
		//alegar los dados
		panel.getDice1().setBounds(-130, 0, 40, 40);
		panel.getDice2().setBounds(-130, 0, 40, 40);
		panel.getDice3().setBounds(-130, 0, 40, 40);
		panel.getDice4().setBounds(-130, 0, 40, 40);
		panel.getDice5().setBounds(-130, 0, 40, 40);
		panel.getDice1().setEstado(0);
		panel.getDice2().setEstado(0);
		panel.getDice3().setEstado(0);
		panel.getDice4().setEstado(0);
		panel.getDice5().setEstado(0);
		//
		this.turno=0;
		conteo =true;
		panel.getLblPuntaje2().setText("0");
		panel.getLblPuntaje1().setText("0");
		Long id = 0l;
		try {
			EventQueueClient eqc = EventQueueClient.Instancia();
			id = eqc.getId();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(sala.getPlayer1().getId()==id) {
			panel.getAvatar1().cambiar(sala.getPlayer1().getAvatar());
			panel.getAvatar2().cambiar(sala.getPlayer2().getAvatar());
		}
		else {
			panel.getAvatar2().cambiar(sala.getPlayer1().getAvatar());
			panel.getAvatar1().cambiar(sala.getPlayer2().getAvatar());
		}
		panel.getLblAccion().setText("Tira los dados");
		panel.setModificable(true);
		conteo();
	}
	public void conteo() {
		new Thread(new Runnable() {
			public void run() {
				conteo=true;
				int temporizador=30;
				panel.getLblTiempo().setText("Tiempo:"+temporizador);
				while(temporizador!=0&&conteo) {
					try {
						Thread.sleep(1000);
						temporizador--;
						panel.getLblTiempo().setText("Tiempo:"+temporizador);
						panel.repaint();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(conteo) {
					elegirJugada();
				}
				panel.getLblTiempo().setText("Tiempo: terminado");
			}	
		}).start();
	}
	public void segundo() {
		juego=0;
		jugada=0;
		//alegar los dados
		panel.getDice1().setBounds(-130, 0, 40, 40);
		panel.getDice2().setBounds(-130, 0, 40, 40);
		panel.getDice3().setBounds(-130, 0, 40, 40);
		panel.getDice4().setBounds(-130, 0, 40, 40);
		panel.getDice5().setBounds(-130, 0, 40, 40);
		panel.getDice1().setEstado(0);
		panel.getDice2().setEstado(0);
		panel.getDice3().setEstado(0);
		panel.getDice4().setEstado(0);
		panel.getDice5().setEstado(0);
		//
		this.turno=0;
		panel.getLblPuntaje2().setText("0");
		panel.getLblPuntaje1().setText("0");
		Long id = 0l;
		try {
			EventQueueClient eqc = EventQueueClient.Instancia();
			id = eqc.getId();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(sala.getPlayer1().getId()==id) {
			panel.getAvatar2().cambiar(sala.getPlayer1().getAvatar());
			panel.getAvatar1().cambiar(sala.getPlayer2().getAvatar());
		}
		else {
			panel.getAvatar1().cambiar(sala.getPlayer1().getAvatar());
			panel.getAvatar2().cambiar(sala.getPlayer2().getAvatar());
		}
		panel.getLblAccion().setText("Juega el otro jugador");
		panel.setModificable(false);
	}
	public void tirarDados() {
		this.conteo=false;
		int[] dados = {panel.getDice1().getNumero(),panel.getDice2().getNumero(),panel.getDice3().getNumero(),panel.getDice4().getNumero(),panel.getDice5().getNumero()};
		boolean[] disponibles = {panel.getDice1().getEstado(),panel.getDice2().getEstado(),panel.getDice3().getEstado(),panel.getDice4().getEstado(),panel.getDice5().getEstado()};
		try {
			if(turno!=3) {
				EventQueueClient eqc = EventQueueClient.Instancia();
				Long idOtro;
				if(sala.getPlayer1().getId()==eqc.getId())
					idOtro = sala.getPlayer2().getId();
				else
					idOtro= sala.getPlayer1().getId();
				eqc.getServer().getGameControllerImpl().tirarDados(dados, disponibles, eqc.getId(),idOtro,turno);
				turno++;
			}
			else {
				elegirJugada();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void elegirJugada() {
		this.conteo=false;
		int[] dados = {panel.getDice1().getNumero(),panel.getDice2().getNumero(),panel.getDice3().getNumero(),panel.getDice4().getNumero(),panel.getDice5().getNumero()};
		boolean[] disponibles = {panel.getDice1().getEstado(),panel.getDice2().getEstado(),panel.getDice3().getEstado(),panel.getDice4().getEstado(),panel.getDice5().getEstado()};
		try {
			EventQueueClient eqc = EventQueueClient.Instancia();
			Long idOtro;
			if(sala.getPlayer1().getId()==eqc.getId())
				idOtro = sala.getPlayer2().getId();
			else
				idOtro= sala.getPlayer1().getId();
			if(jugada==0) {
				boolean borrado=false;
				while(!borrado) {
					borrado=borrar(numerosRandom(1,11));
				}
				reseteoOpcion();
			}
			else
				cambiarOpcion(jugada,true);
			eqc.getServer().getGameControllerImpl().lockearJugada(dados,eqc.getId(),idOtro,jugada);
			turno=0;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	private int numerosRandom(int minimo, int maximo){
	       return ThreadLocalRandom.current().nextInt(minimo,maximo);
	}
}
