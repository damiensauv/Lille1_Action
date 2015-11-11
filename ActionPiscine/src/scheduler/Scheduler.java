package scheduler;

import java.util.ArrayList;
import java.util.List;

import actions.Action;
import exception.ActionFinishedException;

public abstract class Scheduler extends Action
{
	protected List<Action> actions = new ArrayList<Action>();

	public List<Action> getActions() {
		return actions;
	}
	
	
	@Override
	public abstract void doStep() throws ActionFinishedException;

	public boolean isReady()
	{
		for (Action action : this.actions) {
			if (!action.isReady())
				return false;
		}
		return true;
	}

	public boolean isInProgress()
	{
		for (Action action : this.actions) {
			if (action.isInProgress())
				return true;
		}
		return false;
	}

	public boolean isFinished()
	{
		return this.actions.isEmpty();
	}

	public void addAction(Action subAction)
	{
		this.actions.add(subAction);
		/*		isInitialized = true;
		if (subAction.isFinished()) {
			throw new IllegalArgumentException(
					"Can’t add an already finished action");
		}
		if (isFinished()) {
			throw new IllegalStateException(
					"You can’t add an action to a finished scheduler");
		} else {
			actions.add(subAction);
		}*/
	}
}
