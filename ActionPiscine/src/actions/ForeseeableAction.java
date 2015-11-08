package actions;

import exception.ActionFinishedException;


public class ForeseeableAction extends Action
{
	protected int nbStepsMax;
	protected int nbCurrentStep;
	
	public ForeseeableAction(int nbStepsMax)
	{
		super(nbStepsMax);
	}

	public void doStep() throws ActionFinishedException
	{
		
	}
	
	public Action createAction()
	{
		return this;		
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
}
