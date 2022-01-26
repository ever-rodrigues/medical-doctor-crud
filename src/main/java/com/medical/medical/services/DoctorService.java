package com.medical.medical.services;


import com.medical.medical.dto.mapper.DoctorMapper;
import com.medical.medical.dto.request.DoctorDTO;
import com.medical.medical.dto.response.MessageResponseDTO;
import com.medical.medical.entities.Doctor;
import com.medical.medical.exceptions.DoctorNotFoundException;
import com.medical.medical.repositories.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DoctorService {

        private final DoctorRepository doctorRepository;

        private final DoctorMapper doctorMapper;

        public MessageResponseDTO create(DoctorDTO doctorDTO) {
                Doctor doctor = doctorMapper.toModel(doctorDTO);
                Doctor savedDoctor = doctorRepository.save(doctor);
                MessageResponseDTO messageResponse = createMessageResponse("Doctor sucessfully added to system!", savedDoctor.getId());
                return messageResponse;
        }


        public DoctorDTO findById(Long id) throws DoctorNotFoundException {
                Doctor doctor = doctorRepository.findById(id)
                        .orElseThrow(() -> new DoctorNotFoundException(id));
                return doctorMapper.toDTO(doctor);

        }

        public List<DoctorDTO> listAll(){
                List<Doctor> doctor = doctorRepository.findAll();
                return doctor.stream()
                        .map(doctorMapper::toDTO)
                        .collect(Collectors.toList());
        }


        public MessageResponseDTO update(Long id,DoctorDTO doctorDTO) throws DoctorNotFoundException{
                doctorRepository.findById(id)
                        .orElseThrow(()-> new DoctorNotFoundException(id));
                Doctor updatedDoctor=doctorMapper.toModel(doctorDTO);
                Doctor savedDoctor= doctorRepository.save(updatedDoctor);

                MessageResponseDTO messageResponse = createMessageResponse("Doctor sucessfully updated with ID", savedDoctor.getId());
                return messageResponse;
        }

        public void delete(Long id) throws DoctorNotFoundException{
                doctorRepository.findById(id)
                        .orElseThrow(()->new DoctorNotFoundException(id));

                doctorRepository.deleteById(id);
        }

        private MessageResponseDTO createMessageResponse(String s, Long id2) {
                return MessageResponseDTO.builder()
                        .message(s + id2)
                        .build();
        }
}
