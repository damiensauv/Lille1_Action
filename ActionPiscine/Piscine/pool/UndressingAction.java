package pool;

import exception.ActionFinishedException;
import actions.ForeseeableAction;

public class UndressingAction extends ForeseeableAction
{

	public UndressingAction(int undress) {
		super(undress);
	}

	public void doStep() throws ActionFinishedException
	{
		super.doStep();
		System.out.println("-> undressing : " + this.getCurrentStep() + "/" + super.getNbStepsMax());
	}
}
