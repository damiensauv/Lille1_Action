package pool;

import scheduler.SequentialScheduler;
import actions.Action;

// extend action ?
public class Swimmer extends Action
{
    protected final ResourcefulUser<Basket> basketUser;
    protected final ResourcefulUser<Cubicle> cubicleUser;
    protected final SequentialScheduler process;

	public Swimmer(String name, RessourcePool<Basket> baskets, RessourcePool<Cubicle> cubicles, int undress, int swim, int dress)
	{
		super();

        this.process = new SequentialScheduler();
        this.basketUser = new ResourcefulUser<Basket>();
        this.cubicleUser = new ResourcefulUser<Cubicle>();

        this.process.addAction(new TakeResourceAction<Basket>(baskets, basketUser));//prend un panier                                                                                                                          
        this.process.addAction(new TakeResourceAction<Cubicle>(cubicles, cubicleUser));// prend une cabine                                                                                                                     
 
       
        this.process.addAction(new UndressingAction(undress)); // se déshabille                                                                                                       
       
        this.process.addAction(new FreeResourceAction<Cubicle>(cubicles, cubicleUser)); // libère la cabine                                                                                                                    
        this.process.addAction(new SwimmingAction(swim));                      // nage                                                                                                                                   
        this.process.addAction(new TakeResourceAction<Cubicle>(cubicles, cubicleUser)); //reprend une cabine                                                                                                                   
        this.process.addAction(new DressingAction(dress));                     // se rhabille                                                                                                                            
        this.process.addAction(new FreeResourceAction<Cubicle>(cubicles, cubicleUser)); // rend la cabine                                                                                                                      
        this.process.addAction(new FreeResourceAction<Basket>(baskets, basketUser));    // rend le panier     
		
		// take basket
		// taket Cubicle
		// undress
		// free Cubicle
		// swim
		// re-take Cubicle
		// dress
		// give back cubicle
		// give back basket
	}

	@Override
	protected Action createAction() {
		return null;
	}

}
