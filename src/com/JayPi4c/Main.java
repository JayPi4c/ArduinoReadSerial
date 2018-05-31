package com.JayPi4c;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Main {
	public static void main(String[] args) throws Exception {
		SerialTest main = new SerialTest();
		JFrame frame = new JFrame("Arduino Communication");
		Dimension d = new Dimension(640, 360);
		frame.setSize(d);
		frame.setPreferredSize(d);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		JTextField textField = new JTextField();
		textField.setBounds(40, 40, 560, 40);
		textField.setVisible(true);
		frame.add(textField);
		JButton button = new JButton("SEND");
		button.setBounds(280, 100, 80, 20);
		button.setVisible(true);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				main.sendData(textField.getText());
			}
		});
		frame.add(button);
		frame.getRootPane().setDefaultButton(button);
		JButton close = new JButton("CLOSE");
		close.setBounds(510, 270, 80, 20);
		close.setVisible(true);
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				main.close();
				System.exit(0);
			}
		});
		frame.add(close);

		frame.pack();
		frame.setVisible(true);

		main.initialize();
		Thread t = new Thread() {
			@Override
			public void run() {
				// the following line will keep this app alive for 1000 seconds,
				// waiting for events to occur and responding to them (printing incoming
				// messages to console).
				try {
					Thread.sleep(1000000);
					System.out.println("1000 seconds passed!");
					main.close();
				} catch (InterruptedException ie) {
				}
			}
		};
		t.start();
		System.out.println("Started");
		/*
		 * for (int i = 0; i < 10; i++) { main.sendData("CHANGE"); // Thread.sleep((i +
		 * 1) * 1000); Thread.sleep(1000); }
		 */
	}
}
