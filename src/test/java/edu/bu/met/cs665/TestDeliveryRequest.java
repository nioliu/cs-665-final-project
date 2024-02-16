package edu.bu.met.cs665;

import edu.bu.met.cs665.driver.Driver;
import edu.bu.met.cs665.driver.FreelanceVan;
import edu.bu.met.cs665.driver.TaxiDriver;
import edu.bu.met.cs665.retailer.DeliveryRequest;
import edu.bu.met.cs665.retailer.Delivery;
import edu.bu.met.cs665.retailer.Retailer1;
import org.junit.Test;

public class TestDeliveryRequest {
    @Test
    public void TestBasic() {
        DeliveryRequest deliveryRequest1 = new DeliveryRequest("1"); // subject
        Retailer1 retailer1 = new Retailer1(deliveryRequest1);
        Driver taxiDriver1 = new TaxiDriver("123");// observer
        Driver taxiDriver2 = new TaxiDriver("456");// observer
        Driver taxiDriver3 = new TaxiDriver("789");// observer
        Driver taxiDriver4 = new TaxiDriver("111");// observer
        Driver taxiDriver5 = new TaxiDriver("222");// observer
        Driver taxiDriver6 = new TaxiDriver("333");// observer

        deliveryRequest1.registerObserver(taxiDriver1, taxiDriver2, taxiDriver3, taxiDriver4, taxiDriver5, taxiDriver6);

        retailer1.notify(new Delivery.
                AdditionalDeliveryDetail("keyboard", "999, Boston, MA", 19.99));
    }

    @Test
    public void TestRemove() {
        DeliveryRequest deliveryRequest1 = new DeliveryRequest("1"); // subject
        Retailer1 retailer1 = new Retailer1(deliveryRequest1);
        Driver taxiDriver1 = new TaxiDriver("123");// observer
        Driver taxiDriver2 = new TaxiDriver("456");// observer
        Driver taxiDriver3 = new TaxiDriver("789");// observer

        deliveryRequest1.registerObserver(taxiDriver1, taxiDriver2, taxiDriver3);

        retailer1.notify(new Delivery.
                AdditionalDeliveryDetail("keyboard", "999, Boston, MA", 19.99));

        deliveryRequest1.removeObserver(taxiDriver2);
        retailer1.notify(new Delivery.
                AdditionalDeliveryDetail("keyboard", "444, Boston, MA", 25.88));
    }

    /**
     * same license will be notified only once
     */
    @Test
    public void TestRepeat() {
        DeliveryRequest deliveryRequest1 = new DeliveryRequest("1"); // subject
        Retailer1 retailer1 = new Retailer1(deliveryRequest1);
        Driver taxiDriver1 = new TaxiDriver("d123");// observer
        Driver fanDriver1 = new FreelanceVan("d123");// observer

        deliveryRequest1.registerObserver(taxiDriver1, fanDriver1);

        retailer1.notify(new Delivery.
                AdditionalDeliveryDetail("keyboard", "999, Boston, MA", 19.99));
    }

    /**
     * different retailer can remind different one or multi subjects.
     */
    @Test
    public void TestMultiSubject() {
        DeliveryRequest deliveryRequest1 = new DeliveryRequest("1"); // subject1
        DeliveryRequest deliveryRequest2 = new DeliveryRequest("2"); // subject2

        Retailer1 retailer1 = new Retailer1(deliveryRequest1, deliveryRequest2);// notify multiple drivers

        Driver taxiDriver1 = new TaxiDriver("d123");// observer
        Driver taxiDriver2 = new TaxiDriver("d456");// observer
        Driver taxiDriver3 = new TaxiDriver("d789");// observer

        Driver fanDriver1 = new FreelanceVan("f123");// observer
        Driver fanDriver2 = new FreelanceVan("f456");// observer
        Driver fanDriver3 = new FreelanceVan("f789");// observer

        // register observer
        deliveryRequest1.registerObserver(taxiDriver1, taxiDriver2, taxiDriver3);
        deliveryRequest2.registerObserver(fanDriver2, fanDriver1, fanDriver3);

        // create a delivery
        Delivery.AdditionalDeliveryDetail deliveryDetail = new Delivery.
                AdditionalDeliveryDetail("keyboard", "999, Boston, MA", 19.99);
        // send to all subjects
        retailer1.notify(deliveryDetail);
    }

}
