package edu.bu.met.cs665.retailer;

import edu.bu.met.cs665.driver.Driver;
import edu.bu.met.cs665.retailer.Retailer;

public interface Subject {
    String id();
    // register driver into observer list
    void registerObserver(Driver... driver);

    // notifyObservers
    void notifyObservers(Object object);

    // remove specific retailer
    void removeObserver(Driver driver);
}
