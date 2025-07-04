package com.example.restpartner.Service;

import com.example.restpartner.DTO.AnalystDTO;
import com.example.restpartner.DTO.AnalystDTO;
import com.example.restpartner.Entity.AnalystEntity;
import com.example.restpartner.Entity.AnalystEntity;
import com.example.restpartner.Repository.AnalystRepository;
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
public class AnalystService {

    private final AnalystRepository analystRepository;
    private final ModelMapper modelMapper;

    public AnalystDTO create(AnalystDTO analystDTO) {
        return modelMapper.map(analystRepository.save(modelMapper.map(analystDTO, AnalystEntity.class)), AnalystDTO.class);
    }

    public List<AnalystDTO> list() {
        return Arrays.asList(modelMapper.map(analystRepository.findAll(), AnalystDTO[].class));
    }

    public AnalystDTO read(Integer id) {
        return modelMapper.map(analystRepository.findById(id), AnalystDTO.class);
    }

    public AnalystDTO update(Integer id, AnalystDTO analystDTO) {
        Optional<AnalystEntity> read = analystRepository.findById(id);
        if (read.isPresent()) {
            read.get().setName(analystDTO.getName()); //이름
            read.get().setExperience(analystDTO.getExperience()); //경력
            read.get().setCompany(analystDTO.getCompany()); //소속
            read.get().setAvgAnnual(analystDTO.getAvgAnnual()); //연평균수익률

            return modelMapper.map(read.get(), AnalystDTO.class);
        }

        return null;
    }

    public void delete(Integer id) {
        analystRepository.deleteById(id);
    }
}
