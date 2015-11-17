package gui.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import gui.controller.Controller;

import javax.swing.SwingConstants;

public class HipsterPanel extends JPanel
{
	private Controller baseController;
	private JComboBox<String> phraseComboBox;
	private SpringLayout baseLayout;
	
	public HipsterPanel(Controller baseController)
	{
		this.baseController = baseController; 
		baseLayout = new SpringLayout();
		phraseComboBox = new JComboBox<String>();
		
		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.ORANGE);
		this.add(phraseComboBox);
	}
	
	private void setupComboBox()
	{
		String [] phrases = baseController.getFirstHipster().getHipsterPhrases();
		DefaultComboBoxModel phraseModel = new DefaultComboBoxModel(phrases);
		phraseComboBox.setModel(phraseModel);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		phraseComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
			int red= (int) (Math.random() * 256);
			int green= (int) (Math.random() * 256);
			int blue= (int) (Math.random() * 256);
			setBackground(new Color(red, green, blue));
			String updatedTitle = phraseComboBox.getSelectedItem().toString();
			baseController.getBaseFrame().setTitle(updatedTitle);
			}
	});
	
	
	}
}

