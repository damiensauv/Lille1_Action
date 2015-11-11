package actions;

import java.util.ArrayList;

import exception.ActionFinishedException;

public abstract class Action
{
	protected int totalTime = 0;
	protected int remainingTime = 0;
	protected boolean isReady = true;
	protected boolean isInitialized = false;
	protected final ArrayList<Action> actions = new ArrayList<Action>();
	
	protected  Action createAction(){
		return this;
	}

	public Action()
	{
	}
	
	public Action(int timeToEnd) 
	{
		this.totalTime = timeToEnd;
	}
	
	public boolean isFinished()
	{
		if (this.totalTime == this.remainingTime)
		{
			this.isInitialized = false;
			return true;
		}
		else
			return false;
	}
	
	public boolean isInProgress()
	{
		return (!this.isReady() && !this.isFinished() && this.isInitialized);
	}
	
	public boolean isReady()
	{
		return this.isReady;
	}
	
	public void doStep() throws ActionFinishedException
	{	
		if (this.isFinished())
			throw new ActionFinishedException("L'action est deja terminé");
		this.remainingTime++;
		if (this.isReady())
			this.isReady = false;
		this.isInitialized = true;
	}
}
