package com.medical.medical.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.Valid;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2,max = 50)
    private String firstName;


    @NotEmpty
    @Size(min = 2,max = 50)
    private String lastName;


    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;

}
