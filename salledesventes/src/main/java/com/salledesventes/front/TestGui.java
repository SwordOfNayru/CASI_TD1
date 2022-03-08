package com.salledesventes.front;

import java.awt.EventQueue;

public class TestGui {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncherisseurGUI frame1 = new EncherisseurGUI();
					frame1.setVisible(true);
					/*
					 * EncherisseurGUI frame2 = new EncherisseurGUI();
					 * frame2.setVisible(true);
					 * EncherisseurGUI frame3 = new EncherisseurGUI();
					 * frame3.setVisible(true);
					 */
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
