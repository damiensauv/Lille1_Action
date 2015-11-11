package pool;

public class CubiclePool extends RessourcePool<Cubicle>
{
	public CubiclePool(int nb)
	{
		super(nb);
	}

	@Override
	protected Cubicle createRessource()
	{
		return (new Cubicle());
	}
	
	@Override
	public String toString(){
		return "pool Cubicle";
	}
}