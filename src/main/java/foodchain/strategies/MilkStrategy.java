package foodchain.strategies;

import foodchain.products.Product;
import static foodchain.parties.Data.*;

/**
 * Strategy to initialize characteristics of Milk.
 */
public class MilkStrategy extends Strategy {

    /**
     * Constructs strategy.
     * @param product the product for strategy.
     */
    public MilkStrategy(Product product) {
        super(product);
    }

    /**
     * Init strategy for storage parametres.
     */
    @Override
    public void initStorageParametres() {
        System.out.println("Store milk...");
        product.setStorageParameters(MILK_STORAGE_TIME, MILK_STORAGE_TEMPERATURE,
                MILK_STORAGE_HUMIDITY);
    }

    /**
     * Init strategy for seller parametres.
     */
    @Override
    public void initSellerParametres() {
        System.out.println("Sell milk...");
        product.setSellerParameters(MILK_PACKAGING, MILK_SELLING_PLACE);
    }

    /**
     * Init strategy for processor parametres.
     */
    @Override
    public void initProcessorParametres() {
        System.out.println("Process milk...");
        product.setProcessorParameters(MILK_PROCESSING_TEMPERATURE, MILK_CHEMICAL_PROCESSING_DEGREE);
    }
}