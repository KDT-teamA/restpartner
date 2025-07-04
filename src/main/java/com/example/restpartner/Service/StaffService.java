package com.example.restpartner.Service;

import com.example.restpartner.DTO.PartnerDTO;
import com.example.restpartner.DTO.StaffDTO;
import com.example.restpartner.Entity.StaffEntity;
import com.example.restpartner.Repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StaffService {

    private final StaffRepository staffRepository;
    private final ModelMapper modelMapper;

    public StaffDTO create(StaffDTO staffDTO) {
        return modelMapper.map(staffRepository.save(modelMapper.map(staffDTO, StaffEntity.class)), StaffDTO.class);
    }

    public List<StaffDTO> list() {
        return Arrays.asList(modelMapper.map(staffRepository.findAll(), StaffDTO[].class));
    }

    public StaffDTO read(Integer id) {
        return modelMapper.map(staffRepository.findById(id), StaffDTO.class);
    }

    public StaffDTO update(Integer id, StaffDTO staffDTO) {
        Optional<StaffEntity> read = staffRepository.findById(id);
        if (read.isPresent()) {
            read.get().setStaffCode(staffDTO.getStaffCode()); //담당자코드
            read.get().setStaffName(staffDTO.getStaffName()); //담당자명
            read.get().setPosition(staffDTO.getPosition()); //직금
            read.get().setPhoneNumber(staffDTO.getPhoneNumber()); //연락처
            read.get().setEmail(staffDTO.getEmail()); //이메일

            return modelMapper.map(read.get(), StaffDTO.class);
        }

        return null;
    }

    public void delete(Integer id) {
        staffRepository.deleteById(id);
    }
}
