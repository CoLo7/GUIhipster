package gui.controller;

import gui.view.HipsterFrame;
import hipster.model.Hipster;


public class Controller 
{
	private Hipster firstHipster;
	private HipsterFrame baseFrame;
	
	public Controller()
	{
		firstHipster = new Hipster();
		baseFrame = new HipsterFrame(this);
		
	}
	
	public void start()
	{
		String myName = baseFrame.getResponse("What's your name brotha/sista?");
		firstHipster.setName(myName);
		baseFrame.setTitle(myName + "'s Book LookUp");
		
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
