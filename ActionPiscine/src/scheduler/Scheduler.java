package scheduler;

import java.util.ArrayList;
import java.util.List;

import actions.Action;

public abstract class Scheduler extends Action
{
	protected List<Action> actions = new ArrayList<Action>();

	public Scheduler()
	{
		
	}
	
	public void doStep()
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

	public void addAction(Action... actions)
	{
		for(Action action : actions) {
			addAction(action);
		}
	}
}
