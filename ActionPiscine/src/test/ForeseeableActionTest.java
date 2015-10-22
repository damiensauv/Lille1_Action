package test;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.Action;
import actions.ActionFinishedException;
import actions.ForeseeableAction;

public class ForeseeableActionTest {

	private Action createAction(int nbStepsMax)
	{
		return new ForeseeableAction(nbStepsMax);
	}
	
	@Test
	public void forseeableActionTest() throws ActionFinishedException 
	{
		Action action = createAction(2);
		
		assertTrue(action.isReady());
		assertFalse(action.isInProgress());
		assertFalse(action.isFinished());
		
		action.doStep();
		
		assertFalse(action.isReady());
		assertTrue(action.isInProgress());
		assertFalse(action.isFinished());
		
		action.doStep();
		
		assertFalse(action.isReady());
		assertTrue(action.isInProgress());
		assertFalse(action.isFinished());
		
		action.doStep();
		
		assertFalse(action.isReady());
		assertFalse(action.isInProgress());
		assertTrue(action.isFinished());
		
	}
	
	

}
