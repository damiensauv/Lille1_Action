package pool;

import exception.ActionFinishedException;
import actions.ForeseeableAction;

public class SwimmingAction extends ForeseeableAction {

	public SwimmingAction(int swim) {
		super(swim);
	}

	public void doStep() throws ActionFinishedException
	{
		super.doStep();
		System.out.println(" swim (" + this.getCurrentStep() + "/" + super.getNbStepsMax() + ")");
	}
}
