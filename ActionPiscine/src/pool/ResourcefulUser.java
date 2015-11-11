package pool;

public class ResourcefulUser<R extends Ressource> {

    protected R resource;
    protected String name;
    
    public ResourcefulUser(String name) {
    	this.name = name;
	}

    public String getName(){
    	return this.name;
    }
    
	public R getResource() {
            return resource;
    }

    public void setResource(R resource) {
            this.resource = resource;
    }

    public void resetResource() {
            this.resource = null;
    }
}
