package com.tgr.accounting.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class Frame extends JFrame {

	private static final long serialVersionUID = -8407500870276345105L;

	private List<Panel> panels = new ArrayList<Panel>();
	
	public Frame() {
		this("Default name");
	}
	
	public Frame(String name) {
		super(name);
		setSize(new Dimension(1280, 720));
		setLocation(200, 200);
		
		setLayout(new BorderLayout());
		
		
		Panel panel = new Panel(this);
		panels.add(panel);
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
		panel.setLayout(flowLayout);
		TabbedPane tabbedPane = new TabbedPane();
		panel.add(tabbedPane);
		tabbedPane.add("Input Module", new InputDataPanel(this));
		
		add(new JScrollPane(panel), BorderLayout.CENTER);
		
		repaint();
		setVisible(true);
		setSystemLookAndFeel();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	protected static void setSystemLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception exc) {
			System.err.println("Error loading L&F: " + exc);
		}
	}
}
