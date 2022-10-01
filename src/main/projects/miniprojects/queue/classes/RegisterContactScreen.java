package main.projects.miniprojects.queue.classes;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterContactScreen extends JDialog {
	private JPanel panel = new JPanel();
	
	private JLabel labelName = new JLabel("Nome:");
	private JLabel labelEmail = new JLabel("Email:");
	
	private JTextField inputName = new JTextField();
	private JTextField inputEmail = new JTextField();
	
	private JButton btnInit = new JButton("Cadastrar");
	
	private ContactQueue queue = new ContactQueue();
	
	public RegisterContactScreen() {
		super.setTitle("Cadastro de Contatos");
		super.setSize(new Dimension(250, 250));
		super.setResizable(false);
		super.setLocationRelativeTo(null);
		
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = 0;
		grid.gridy = 0;
		grid.insets = new Insets(5, 5, 10, 5);
		grid.anchor = GridBagConstraints.PAGE_START;
		
		this.labelName.setPreferredSize(new Dimension(200, 25));
		this.panel.add(labelName);
		
		grid.gridx++;
		
		this.inputName.setPreferredSize(new Dimension(200, 25));
		this.panel.add(inputName);
		
		grid.gridx++;
		
		this.labelEmail.setPreferredSize(new Dimension(200, 30));
		this.panel.add(labelEmail);
		
		grid.gridx++;
		
		this.inputEmail.setPreferredSize(new Dimension(200, 30));
		this.panel.add(inputEmail);
		
		this.btnInit.setPreferredSize(new Dimension(100, 30));
		this.panel.add(btnInit);
				
		this.btnInit.addActionListener((ActionEvent arg0) -> { 
			for (int i  =0; i < 100; i++) { // Simulando 100 cadastros
				Contact contact = new Contact(inputName.getText(), inputEmail.getText());
				queue.add(contact);
			}
		});
	
		super.add(this.panel);
		
		queue.start();
		super.setVisible(true);
	}
}
