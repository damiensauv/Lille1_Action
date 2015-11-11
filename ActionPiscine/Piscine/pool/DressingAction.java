package pool;

import exception.ActionFinishedException;
import actions.ForeseeableAction;

public class DressingAction extends ForeseeableAction
{

	public DressingAction(int dress) {
		super(dress);
	}

	public void doStep() throws ActionFinishedException
	{
		super.doStep();
		System.out.println("-> dressing : " + this.getCurrentStep() + "/" + super.getNbStepsMax());
	}
}
