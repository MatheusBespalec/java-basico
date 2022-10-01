package main.projects.miniprojects.timerthred.screens;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TimerScreen extends JDialog {
	/* Declaracao dos componentes */
	// Painel
	private JPanel panel = new JPanel(new GridBagLayout());
	
	// Labels
	private JLabel labelTimerThread1 = new JLabel("Tempo Thread 1");
	private JLabel labelTimerThread2 = new JLabel("Tempo Thread 2");
	
	// Inputs
	private JTextField inputDate1 = new JTextField();
	private JTextField inputDate2 = new JTextField();
	
	// Buttons
	private JButton button1 = new JButton("Start");
	private JButton button2 = new JButton("Stop");
	
	private Thread threadTimer1;
	private Thread threadTimer2;
	
	private Runnable timer1 = new Runnable() {
		@Override
		public void run() {
			while (true) {
				inputDate1.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(Calendar.getInstance().getTime()));
				
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	};
	
	private Runnable timer2 = new Runnable() {
		@Override
		public void run() {
			while (true) {
				inputDate2.setText(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime()));
				
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	};
	
	public TimerScreen() {
		super.setTitle("Timer com Threads"); // Titulo do programa
		super.setSize(new Dimension(250, 250)); // Define as dimensoes da tela
		super.setLocationRelativeTo(null); // Define a posicao de onde a tela ira abrir, passando null o programa abre no meio do monitor
		super.setResizable(true); // Define se a janela pode ser redimensionada
		
		GridBagConstraints bagConstraints = new GridBagConstraints();
		bagConstraints.gridx = 0; // Define a linha atual do grid
		bagConstraints.gridy = 0; // define a coluna atual do grid
		bagConstraints.gridwidth = 2;
		bagConstraints.insets = new Insets(5, 10, 5, 5); // Espaco entre os componentes
		bagConstraints.anchor = GridBagConstraints.WEST; // Posicao dos elementos, a ancora dos elementos
		
		labelTimerThread1.setPreferredSize(new Dimension(230, 30)); // Define o tamanho da label
		panel.add(labelTimerThread1, bagConstraints); // Adiciona a label no painel
		
		bagConstraints.gridy++;
		inputDate1.setPreferredSize(new Dimension(230, 30));
		inputDate1.setEditable(false);
		panel.add(inputDate1, bagConstraints);
		
		bagConstraints.gridy++;
		labelTimerThread2.setPreferredSize(new Dimension(230, 30)); // Define o tamanho da label
		panel.add(labelTimerThread2, bagConstraints); // Adiciona a label no painel
		
		bagConstraints.gridy++;
		inputDate2.setPreferredSize(new Dimension(230, 30));
		inputDate2.setEditable(false);
		panel.add(inputDate2, bagConstraints);
		
		bagConstraints.gridy++;
		bagConstraints.gridwidth = 1;
		
		button1.setPreferredSize(new Dimension(105, 30));
		panel.add(button1, bagConstraints);
		
		bagConstraints.gridx++;
		
		button2.setPreferredSize(new Dimension(105, 30));
		button2.setEnabled(false);
		panel.add(button2, bagConstraints);
		
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				threadTimer1 = new Thread(timer1);
				threadTimer1.start();
				
				threadTimer2 = new Thread(timer2);
				threadTimer2.start();
				
				button1.setEnabled(false);
				button2.setEnabled(true);
			}
		});
		
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				threadTimer1.stop();
				threadTimer2.stop();
				
				button1.setEnabled(true);
				button2.setEnabled(false);
			}
		});
		
		super.add(panel, BorderLayout.PAGE_START); // Coloca o painel dentro da janela (JDialog)
		
		// Exibe a tela para o usuario(deve vir sempre por ultimo)
		super.setVisible(true);
	}
}
