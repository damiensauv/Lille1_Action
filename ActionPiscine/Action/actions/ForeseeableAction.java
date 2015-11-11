package actions;

import exception.ActionFinishedException;


public class ForeseeableAction extends Action
{
	protected int nbStepsMax;
	protected int nbCurrentStep;
	
	
	public int getNbStepsMax(){
		return this.nbStepsMax;
	}
	
	public int getCurrentStep(){
		return this.nbCurrentStep;
	}
	
	public ForeseeableAction(int nbStepsMax)
	{
		super(nbStepsMax);
		this.nbStepsMax = nbStepsMax;
	}

	public void doStep() throws ActionFinishedException
	{
		super.doStep();
        this.nbCurrentStep++;
	}
	
	public ForeseeableAction createAction()
	{
		return this;
	}
}
