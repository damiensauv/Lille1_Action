package pool;

import java.util.NoSuchElementException;

import exception.ActionFinishedException;
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
	public void doStep() throws ActionFinishedException {
		System.out.print(" " + this.user.getName() + " trying to take resource from " + this.pool.toString() + "... ");
		try{
			R resource = this.pool.provideRessource();
			this.user.setResource(resource);
			this.isReady = false;
			this.isFinished = true;
			System.out.println("success");
          	}catch(NoSuchElementException e){
          		System.out.println("failure");
          	}
	}
	

}
