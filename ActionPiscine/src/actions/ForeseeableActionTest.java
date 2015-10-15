package actions;

import static org.junit.Assert.*;

import org.junit.Test;

public class ForeseeableActionTest {

	private Action createAction(int nbStepsMax)
	{
		return new ForeseeableAction(nbStepsMax);
	}
	
	@Test
	public void forseeableActionTest() 
	{
		Action action = createAction(2);
		
		assertTrue(action.isReady());
		assertFalse(action.isInProgress());
		assertFalse(action.isReady());
		
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
