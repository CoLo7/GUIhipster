package gui.view;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gui.controller.Controller;

public class HipsterFrame extends JFrame
{
	private HipsterPanel basePanel;
	private Controller baseController;
	
	public HipsterFrame(Controller baseController)
	{
		this.baseController = baseController;
		basePanel = new HipsterPanel(baseController);
		
		setupFrame();
	}
	
	
	
	public String getResponse(String prompt)
	{
		String response = JOptionPane.showInputDialog(this, prompt);
		return response;
	}
	
	public Controller getBaseController()
	{
		return baseController;
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(400, 400);
		this.setVisible(true);
		this.setResizable(false);
	}
}
