package gui.controller;

import gui.view.HipsterFrame;
import hipster.model.Hipster;
import gui.view.HipsterPanel;


public class Controller 
{
	private Hipster firstHipster;
	private HipsterFrame baseFrame;
	
	public Controller()
	{
		baseFrame = new HipsterFrame(this);
	}
	
	public void start()
	{
		String myName = baseFrame.getResponse("What is your name?");
		firstHipster.setName(myName);
		baseFrame.setTitle(myName + "'s project name");
		
	}
	
	public Hipster getFirstHipster()
	{
		return firstHipster;
	}
	
	public HipsterFrame getBaseFrame()
	{
		return baseFrame;
	}
}
