package foodchain.states;

import foodchain.products.Product;

/**
 * Class represents state of product.
 */
public class RawState extends State {

    /**
     * Constructs state of product.
     */
    public RawState() {
        stateName = "Raw";
    }

    /**
     * Change state of product.
     * @param productContext the product to set state on.
     */
    @Override
    public void prepare(Product productContext) {
        productContext.setState(new StoredState());
    }
}