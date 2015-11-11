package pool;

import actions.*;

public class TakeResourceAction<R extends Ressource> extends Action
{
    protected RessourcePool<R> pool;
    protected ResourcefulUser<R> user;
    protected boolean isReady;
    protected boolean isInProgress;
    protected boolean isFinished;
	
	public TakeResourceAction(RessourcePool<R> pool, ResourcefulUser<R> user){
		
		this.pool = pool;
		this.user = user;
		System.out.println("Take Resource");
	}
	
	
	@Override
	public boolean isReady() {
		return this.isReady;
	}

	@Override
	public boolean isInProgress() {
		return this.isInProgress;
	}

	@Override
	public boolean isFinished() {
		return this.isFinished;
	}

	@Override
	protected Action createAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
