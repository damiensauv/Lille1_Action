package actions;

import static org.junit.Assert.*;

import org.junit.Test;

import scheduler.Scheduler;

public class ActionTest {

	private Action createAction(int nbStepsMax)
	{
		return new ForeseeableAction(nbStepsMax);
	}

	private Scheduler createScheduler()
	{
		return new Scheduler();
	}

	@Test
	public void onlyOneValidStateAtEachMomentForForeseebleAction() {
		onlyOneValidStateAtEachMoment(createAction(10));
	}

	@Test
	public void onlyOneValidStateAtEachMomentForScheduler()
	{
		Scheduler scheduler = createScheduler();
		scheduler.addAction(createAction(1));
		onlyOneValidStateAtEachMoment(scheduler);
	}

	protected void onlyOneValidStateAtEachMoment(Action action)
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

