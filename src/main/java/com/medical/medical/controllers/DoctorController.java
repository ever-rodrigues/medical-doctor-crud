package com.medical.medical.controllers;


import com.medical.medical.dto.request.DoctorDTO;
import com.medical.medical.dto.response.MessageResponseDTO;
import com.medical.medical.exceptions.DoctorNotFoundException;
import com.medical.medical.services.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/doctor")
@AllArgsConstructor(onConstructor = @__(@Autowired))

public class DoctorController {

    private final DoctorService doctorService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
   public MessageResponseDTO create(@RequestBody @Valid DoctorDTO doctorDTO){
       return doctorService.create(doctorDTO);

   }

   @GetMapping("/{id}")
   @ResponseStatus(HttpStatus.OK)
   public DoctorDTO findById(@PathVariable Long id)throws DoctorNotFoundException{
        return doctorService.findById(id);
   }

   @GetMapping
    public List<DoctorDTO> listAll(){
        return doctorService.listAll();
   }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id,@RequestBody @Valid DoctorDTO doctorDTO) throws DoctorNotFoundException{
     return doctorService.update(id,doctorDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id)throws DoctorNotFoundException{
        doctorService.delete(id);
    }


}
