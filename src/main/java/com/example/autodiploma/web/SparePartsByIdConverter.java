package com.example.autodiploma.web;

import com.example.autodiploma.SpareParts;
import com.example.autodiploma.SpareParts.Type;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class SparePartsByIdConverter  implements Converter<String, SpareParts> {
    private Map<String, SpareParts> sparePartsMap = new HashMap<>();

    public SparePartsByIdConverter() {
        sparePartsMap.put("FLTO",
                new SpareParts("FLTO", "Flour Tortilla", Type.TRANSMISSION));
        sparePartsMap.put("COTO",
                new SpareParts("COTO", "Corn Tortilla", Type.TRANSMISSION));
        sparePartsMap.put("GRBF",
                new SpareParts("GRBF", "Ground Beef", Type.ENGINE));
        sparePartsMap.put("CARN",
                new SpareParts("CARN", "Carnitas", Type.ENGINE));
        sparePartsMap.put("TMTO",
                new SpareParts("TMTO", "Diced Tomatoes", Type.STEERING));
        sparePartsMap.put("LETC",
                new SpareParts("LETC", "Lettuce", Type.STEERING));
        sparePartsMap.put("CHED",
                new SpareParts("CHED", "Cheddar", Type.CHASSIS));
        sparePartsMap.put("JACK",
                new SpareParts("JACK", "Monterrey Jack", Type.CHASSIS));
    }

    @Override
    public SpareParts convert(String id) {
        return sparePartsMap.get(id);
    }
}
