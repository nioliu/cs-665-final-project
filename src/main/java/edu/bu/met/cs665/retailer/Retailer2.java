package edu.bu.met.cs665.retailer;

public class Retailer2 extends Retailer {
    public Retailer2(DeliveryRequest... subject) {
        super(subject);
    }

    @Override
    protected String id() {
        return "retailer2";
    }

    @Override
    protected String address() {
        return "02040, Boston, MA";
    }
}
