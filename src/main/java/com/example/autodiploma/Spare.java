package com.example.autodiploma;

import lombok.Data;

import java.util.List;

@Data
public class Spare {
    private String name;
    private List<SpareParts> spareParts;
}
