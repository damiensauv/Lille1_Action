package actions;

import java.util.ArrayList;


public abstract class Action
{
	protected int totalTime = 0;
	protected int remainingTime = 0;
	protected boolean isReady = true;
	protected boolean isInitialized = false;
	protected boolean isScheduler= false;
	protected final ArrayList<Action> actions = new ArrayList<Action>();
	
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

	public abstract boolean isReady();
	public abstract boolean isInProgress();
	public abstract boolean isFinished();
	
	public void doStep()
	{	
		if (!isScheduler)
			remainingTime--;
		else
		{
			isReady = false;
			Action nextAction = actions.get(0);
			nextAction.doStep();
			if (nextAction.isFinished())
				actions.remove(0);
		}	
	}

	public void addAction(Action subAction) {
		isInitialized = true;
		if (subAction.isFinished()) {
			throw new IllegalArgumentException(
					"Can’t add an already finished action");
		}
		if (isFinished()) {
			throw new IllegalStateException(
					"You can’t add an action to a finished scheduler");
		} else {
			actions.add(subAction);
		}
	}
}