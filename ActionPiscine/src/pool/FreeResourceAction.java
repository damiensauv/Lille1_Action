package pool;

import java.util.NoSuchElementException;

import exception.ActionFinishedException;
import actions.*;

public class FreeResourceAction<R extends Ressource> extends Action
{
    protected RessourcePool<R> pool;
    protected ResourcefulUser<R> user;
    protected boolean isReady;
    protected boolean isInProgress;
    protected boolean isFinished;
	
	public FreeResourceAction(RessourcePool<R> pool, ResourcefulUser<R> user){
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
		System.out.print(" " + this.user.getName() + " free " + this.pool.toString() + "... ");
		try{
			R resource = this.user.getResource();
			this.pool.freeResource(resource);
			this.isReady = false;
			this.isFinished = true;
          	}catch(NoSuchElementException e){
          		System.out.println("bug");
          	}
	}

}
