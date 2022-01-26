package com.medical.medical.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DoctorType {
    PSYCHIATRISTIS("Psychiatristis"),
    OBSTETRICIAN("Obstetrician"),
    GYNECOLOGISTS("Gynecologists"),
    NEUROLOGISTS("Neurologists"),
    PEDIATRICIANS("Pediatricians"),
    CARDIOLOGISTS("Cardiologists");

    private final String description;



}
