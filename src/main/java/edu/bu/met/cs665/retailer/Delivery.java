package edu.bu.met.cs665.retailer;

public class Delivery {

    private final Retailer retailer;
    private final AdditionalDeliveryDetail additionalDetail;

    public static class AdditionalDeliveryDetail {
        private final String productInfo;
        private final String destineAddr;
        private final double fees;

        public AdditionalDeliveryDetail(String productInfo, String destineAddr, double fees) {
            this.productInfo = productInfo;
            this.destineAddr = destineAddr;
            this.fees = fees;
        }
    }

    public Delivery(Retailer retailer, AdditionalDeliveryDetail additionalDetail) {
        this.retailer = retailer;
        this.additionalDetail = additionalDetail;
    }

    public String getDeliveryDetails() {
        return toString();
    }

    @Override
    public String toString() {
        return String.format("%s wants to delivery a \"%s\" from " +
                        "\"%s\" to \"%s\" with \"%f\"$.", retailer.id(), additionalDetail.productInfo,
                retailer.address(), additionalDetail.destineAddr, additionalDetail.fees);
    }
}
