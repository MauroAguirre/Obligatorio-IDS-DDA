package uy.edu.cei.Obligatorio.Client.ui.Panel.Game;

import javax.swing.JPanel;

import uy.edu.cei.Obligatorio.Client.Controller.GameController;
import uy.edu.cei.Obligatorio.Client.ui.Panel.GeneralaPanel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends GeneralaPanel {

	private static final long serialVersionUID = 1L;
	private boolean modificable;
	private JLabel lblJugadas;
	private JLabel lblGeneralaDoble;
	private JLabel lblGenerala;
	private JLabel lblPker;
	private JLabel lblFull;
	private JLabel lblEscalera;
	private JLabel lblSumaDeSeis;
	private JLabel lblSumaDeCincos;
	private JLabel lblSumaDeCuatros;
	private JLabel lblSumaDeTres;
	private JLabel lblSumaDeDos;
	private JLabel lblSumaDeUnos;
	private JLabel lblPuntaje1;
	private JLabel lblPuntaje2;
	private JLabel lblTiempo;
	private JLabel lblAccion;
	private AvatarPanel avatar1;
	private AvatarPanel avatar2;
	private JButton btnTirarDados;
	private DicePanel dice1;
	private DicePanel dice2;
	private DicePanel dice3;
	private DicePanel dice4;
	private DicePanel dice5;
	
	public AvatarPanel getAvatar1() {
		return this.avatar1;
	}
	public AvatarPanel getAvatar2() {
		return this.avatar2;
	}
	public JLabel getLblTiempo() {
		return this.lblTiempo;
	}
	public JLabel getLblAccion() {
		return this.lblAccion;
	}
	public void setModificable(boolean mod) {
		this.modificable = mod;
	}
	public JLabel getLblPuntaje1() {
		return this.lblPuntaje1;
	}
	public JLabel getLblPuntaje2() {
		return this.lblPuntaje2;
	}
	public JLabel getlblSumaDeUnos() {
		return this.lblSumaDeUnos;
	}
	public JLabel getLblSumaDeDos() {
		return this.lblSumaDeDos;
	}
	public JLabel getLblSumaDeTres() {
		return this.lblSumaDeTres;
	}
	public JLabel getLblSumaDeCuatros() {
		return this.lblSumaDeCuatros;
	}
	public JLabel getLblSumaDeCincos() {
		return this.lblSumaDeCincos;
	}
	public JLabel getLblSumaDeSeis() {
		return this.lblSumaDeSeis;
	}
	public JLabel getLblEscalera() {
		return this.lblEscalera;
	}
	public JLabel getLblFull() {
		return this.lblFull;
	}
	public JLabel getLblPoker() {
		return this.lblPker;
	}
	public JLabel getLblGenerala() {
		return this.lblGenerala;
	}
	public JLabel getLblGeneralaDoble() {
		return this.lblGeneralaDoble;
	}
	public DicePanel getDice1() {
		return this.dice1;
	}
	public DicePanel getDice2() {
		return this.dice2;
	}
	public DicePanel getDice3() {
		return this.dice3;
	}
	public DicePanel getDice4() {
		return this.dice4;
	}
	public DicePanel getDice5() {
		return this.dice5;
	}
	
	public GamePanel() {
		this.modificable = false;
		setLayout(null);
		this.setSize(640, 480);
		URL url = this.getClass().getClassLoader().getResource("fondo2.jpg");
		ImageIcon image = new ImageIcon(url);
		
		lblJugadas = new JLabel("Jugadas");
		lblJugadas.setForeground(Color.BLACK);
		lblJugadas.setFont(new Font("Forte", Font.PLAIN, 20));
		lblJugadas.setBounds(501, 32, 83, 20);
		add(lblJugadas);
		
		lblGeneralaDoble = new JLabel("Generala doble");
		lblGeneralaDoble.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!lblGeneralaDoble.getText().equals("")&&modificable) {
					GameController gc = GameController.getInstancia();
					gc.cambiarOpcion(11,false);
				}
			}
		});
		lblGeneralaDoble.setFont(new Font("Forte", Font.PLAIN, 20));
		lblGeneralaDoble.setBounds(474, 387, 157, 20);
		add(lblGeneralaDoble);
		
		lblGenerala = new JLabel("Generala");
		lblGenerala.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!lblGenerala.getText().equals("")&&modificable) {
					GameController gc = GameController.getInstancia();
					gc.cambiarOpcion(10,false);
				}
			}
		});
		lblGenerala.setFont(new Font("Forte", Font.PLAIN, 20));
		lblGenerala.setBounds(474, 355, 157, 20);
		add(lblGenerala);
		
		lblPker = new JLabel("Póker");
		lblPker.setFont(new Font("Forte", Font.PLAIN, 20));
		lblPker.setBounds(474, 327, 157, 20);
		add(lblPker);
		lblPker.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!lblPker.getText().equals("")&&modificable) {
					GameController gc = GameController.getInstancia();
					gc.cambiarOpcion(9,false);
				}
			}
		});
		
		lblFull = new JLabel("Full");
		lblFull.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!lblFull.getText().equals("")&&modificable) {
					GameController gc = GameController.getInstancia();
					gc.cambiarOpcion(8,false);
				}
			}
		});
		lblFull.setFont(new Font("Forte", Font.PLAIN, 20));
		lblFull.setBounds(474, 301, 157, 20);
		add(lblFull);
		
		lblEscalera = new JLabel("Escalera");
		lblEscalera.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!lblEscalera.getText().equals("")&&modificable) {
					GameController gc = GameController.getInstancia();
					gc.cambiarOpcion(7,false);
				}
			}
		});
		lblEscalera.setFont(new Font("Forte", Font.PLAIN, 20));
		lblEscalera.setBounds(474, 270, 157, 20);
		add(lblEscalera);
		
		lblSumaDeSeis = new JLabel("Suma de Seis");
		lblSumaDeSeis.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!lblSumaDeSeis.getText().equals("")&&modificable) {
					GameController gc = GameController.getInstancia();
					gc.cambiarOpcion(6,false);
				}
			}
		});
		lblSumaDeSeis.setFont(new Font("Forte", Font.PLAIN, 20));
		lblSumaDeSeis.setBounds(474, 239, 157, 20);
		add(lblSumaDeSeis);
		
		lblSumaDeCincos = new JLabel("Suma de Cincos");
		lblSumaDeCincos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!lblSumaDeCincos.getText().equals("")&&modificable) {
					GameController gc = GameController.getInstancia();
					gc.cambiarOpcion(5,false);
				}
			}
		});
		lblSumaDeCincos.setFont(new Font("Forte", Font.PLAIN, 20));
		lblSumaDeCincos.setBounds(474, 212, 157, 20);
		add(lblSumaDeCincos);
		
		lblSumaDeCuatros = new JLabel("Suma de Cuatros");
		lblSumaDeCuatros.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!lblSumaDeCuatros.getText().equals("")&&modificable) {
					GameController gc = GameController.getInstancia();
					gc.cambiarOpcion(4,false);
				}
			}
		});
		lblSumaDeCuatros.setFont(new Font("Forte", Font.PLAIN, 20));
		lblSumaDeCuatros.setBounds(474, 182, 157, 20);
		add(lblSumaDeCuatros);
		
		lblSumaDeDos = new JLabel("Suma de Dos");
		lblSumaDeDos.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(!lblSumaDeDos.getText().equals("")&&modificable) {
					GameController gc = GameController.getInstancia();
					gc.cambiarOpcion(2,false);
				}
			}
		});
		lblSumaDeDos.setFont(new Font("Forte", Font.PLAIN, 20));
		lblSumaDeDos.setBounds(474, 120, 157, 20);
		add(lblSumaDeDos);
		
		lblSumaDeUnos = new JLabel("Suma de Unos");
		lblSumaDeUnos.setForeground(Color.BLACK);
		lblSumaDeUnos.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(!lblSumaDeUnos.getText().equals("")&&modificable) {
					GameController gc = GameController.getInstancia();
					gc.cambiarOpcion(1,false);
				}
			}
		});
		lblSumaDeUnos.setFont(new Font("Forte", Font.PLAIN, 20));
		lblSumaDeUnos.setBounds(474, 89, 157, 20);
		add(lblSumaDeUnos);
		
		lblPuntaje1 = new JLabel("Puntaje1");
		lblPuntaje1.setFont(new Font("Forte", Font.PLAIN, 20));
		lblPuntaje1.setBounds(45, 299, 81, 20);
		add(lblPuntaje1);
		
		lblPuntaje2 = new JLabel("Puntaje2");
		lblPuntaje2.setFont(new Font("Forte", Font.PLAIN, 20));
		lblPuntaje2.setBounds(329, 214, 98, 20);
		add(lblPuntaje2);
		
		avatar1 = new AvatarPanel(1);
		avatar1.setBounds(8, 323, 150, 150);
		add(avatar1);
		
		avatar2 = new AvatarPanel(2);
		avatar2.setBounds(304, 57, 150, 150);
		add(avatar2);
		
		btnTirarDados = new JButton("Tirar Dados");
		btnTirarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modificable) {
					GameController gc = GameController.getInstancia();
					gc.tirarDados();
				}
			}
		});
		btnTirarDados.setFont(new Font("Forte", Font.PLAIN, 20));
		btnTirarDados.setBounds(463, 446, 167, 23);
		add(btnTirarDados);
		
		JButton btnLockearJugada = new JButton("Lockear Jugada");
		btnLockearJugada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameController gc = GameController.getInstancia();
				gc.elegirJugada();
			}
		});
		btnLockearJugada.setFont(new Font("Forte", Font.PLAIN, 20));
		btnLockearJugada.setBounds(465, 416, 167, 23);
		add(btnLockearJugada);
		
		dice1 = new DicePanel(1,1);
		dice1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(modificable) {
					dice1.cambiarEstado();
				}
			}
		});
		dice1.setBounds(130, 130, 40, 40);
		add(dice1);
		dice2 = new DicePanel(0,2);
		dice2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(modificable) {
					dice2.cambiarEstado();
				}
			}
		});
		dice2.setBounds(180, 180, 40, 40);
		add(dice2);
		dice3 = new DicePanel(0,3);
		dice3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(modificable) {
					dice3.cambiarEstado();
				}
			}
		});
		dice3.setBounds(230, 230, 40, 40);
		add(dice3);
		dice4 = new DicePanel(1,4);
		dice4.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(modificable) {
					dice4.cambiarEstado();
				}
			}
		});
		dice4.setBounds(280, 280, 40, 40);
		add(dice4);
		dice5 = new DicePanel(1,5);
		dice5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(modificable) {
					dice5.cambiarEstado();
				}
			}
		});
		dice5.setBounds(330, 330, 40, 40);
		add(dice5);
		
		lblTiempo = new JLabel("Tiempo");
		lblTiempo.setFont(new Font("Forte", Font.PLAIN, 20));
		lblTiempo.setBounds(304, 32, 150, 20);
		add(lblTiempo);
		
		lblAccion = new JLabel("Accion");
		lblAccion.setFont(new Font("Forte", Font.PLAIN, 20));
		lblAccion.setBounds(10, 31, 280, 20);
		add(lblAccion);
		
		lblSumaDeTres = new JLabel("Suma de Tres");
		lblSumaDeTres.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(!lblSumaDeTres.getText().equals("")&&modificable) {
					GameController gc = GameController.getInstancia();
					gc.cambiarOpcion(3,false);
				}
			}
		});
		lblSumaDeTres.setFont(new Font("Forte", Font.PLAIN, 20));
		lblSumaDeTres.setBounds(474, 151, 157, 20);
		add(lblSumaDeTres);
		
		JLabel img = new JLabel();
		img.setLocation(8, 0);
		img.setSize(640,480);
		add(img);
		img.setIcon(image);
		img.setVisible(true);

	}
}
