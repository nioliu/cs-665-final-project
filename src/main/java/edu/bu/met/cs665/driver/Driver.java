package edu.bu.met.cs665.driver;

import edu.bu.met.cs665.retailer.Delivery;

/**
 * Name: Yulong Liu
 * Course: CS-665 Software Designs & Patterns
 * Date: 2024/2/16 15:18
 * File Name: Driver.java
 * Description: Define Driver Interface
 */
public interface Driver {
    enum DriverType {
        TAXI,
        FreeLanceVan,
        Scooter
    }

    // the license of the driver
    String driverLicense();

    // the type of this driver
    DriverType driverType();

    // receive a nre delivery request from retailer
    void receiveNewDeliveryRequest(Delivery object);
}
