package foodchain.products;

import foodchain.states.State;
import java.util.ArrayList;
import java.util.Map;
import com.google.common.collect.ImmutableMap; 
import foodchain.parties.Party;
import java.util.List;

/**
 * Abstract class representing product processed in a food chain.
 */
public abstract class Product {
    
    /**
     * State of product in different parties.
     */
    protected State state;

    /**
     * Price of product in different parties.
     */
    protected Integer price;

    /**
     * Name of current product.
     */
    protected String name;

    /**
     * List of previous state names.
     */
    protected List<String> statesHistory;

    /**
     * True if some party already has this product and it is not necessary
     * to make it in food factory.
     */
    protected boolean isReadyToTransmit;

    /**
     * True if is being processed by party in food chain.
     */
    protected boolean isCurrentlyProcessed;
    
    /**
     * List of parties in a food chain which are currently involved
     * in processing of this product.
     */
    protected List<Party> currentlyProcessingParties;
    
    /* Demos are necessary to modify and then convert to immutable maps */

    /**
     * Map of product's storing characteristic to modify.
     */
    protected Map<String, Integer> demoStorageParameters;

    /**
     * Immutable map of product's storing characteristics.
     */
    protected ImmutableMap<String, Integer> storageParameters;
    
    /**
     * Map of product's processing characteristic to modify.
     */
    protected Map<String, Integer> demoProcessorParameters;

    /**
     * Immutable map of product's processing characteristics.
     */
    protected ImmutableMap<String, Integer> processorParameters;
    
    /**
     * Map of product's selling characteristic to modify.
     */
    protected Map<String, String> demoSellerParameters;

    /**
     * Immutable map of product's selling characteristics.
     */
    protected ImmutableMap<String, String> sellerParameters;

    /**
     * Set state for product.
     * @param state the state to set.
     */
    public void setState(State state) {
        this.state = state;
        this.statesHistory.add(state.getStateName());
    }
    
    /**
     * Get current state of product.
     * @return product's current state.
     */
    public State getState() {
        return state;
    }


    /**
     * Get history of previous states of product.
     * @return list with state history.
     */
    public List<String> getStatesHistory() {
        return statesHistory;
    }

    /**
     * Get price of product.
     * @return product's price.
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Get name of product.
     * @return product's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get list of parties in a food chain which are currently involved.
     * in processing of this product.
     * @return list of parties involved.
     */
    public List<Party> getCurrentlyProcessingParties() {
        return currentlyProcessingParties;
    }

    /**
     * Get current status of being processed or not.
     * @return bool value of being processed or not.
     */
    public boolean isIsCurrentlyProcessed() {
        return isCurrentlyProcessed;
    }
    
    /**
     * Clears list of currently processing parties of product.
     */
    public void clearPartyList() {
        currentlyProcessingParties.clear();
    }

    /**
     * Adds party in list of currently processing parties of product.
     * @param party party to process.
     */
    public void addCurrentlyProcessingParties(Party party) {
        currentlyProcessingParties.add(party);
    }

    /**
     * Method for switching product to be currently processed.
     * @param isCurrentlyProcessed status of being processed.
     */
    public void setIsCurrentlyProcessed(boolean isCurrentlyProcessed) {
        this.isCurrentlyProcessed = isCurrentlyProcessed;
    }

    /**
     * Set product's status of being ready to be transmitted.
     * @return status of being ready to be transmitted.
     */
    public boolean isIsReadyToTransmit() {
        return isReadyToTransmit;
    }

    /**
     * Set product's status of being ready to be transmitted.
     * @param isReadyToTransmit status of being ready to be transmitted.
     */
    public void setIsReadyToTransmit(boolean isReadyToTransmit) {
        this.isReadyToTransmit = isReadyToTransmit;
    }
    
    /**
     * Set product's storing characteristics.
     * @param storageTime the storage time (product characteristic).
     * @param storageTemperature the storage temperature (product characteristic).
     * @param storageHumidity the storage humidity (product characteristic).
     */
    public void setStorageParameters(Integer storageTime, Integer storageTemperature,
                                     Integer storageHumidity) {
        demoStorageParameters.put("storage_time", storageTime);
        demoStorageParameters.put("storage_temperature", storageTemperature);
        demoStorageParameters.put("storage_humidity", storageHumidity);
        storageParameters = ImmutableMap.copyOf(demoStorageParameters);
        demoStorageParameters.clear();
    }

    /**
     * Get product's storing parameters.
     * @return map of product's storing characteristics.
     */
    public ImmutableMap<String, Integer> getStorageParameters() {
        return storageParameters;
    }
    
    /**
     * Set product's processing characteristics.
     * @param processorTemperature the processing temperature (product characteristic).
     * @param chemicalDegree the chemical degree (product characteristic).
     */
    public void setProcessorParameters(Integer processorTemperature, Integer
            chemicalDegree) {
        demoProcessorParameters.put("processing_temperature", processorTemperature);
        demoProcessorParameters.put("chemical_processing_degree", chemicalDegree);
        processorParameters = ImmutableMap.copyOf(demoProcessorParameters);
        demoProcessorParameters.clear();
    }

    /**
     * Get product's processing parameters.
     * @return map of product's processing characteristics.
     */
    public ImmutableMap<String, Integer> getProcessorParameters() {
        return processorParameters;
    }
    
    /**
     * Set product's selling characteristics.
     * @param packaging the type of packaging (product characteristic).
     * @param sellingPlace the selling place (product characteristic).
     */
    public void setSellerParameters(String packaging, String sellingPlace) {
        demoSellerParameters.put("type_of_packaging", packaging);
        demoSellerParameters.put("selling_place", sellingPlace);
        sellerParameters = ImmutableMap.copyOf(demoSellerParameters);
        demoSellerParameters.clear();
    }

    /**
     * Get map of product's selling characteristics.
     * @return map of product's selling characteristics.
     */
    public Map<String, String> getSellerParameters() {
        return sellerParameters;
    }


    /**
     * Get list of all parameters of a product.
     * @return list of all parameters.
     */
    public List<Map> getAllParameters() {
        List<Map> allProductParameters = new ArrayList<Map>();
        if (processorParameters != null) allProductParameters.add(processorParameters);
        if (sellerParameters != null) allProductParameters.add(sellerParameters);
        if (storageParameters != null) allProductParameters.add(storageParameters);

        return allProductParameters;
    }

    // for tests
    public void setCurrentlyProcessingParties(List<Party> currentlyProcessingParties) {
        this.currentlyProcessingParties = currentlyProcessingParties;
    }
}