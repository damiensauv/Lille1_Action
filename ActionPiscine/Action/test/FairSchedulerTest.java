package test;

import static org.junit.Assert.*;

import org.junit.Test;

import scheduler.FairScheduler;

import actions.Action;
import exception.ActionFinishedException;
import actions.ForeseeableAction;

public class FairSchedulerTest {

	private Action createAction(int nbStepsMax)
	{
		return new ForeseeableAction(nbStepsMax);
	}

	@Test
	public void schedulerTest() throws ActionFinishedException
	{
		Action action1 = createAction(1);
		Action action2 = createAction(2);
		FairScheduler scheduler = new FairScheduler();

		scheduler.addAction(action1);
		scheduler.addAction(action2);

		assertTrue(action1.isReady());
		assertTrue(action2.isReady());

		scheduler.doStep();

		assertFalse(action1.isInProgress());
		assertTrue(action2.isReady());

		scheduler.doStep();
		assertTrue(action1.isFinished());
		scheduler.doStep();
		assertTrue(action2.isFinished());
	}

	@Test
	public void schedulerWithSchedulerTest() throws ActionFinishedException
	{
		ForeseeableAction action1 = (ForeseeableAction) createAction(2);
		FairScheduler subScheduler = new FairScheduler();
		FairScheduler scheduler = new FairScheduler();

		subScheduler.addAction(action1);
		scheduler.addAction(subScheduler);

		assertTrue(action1.isReady());
		assertTrue(subScheduler.isReady());

		scheduler.doStep();

		assertTrue(action1.isInProgress());
		assertTrue(subScheduler.isInProgress());

		scheduler.doStep();

		assertTrue(action1.isFinished());
		assertTrue(subScheduler.isFinished());
	}

}
