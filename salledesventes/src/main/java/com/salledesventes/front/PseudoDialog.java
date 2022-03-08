package com.salledesventes.front;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.salledesventes.*;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class PseudoDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textPseudo;
	private String pseudo;

	/**
	 * Create the dialog.
	 */
	public PseudoDialog(Vente vente) {
		setModal(true);
		setBounds(100, 100, 413, 205);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		textPseudo = new JTextField();
		textPseudo.setBounds(144, 37, 197, 31);
		textPseudo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPseudo.setText("Joueur 1");
		textPseudo.setToolTipText("Saisissez votre pseudo");
		contentPanel.add(textPseudo);
		textPseudo.setColumns(10);

		JLabel lblNewLabel = new JLabel("Choisissez un pseudo");
		lblNewLabel.setBounds(10, 44, 135, 17);
		lblNewLabel.setLabelFor(textPseudo);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pseudo = textPseudo.getText();
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

	public String getPseudo() {
		return pseudo;
	}

}
