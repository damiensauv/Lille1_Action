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
		super.doStep();
	}
	
	public ForeseeableAction createAction()
	{
		return this;
	}
}
