package pool;

import actions.*;

public class FreeResourceAction<R extends Ressource> extends Action
{

	public FreeResourceAction(RessourcePool<R> pool,
			ResourcefulUser<R> user) {
		// TODO Auto-generated constructor stub
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
