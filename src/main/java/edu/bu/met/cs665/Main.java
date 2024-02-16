package edu.bu.met.cs665;

import edu.bu.met.cs665.driver.TaxiDriver;
import edu.bu.met.cs665.retailer.DeliveryRequest;
import edu.bu.met.cs665.retailer.Delivery;
import edu.bu.met.cs665.retailer.Retailer;
import edu.bu.met.cs665.retailer.Retailer1;

public class Main {
    public static void main(String[] args) {
        DeliveryRequest deliveryRequest1 = new DeliveryRequest("1"); // subject
        Retailer retailer1 = new Retailer1(deliveryRequest1);
        TaxiDriver taxiDriver1 = new TaxiDriver("123");// observer
        TaxiDriver taxiDriver2 = new TaxiDriver("456");// observer
        TaxiDriver taxiDriver3 = new TaxiDriver("789");// observer

        deliveryRequest1.registerObserver(taxiDriver1, taxiDriver2, taxiDriver3);

        retailer1.notify(new Delivery.
                AdditionalDeliveryDetail("keyboard", "999, Boston, MA", 19.99));

    }
}
