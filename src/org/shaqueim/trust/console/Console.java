package org.shaqueim.trust.console;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.shaqueim.trust.TrustUtils;
import org.shaqueim.trust.frame.listeners.CommandListener;

public class Console {
	
	private static JFrame frame;
	private static JPanel mainFrame;
	private static TextField input; static JScrollPane scroll;
	private static JTextArea consoleArea;
	
	public static void refreshFrame() {
		frame.revalidate();
	}
	
	public static void log(String str) {
		consoleArea.setText(consoleArea.getText()+"["+TrustUtils.formatDate(LocalDateTime.now())+"]: "+str+"\n");
	}
	
	public static void init() {
		
		frame = new JFrame("Trust - Console");
		frame.setSize(1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		mainFrame = new JPanel(new BorderLayout());
		
		input = new TextField();
		input.addActionListener(new CommandListener());
		
		consoleArea = new JTextArea("Welcome Trust Console\nType /commands for a list of commands.#2\n");
		consoleArea.setFont(new Font("Arial", Font.PLAIN, 16));
		
		consoleArea.setMargin(new Insets(10, 10, 10, 10));
		consoleArea.setEditable(false);
		consoleArea.setLineWrap(true);

	    scroll = new JScrollPane (consoleArea);
		
		mainFrame.add(scroll, BorderLayout.CENTER);
		mainFrame.add(input, BorderLayout.PAGE_END);
		
		frame.add(mainFrame);
		frame.setVisible(true);

		input.requestFocus();		
		refreshFrame();
	}

	public static void clearInputArea() {		
		input.setText("");
	}
	
}
