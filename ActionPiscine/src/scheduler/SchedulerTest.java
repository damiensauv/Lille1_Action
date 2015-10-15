package scheduler;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.Action;
import actions.ForeseeableAction;

public class SchedulerTest {

	private Action createAction(int nbStepsMax)
	{
		return new ForeseeableAction(nbStepsMax);
	}


	@Test
	public void schedulerTest() {
		Action action1 = createAction(2);
		Action action2 = createAction(1);
		Action scheduler = createAction(0);

		scheduler.addAction(action1);
		scheduler.addAction(action2);

		assertTrue(action1.isReady());
		assertTrue(action2.isReady());

		scheduler.doStep();

		assertTrue(action1.isInProgress());
		assertTrue(action2.isReady());

		scheduler.doStep();

		assertTrue(action1.isFinished());
		assertTrue(action2.isReady());

		scheduler.doStep();

		assertTrue(action1.isFinished());
		assertTrue(action2.isFinished());

	}

	@Test
	public void schedulerWithSchedulerTest() {
		Action action1 = createAction(2);
		Action action2 = createAction(2);
		Action subScheduler = createAction(0);
		Action scheduler = createAction(0);
		
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
