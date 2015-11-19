package gui.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hipster.model.Book;

import javax.swing.*;

import gui.controller.Controller;

import javax.swing.SwingConstants;

public class HipsterPanel extends JPanel
{
	private Controller baseController;
	private JComboBox<String> phraseComboBox;
	private SpringLayout baseLayout;
	private JLabel bookPageCountLabel;
	private JLabel bookAuthorLabel;
	private JLabel bookSubjectLabel;
	private JLabel bookTitleLabel;
	private JLabel bookPriceLabel;
	private JButton changeBookButton;
	private int maxClicks;
	private int startClick;
	
	public HipsterPanel(Controller baseController)
	{
		this.baseController = baseController; 
		baseLayout = new SpringLayout();
		phraseComboBox = new JComboBox<String>();
		baseLayout.putConstraint(SpringLayout.EAST, phraseComboBox, 234, SpringLayout.WEST, this);
		
		bookPageCountLabel = new JLabel("The page Count");
		bookAuthorLabel = new JLabel("The author");
		bookPriceLabel = new JLabel("The price");	
		bookSubjectLabel = new JLabel("The Genre");	
		bookTitleLabel = new JLabel("The Title");	
		changeBookButton = new JButton("Change Book");
		
		maxClicks = baseController.getFirstHipster().getHipsterBooks().length;
		startClick = 0;
		
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
		this.add(bookAuthorLabel);
		this.add(bookPageCountLabel);
		this.add(bookTitleLabel);
		this.add(bookPriceLabel);
		this.add(bookSubjectLabel);
		this.add(changeBookButton);
		
	}
	
	private void setupComboBox()
	{
		String [] phrases = baseController.getFirstHipster().getHipsterPhrases();
		DefaultComboBoxModel phraseModel = new DefaultComboBoxModel(phrases);
		phraseComboBox.setModel(phraseModel);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, phraseComboBox, 20, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, phraseComboBox, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, bookPageCountLabel, 6, SpringLayout.SOUTH, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.EAST, bookPageCountLabel, 0, SpringLayout.EAST, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, bookAuthorLabel, 87, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, bookAuthorLabel, -79, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, bookPriceLabel, 0, SpringLayout.EAST, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.EAST, bookSubjectLabel, 0, SpringLayout.EAST, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, bookSubjectLabel, 6, SpringLayout.SOUTH, bookTitleLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, bookTitleLabel, 6, SpringLayout.SOUTH, bookPageCountLabel);
		baseLayout.putConstraint(SpringLayout.EAST, bookTitleLabel, 0, SpringLayout.EAST, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, changeBookButton, 197, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, bookPriceLabel, -6, SpringLayout.NORTH, changeBookButton);
		baseLayout.putConstraint(SpringLayout.EAST, changeBookButton, 0, SpringLayout.EAST, bookAuthorLabel);
	}
	
	private void changeColor()
	{
		int red= (int) (Math.random() * 256);
		int green= (int) (Math.random() * 256);
		int blue= (int) (Math.random() * 256);
		setBackground(new Color(red, green, blue));
	}
	
	private void setupListeners()
	{
		phraseComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				changeColor();
				String updatedTitle = phraseComboBox.getSelectedItem().toString();
				baseController.getBaseFrame().setTitle(updatedTitle);
			}
	});
	
		changeBookButton.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent Click)
			{
				changeColor();
				Book [] tempBooks = baseController.getFirstHipster().getHipsterBooks();
				if(startClick < maxClicks)
				{
					bookSubjectLabel.setText("Book subject:" + tempBooks[startClick].getSubject());
					bookAuthorLabel.setText("Book author:" + tempBooks[startClick].getAuthor());
					bookTitleLabel.setText("Book title:" + tempBooks[startClick].getTitle());
					bookPageCountLabel.setText("Page count:" + tempBooks[startClick].getPageCount());
					bookPriceLabel.setText("Price:" + tempBooks[startClick].getPrice());
					startClick++;
				}
				else
				{
					startClick = 0;
					bookSubjectLabel.setText("Book subject:");
					bookAuthorLabel.setText("Book author:");
					bookTitleLabel.setText("Book title:");
					bookPageCountLabel.setText("Book Page count:");
					bookPriceLabel.setText("Book Price:");
				
				}
			}
		});
	
	}
}

