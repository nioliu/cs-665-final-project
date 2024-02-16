package edu.bu.met.cs665.retailer;

import edu.bu.met.cs665.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DeliveryRequest implements Subject {
    private static final Logger logger = LogManager.getLogger();

    // store all the drivers
    private final Map<String, Driver> driverMap = new HashMap<>();
    private final String id;

    public DeliveryRequest(String id) {
        this.id = id;
    }


    @Override
    public String id() {
        return id;
    }

    @Override
    public void registerObserver(Driver... drivers) {
        for (Driver driver : drivers) {
            if (driverMap.containsKey(driver.driverLicense())) {
                logger.info("current driver license has been registered!!\n skip this.");
                return;
            }
            driverMap.put(driver.driverLicense(), driver);
        }

    }

    @Override
    public void notifyObservers(Object deliveryRequest) {
        if (!(deliveryRequest instanceof Delivery)) {
            logger.error("unexpected notify event for delivery");
            return;
        }
        driverMap.forEach(new BiConsumer<String, Driver>() {
            @Override
            public void accept(String s, Driver driver) {
                logger.info(String.format("notify driver:%s", driver.driverLicense()));
                driver.receiveNewDeliveryRequest((Delivery) deliveryRequest);
            }
        });
    }


    @Override
    public void removeObserver(Driver driver) {
        driverMap.remove(driver.driverLicense());
    }
}
