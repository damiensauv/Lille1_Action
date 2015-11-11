package pool;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/*
 *   Abstract Class for all Ressource Pool	
 */
public abstract class RessourcePool<R extends Ressource>
{
	private List<R> pool;
	private List<R> used;

	protected abstract R createRessource();

	public RessourcePool(int nb)
	{
		this.pool = new ArrayList<R>(nb);
		this.used = new ArrayList<R>(nb);
		for (int i = 0 ; i < nb ; i++)
		{
			pool.add(this.createRessource());
		}
	}

	/*
	 * return first resource
	 */
	public R provideRessource()
	{
		if (!pool.isEmpty())
		{
			R ressource = pool.get(0);
			pool.remove(0);
			used.add(ressource);
			return ressource;
		}
		throw new NoSuchElementException();
	}

	public void freeResource(R r)
	{
		if (used.remove(r))
			pool.add(r);
		else
			throw new IllegalArgumentException();
	}

}
