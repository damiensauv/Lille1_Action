package scheduler;

import java.util.ArrayList;

import exception.ActionFinishedException;

import actions.Action;

public class SequentialScheduler extends Scheduler
{
	public SequentialScheduler()
	{
		this.actions = new ArrayList<Action>();
	}
	
	@Override
	public void doStep() throws ActionFinishedException
	{
		Action nextAction = this.actions.get(0);
		nextAction.doStep();
		if(nextAction.isFinished()){
			this.getActions().remove(actions.indexOf(nextAction));
		}
	}
}
