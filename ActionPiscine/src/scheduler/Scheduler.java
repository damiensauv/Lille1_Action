package scheduler;

import java.util.ArrayList;
import java.util.List;

import actions.Action;
import actions.ActionFinishedException;

public abstract class Scheduler extends Action
{
	protected List<Action> actions = new ArrayList<Action>();

	public List<Action> getActions() {
		return actions;
	}
	
	public Action createAction()
	{
		return this;		
	}
	
	public void doStep() throws ActionFinishedException
	{

	}

	public boolean isReady()
	{
		if (!isScheduler)
			return remainingTime == totalTime;
		else
			return isInitialized && isReady;
	}

	public boolean isInProgress()
	{
		if (!isScheduler)
			return !isReady() && !isFinished();
		else
			return isInitialized && !isReady() && !isFinished();
	}

	public boolean isFinished()
	{
		if (!isScheduler)
			return remainingTime <= 0;
		else
			return isInitialized && !isReady() && actions.isEmpty();
	}

	public void addAction(Action subAction)
	{
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
