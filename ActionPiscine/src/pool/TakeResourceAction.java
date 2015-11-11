package pool;

import actions.*;

public class TakeResourceAction<R extends Ressource> extends Action
{
	public TakeResourceAction(RessourcePool<R> pool, ResourcefulUser<R> user){
		System.out.println("Take Resource");
	}
	
	
	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInProgress() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Action createAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
