package test;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.Action;
import exception.ActionFinishedException;
import actions.ForeseeableAction;

import scheduler.FairScheduler;
import scheduler.Scheduler;

public class ActionTest {

	private Action createAction(int nbStepsMax)
	{
		return new ForeseeableAction(nbStepsMax);
	}

	@Test
	public void onlyOneValidStateAtEachMomentForForeseebleAction() throws ActionFinishedException {
		onlyOneValidStateAtEachMoment(createAction(10));
	}

	@Test
	public void onlyOneValidStateAtEachMomentForScheduler() throws ActionFinishedException
	{
		FairScheduler fairscheduler = new FairScheduler(); 
		fairscheduler.addAction(createAction(1));
		onlyOneValidStateAtEachMoment(fairscheduler);
	}

	protected void onlyOneValidStateAtEachMoment(Action action) throws ActionFinishedException
	{
		assertTrue(action.isReady());
		assertFalse(action.isInProgress());
		assertFalse(action.isFinished());
		while (!action.isFinished()) {
			action.doStep();
			assertFalse(action.isReady());
			// isFinished xor isInProgress
			assertTrue(action.isFinished() == !action.isInProgress());
		}
		assertFalse(action.isReady());
		assertFalse(action.isInProgress());
		assertTrue(action.isFinished());
	}
}

