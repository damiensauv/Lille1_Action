package scheduler;

import java.util.ArrayList;
import java.util.List;

import actions.Action;
import actions.ActionFinishedException;

public class Scheduler extends Action
{
	protected List<Action> actions = new ArrayList<Action>();

	public Scheduler()
	{
		
	}
	
	public void doStep() throws ActionFinishedException
	{

	}

	public boolean isReady()
	{
		return true;
	}

	public boolean isInProgress()
	{
		return true;
	}

	public boolean isFinished()
	{
		return true;
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
