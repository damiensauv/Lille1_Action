package pool;

/*
 * Basket Pool
 */
public class BasketPool extends RessourcePool<Basket>
{
	public BasketPool(int nb)
	{
		super(nb);
	}

	@Override
	protected Basket createRessource()
	{
		return (new Basket());
	}

	@Override
	public String toString(){
		return "pool basket";
	}
}