package scheduler;

import java.util.ArrayList;
import exception.ActionFinishedException;
import actions.Action;

public class FairScheduler extends Scheduler
{
	protected int actionNb;
	
	public FairScheduler()
	{
		this.actions = new ArrayList<Action>();
		this.actionNb = 0;
	}
	
	@Override
	public void doStep() throws ActionFinishedException
	{
		Action nextAction = null;
		if (actionNb == this.actions.size())
		{
			nextAction = this.actions.get(0);
			actionNb = 0;
		}
		else
			nextAction = this.actions.get(actionNb);
		nextAction.doStep();
		if (nextAction.isFinished())
		{
			this.getActions().remove(actions.indexOf(nextAction));
			actionNb--;
		}
		actionNb++;
	}
}
