package com.medical.medical.dto.mapper;

import com.medical.medical.dto.request.DoctorDTO;
import com.medical.medical.entities.Doctor;
import org.mapstruct.Mapper;
import  org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface DoctorMapper {

    @Mapping(target = "firstName", source = "lastName")
    Doctor toModel(DoctorDTO dto);
    DoctorDTO toDTO(Doctor dto);
}
