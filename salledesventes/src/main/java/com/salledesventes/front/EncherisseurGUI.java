package com.salledesventes.front;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.salledesventes.*;

public class EncherisseurGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Vente vente = null;
	private String pseudo;
	private JTextField txtMonEnchere;
	private JLabel labelInfo;
	private Encherisseur encherisseur = null;
	private JTextField txtEncherisseur;
	private JTextField txtChrono;
	private JTextField txtDerniereEnchere;
	private JButton boutonAcheter;

	public EncherisseurGUI() {
		PseudoDialog d = new PseudoDialog(vente);
		d.setSize(500, 200);
		boolean isAdded = false;
		while (!isAdded) {
			d.setVisible(true);
			this.pseudo = d.getPseudo();
			vente = Vente.getInstance();
			encherisseur = new Encherisseur(pseudo);
			isAdded = vente.addEncherisseur(encherisseur);
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 840, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridBagLayout());

		JLabel labelAccueil = new JLabel(pseudo + " Soyez le dernier enchérisseur pour emporter la vente");
		labelAccueil.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_labelAccueil = new GridBagConstraints();
		gbc_labelAccueil.gridwidth = 4;
		gbc_labelAccueil.insets = new Insets(0, 0, 5, 5);
		gbc_labelAccueil.gridx = 0;
		gbc_labelAccueil.gridy = 0;
		contentPane.add(labelAccueil, gbc_labelAccueil);
		JLabel labelChrono = new JLabel("Temps restant pour l'enchère");
		labelChrono.setHorizontalAlignment(SwingConstants.RIGHT);
		labelChrono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints contraintes_labelchrono = new GridBagConstraints();
		contraintes_labelchrono.anchor = GridBagConstraints.EAST;
		contraintes_labelchrono.insets = new Insets(10, 0, 5, 5);
		contraintes_labelchrono.gridx = 0;
		contraintes_labelchrono.gridy = 1;
		contentPane.add(labelChrono, contraintes_labelchrono);

		txtChrono = new JTextField("00:00");
		txtChrono.setPreferredSize(new Dimension(150, 20));
		txtChrono.setText("Durée enchère");
		txtChrono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints contraintes_txtChrono = new GridBagConstraints();
		contraintes_txtChrono.gridwidth = 2;
		contraintes_txtChrono.anchor = GridBagConstraints.WEST;
		contraintes_txtChrono.insets = new Insets(10, 0, 5, 5);
		contraintes_txtChrono.gridx = 1;
		contraintes_txtChrono.gridy = 1;
		txtChrono.setEditable(false);
		contentPane.add(txtChrono, contraintes_txtChrono);

		JLabel labelDerniereEnchere = new JLabel("Dernière enchère");
		labelDerniereEnchere.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDerniereEnchere.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints contraintes_labelDerniereEnchere = new GridBagConstraints();
		contraintes_labelDerniereEnchere.anchor = GridBagConstraints.EAST;
		contraintes_labelDerniereEnchere.insets = new Insets(10, 0, 5, 5);
		contraintes_labelDerniereEnchere.gridx = 0;
		contraintes_labelDerniereEnchere.gridy = 2;
		contentPane.add(labelDerniereEnchere, contraintes_labelDerniereEnchere);

		txtDerniereEnchere = new JTextField("0.00");
		txtDerniereEnchere.setMaximumSize(new Dimension(100, 20));
		txtDerniereEnchere.setMinimumSize(new Dimension(100, 20));
		txtDerniereEnchere.setSize(new Dimension(100, 20));
		txtDerniereEnchere.setPreferredSize(new Dimension(100, 20));
		txtDerniereEnchere.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints contraintes_txtDerniereEnchere = new GridBagConstraints();
		contraintes_txtDerniereEnchere.anchor = GridBagConstraints.WEST;
		contraintes_txtDerniereEnchere.insets = new Insets(10, 0, 5, 5);
		contraintes_txtDerniereEnchere.gridx = 1;
		contraintes_txtDerniereEnchere.gridy = 2;
		txtDerniereEnchere.setEditable(false);
		contentPane.add(txtDerniereEnchere, contraintes_txtDerniereEnchere);

		JLabel labelEncherisseur = new JLabel("Enchérisseur");
		labelEncherisseur.setHorizontalTextPosition(SwingConstants.RIGHT);
		labelEncherisseur.setHorizontalAlignment(SwingConstants.RIGHT);
		labelEncherisseur.setMinimumSize(new Dimension(100, 14));
		labelEncherisseur.setMaximumSize(new Dimension(100, 14));
		labelEncherisseur.setSize(new Dimension(100, 14));
		labelEncherisseur.setPreferredSize(new Dimension(100, 14));
		labelEncherisseur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints contraintes_Encherisseur = new GridBagConstraints();
		contraintes_Encherisseur.fill = GridBagConstraints.HORIZONTAL;
		contraintes_Encherisseur.insets = new Insets(10, 0, 5, 5);
		contraintes_Encherisseur.gridx = 2;
		contraintes_Encherisseur.gridy = 2;
		contentPane.add(labelEncherisseur, contraintes_Encherisseur);

		txtEncherisseur = new JTextField("");
		txtEncherisseur.setEditable(false);
		txtEncherisseur.setPreferredSize(new Dimension(150, 20));
		txtEncherisseur.setSize(new Dimension(100, 14));
		txtEncherisseur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints contraintes_txtEncherisseur = new GridBagConstraints();
		contraintes_txtEncherisseur.insets = new Insets(10, 0, 5, 5);
		contraintes_txtEncherisseur.gridx = 3;
		contraintes_txtEncherisseur.gridy = 2;
		contentPane.add(txtEncherisseur, contraintes_txtEncherisseur);

		JLabel labelMonEnchere = new JLabel("Mon enchère");
		labelMonEnchere.setHorizontalAlignment(SwingConstants.RIGHT);
		labelMonEnchere.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints contraintes_labelMonEnchere = new GridBagConstraints();
		contraintes_labelMonEnchere.anchor = GridBagConstraints.EAST;
		contraintes_labelMonEnchere.insets = new Insets(10, 0, 5, 5);
		contraintes_labelMonEnchere.gridx = 0;
		contraintes_labelMonEnchere.gridy = 3;
		contentPane.add(labelMonEnchere, contraintes_labelMonEnchere);

		txtMonEnchere = new JTextField("0.00");
		txtMonEnchere.setSize(new Dimension(100, 20));
		txtMonEnchere.setPreferredSize(new Dimension(100, 20));
		txtMonEnchere.setMinimumSize(new Dimension(100, 20));
		txtMonEnchere.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints contraintes_txtMonEnchere = new GridBagConstraints();
		contraintes_txtMonEnchere.anchor = GridBagConstraints.WEST;
		contraintes_txtMonEnchere.insets = new Insets(10, 0, 5, 5);
		contraintes_txtMonEnchere.gridx = 1;
		contraintes_txtMonEnchere.gridy = 3;
		contentPane.add(txtMonEnchere, contraintes_txtMonEnchere);
		setContentPane(contentPane);

		boutonAcheter = new JButton("Enchérir");
		boutonAcheter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Encherir();
			}
		});
		boutonAcheter.setHorizontalTextPosition(SwingConstants.LEFT);
		boutonAcheter.setHorizontalAlignment(SwingConstants.LEFT);
		boutonAcheter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints contraintes_boutonAcheter = new GridBagConstraints();
		contraintes_boutonAcheter.gridwidth = 3;
		contraintes_boutonAcheter.insets = new Insets(10, 0, 5, 0);
		contraintes_boutonAcheter.gridx = 2;
		contraintes_boutonAcheter.gridy = 3;
		contentPane.add(boutonAcheter, contraintes_boutonAcheter);

		labelInfo = new JLabel("Proposez une enchère supérieure à la dernière enchère");
		labelInfo.setForeground(Color.RED);
		labelInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_labelInfo = new GridBagConstraints();
		gbc_labelInfo.gridwidth = 4;
		gbc_labelInfo.insets = new Insets(10, 0, 0, 5);
		gbc_labelInfo.gridx = 0;
		gbc_labelInfo.gridy = 4;
		contentPane.add(labelInfo, gbc_labelInfo);
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public void Encherir() {
		float montant = Float.parseFloat(txtMonEnchere.getText());
		// To be continued
	}

	public Vente getVente() {
		return vente;
	}
}
