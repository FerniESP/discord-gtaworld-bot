package main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.BevelBorder;

import DiscordBOT.DiscordBOT;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private JFrame frmZerobotPanel;
	private DiscordBOT robot = new DiscordBOT();
	private boolean botActivo = false;
	
	JLabel labelOutput = new JLabel("...");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmZerobotPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setConsola (String texto) {
		labelOutput.setText(texto);
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmZerobotPanel = new JFrame();
		frmZerobotPanel.setResizable(false);
		frmZerobotPanel.setTitle("ZeroBOT - Panel de Control");
		frmZerobotPanel.setBounds(100, 100, 489, 332);
		frmZerobotPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmZerobotPanel.getContentPane().setLayout(springLayout);
		
		JPanel panelCentral = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panelCentral, 0, SpringLayout.NORTH, frmZerobotPanel.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panelCentral, 0, SpringLayout.WEST, frmZerobotPanel.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panelCentral, 200, SpringLayout.NORTH, frmZerobotPanel.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panelCentral, 0, SpringLayout.EAST, frmZerobotPanel.getContentPane());
		frmZerobotPanel.getContentPane().add(panelCentral);
		
		JPanel panelConsola = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panelConsola, 0, SpringLayout.SOUTH, panelCentral);
		SpringLayout sl_panelCentral = new SpringLayout();
		panelCentral.setLayout(sl_panelCentral);
		
		JButton btnIniciarBot = new JButton("Iniciar BOT");
		btnIniciarBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (botActivo == false) {
					setConsola("Iniciando BOT!");
					robot.iniciarBOT();
					setConsola("BOT Iniciado!");
					
				}
				//TODO
			}
		});
		sl_panelCentral.putConstraint(SpringLayout.NORTH, btnIniciarBot, 10, SpringLayout.NORTH, panelCentral);
		sl_panelCentral.putConstraint(SpringLayout.WEST, btnIniciarBot, 10, SpringLayout.WEST, panelCentral);
		panelCentral.add(btnIniciarBot);
		springLayout.putConstraint(SpringLayout.WEST, panelConsola, 0, SpringLayout.WEST, frmZerobotPanel.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panelConsola, 0, SpringLayout.SOUTH, frmZerobotPanel.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panelConsola, 0, SpringLayout.EAST, frmZerobotPanel.getContentPane());
		frmZerobotPanel.getContentPane().add(panelConsola);
		SpringLayout sl_panelConsola = new SpringLayout();
		panelConsola.setLayout(sl_panelConsola);
		
		JLabel lblConsola = new JLabel("Consola:");
		sl_panelConsola.putConstraint(SpringLayout.NORTH, lblConsola, 10, SpringLayout.NORTH, panelConsola);
		sl_panelConsola.putConstraint(SpringLayout.WEST, lblConsola, 10, SpringLayout.WEST, panelConsola);
		panelConsola.add(lblConsola);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sl_panelConsola.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, lblConsola);
		sl_panelConsola.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, panelConsola);
		sl_panelConsola.putConstraint(SpringLayout.SOUTH, scrollPane, 69, SpringLayout.SOUTH, lblConsola);
		sl_panelConsola.putConstraint(SpringLayout.EAST, scrollPane, 473, SpringLayout.WEST, panelConsola);
		panelConsola.add(scrollPane);
		
		
		labelOutput.setOpaque(true);
		labelOutput.setForeground(Color.WHITE);
		labelOutput.setBackground(Color.BLACK);
		scrollPane.setViewportView(labelOutput);
	}
}
