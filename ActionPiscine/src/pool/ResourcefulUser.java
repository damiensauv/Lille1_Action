package pool;

public class ResourcefulUser<R extends Ressource> {

    protected R resource;

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
