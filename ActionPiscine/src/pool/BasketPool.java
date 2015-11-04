package pool;

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
}