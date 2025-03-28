package com.ramesh.models;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Currency {
    private String iso3;  // Currency code (e.g., USD, INR)
    private String name;  // Currency name (e.g., U.S. Dollar)
    private int unit;     // Unit value for exchange (e.g., 1 for USD, 100 for INR)
}
