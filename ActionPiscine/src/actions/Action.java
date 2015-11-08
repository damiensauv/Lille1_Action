package actions;

import java.util.ArrayList;

import exception.ActionFinishedException;

public abstract class Action
{
	protected int totalTime = 0;
	protected int remainingTime = 0;
	protected boolean isReady = true;
	protected boolean isInitialized = false;
	protected boolean isScheduler= false;
	protected final ArrayList<Action> actions = new ArrayList<Action>();
	
	protected abstract Action createAction();

	public Action()
	{
	}
	
	public Action(int timeToEnd) 
	{
		this.totalTime = timeToEnd;
		if (timeToEnd == 0) {
			isScheduler = true;
		} else {
			isScheduler = false;
			this.remainingTime = timeToEnd;
		}
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
		if (this.isFinished())throw new ActionFinishedException("Erreur on scheduler");
		this.remainingTime++;
		if (this.isReady())
			this.isReady = false;
		this.isInitialized = true;
	}
}
