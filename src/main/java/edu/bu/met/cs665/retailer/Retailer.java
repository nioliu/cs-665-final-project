package edu.bu.met.cs665.retailer;

import java.util.HashMap;
import java.util.Map;

/**
 * Name: Yulong Liu
 * Course: CS-665 Software Designs & Patterns
 * Date: 2024/2/16 15:26
 * File Name: Retailer.java
 * Description: Define interface of retailer
 */
public abstract class Retailer {
    // subjects for new delivery request to send
    private final Map<String, Subject> subjectMap = new HashMap<>();

    protected Retailer(Subject[] subjects) {
        for (Subject subject : subjects) {
            if (subjectMap.containsKey(subject.id())) {
                continue;
            }
            subjectMap.put(subject.id(), subject);
        }
    }

    public void notify(Delivery.AdditionalDeliveryDetail additionalDetail) {
        Delivery delivery = new Delivery(this, additionalDetail);
        for (Subject subject : subjectMap.values()) {
            subject.notifyObservers(delivery);
        }
    }

    // remove specified subject
    public void removeSubject(Subject subject) {
        subjectMap.remove(subject.id());
    }

    // the id of the retailer
    protected abstract String id();

    protected abstract String address();
}
