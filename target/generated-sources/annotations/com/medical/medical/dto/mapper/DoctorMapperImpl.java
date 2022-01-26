package com.medical.medical.dto.mapper;

import com.medical.medical.dto.request.DoctorDTO;
import com.medical.medical.dto.request.DoctorDTO.DoctorDTOBuilder;
import com.medical.medical.dto.request.PhoneDTO;
import com.medical.medical.dto.request.PhoneDTO.PhoneDTOBuilder;
import com.medical.medical.entities.Doctor;
import com.medical.medical.entities.Doctor.DoctorBuilder;
import com.medical.medical.entities.Phone;
import com.medical.medical.entities.Phone.PhoneBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-26T12:22:30-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class DoctorMapperImpl implements DoctorMapper {

    @Override
    public Doctor toModel(DoctorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DoctorBuilder doctor = Doctor.builder();

        doctor.firstName( dto.getLastName() );
        doctor.id( dto.getId() );
        doctor.lastName( dto.getLastName() );
        doctor.phones( phoneDTOListToPhoneList( dto.getPhones() ) );

        return doctor.build();
    }

    @Override
    public DoctorDTO toDTO(Doctor dto) {
        if ( dto == null ) {
            return null;
        }

        DoctorDTOBuilder doctorDTO = DoctorDTO.builder();

        doctorDTO.id( dto.getId() );
        doctorDTO.firstName( dto.getFirstName() );
        doctorDTO.lastName( dto.getLastName() );
        doctorDTO.phones( phoneListToPhoneDTOList( dto.getPhones() ) );

        return doctorDTO.build();
    }

    protected Phone phoneDTOToPhone(PhoneDTO phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        PhoneBuilder phone = Phone.builder();

        phone.id( phoneDTO.getId() );
        phone.type( phoneDTO.getType() );
        phone.number( phoneDTO.getNumber() );

        return phone.build();
    }

    protected List<Phone> phoneDTOListToPhoneList(List<PhoneDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Phone> list1 = new ArrayList<Phone>( list.size() );
        for ( PhoneDTO phoneDTO : list ) {
            list1.add( phoneDTOToPhone( phoneDTO ) );
        }

        return list1;
    }

    protected PhoneDTO phoneToPhoneDTO(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDTOBuilder phoneDTO = PhoneDTO.builder();

        phoneDTO.id( phone.getId() );
        phoneDTO.type( phone.getType() );
        phoneDTO.number( phone.getNumber() );

        return phoneDTO.build();
    }

    protected List<PhoneDTO> phoneListToPhoneDTOList(List<Phone> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneDTO> list1 = new ArrayList<PhoneDTO>( list.size() );
        for ( Phone phone : list ) {
            list1.add( phoneToPhoneDTO( phone ) );
        }

        return list1;
    }
}
