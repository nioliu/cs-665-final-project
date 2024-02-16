package edu.bu.met.cs665.retailer;

public class Retailer1 extends Retailer {
    public Retailer1(DeliveryRequest... subject) {
        super(subject);
    }

    @Override
    protected String id() {
        return "retailer1";
    }

    @Override
    protected String address() {
        return "02141, Cambridge, MA";
    }
}
