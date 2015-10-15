package actions;


public class ForeseeableAction extends Action
{

	protected int nbStepsMax;
	protected int nbCurrentStep;
	
	public ForeseeableAction(int nbStepsMax)
	{
		super(nbStepsMax);
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
}
