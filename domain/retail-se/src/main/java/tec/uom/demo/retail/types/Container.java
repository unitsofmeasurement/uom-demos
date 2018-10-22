package tec.uom.demo.retail.types;

public class Container {
    final ContainerLength length;
    public ContainerLength getLength() {
        return length;
    }

    public ContainerHeight getHeight() {
        return height;
    }

    final ContainerHeight height;
    
    public Container(ContainerLength length, ContainerHeight height) {
        super();
        this.length = length;
        this.height = height;
    }
}
