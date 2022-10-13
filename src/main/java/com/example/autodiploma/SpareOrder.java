package com.example.autodiploma;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SpareOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private List<Spare> spareList = new ArrayList<>();
    public void addSpare(Spare spare) {
        this.spareList.add(spare);
    }
}
