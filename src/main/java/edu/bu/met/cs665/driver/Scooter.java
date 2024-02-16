package edu.bu.met.cs665.driver;

import edu.bu.met.cs665.retailer.Delivery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Scooter implements Driver {
    private final Logger logger = LogManager.getLogger();
    private final String driverLicense;
    private final DriverType driverType = DriverType.Scooter;

    public Scooter(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    @Override
    public String driverLicense() {
        return this.driverLicense;
    }

    @Override
    public DriverType driverType() {
        return this.driverType;
    }

    @Override
    public void receiveNewDeliveryRequest(Delivery dr) {
        logger.info(String.format("Driver:%s receive a new delivery request:\n%s\n",
                driverLicense(), dr.getDeliveryDetails()));
    }
}
