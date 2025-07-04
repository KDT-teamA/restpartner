package com.example.restpartner.Service;

import com.example.restpartner.DTO.PartnerDTO;
import com.example.restpartner.Entity.PartnerEntity;
import com.example.restpartner.Repository.PartnerRepository;
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
public class PartnerService {

    private final PartnerRepository partnerRepository;
    private final ModelMapper modelMapper;

    //전체조회
    public List<PartnerDTO> list() {
        return Arrays.asList(modelMapper.map(partnerRepository.findAll(), PartnerDTO[].class));
    }

    //개별조회(조회할 대상)
    public PartnerDTO read(Integer id) {
        return modelMapper.map(partnerRepository.findById(id).orElse(null), PartnerDTO.class);
    }

    //삽입(저장할 DTO필요)
    public PartnerDTO create(PartnerDTO partnerDTO) {
        PartnerEntity result = partnerRepository.save(modelMapper.map(partnerDTO, PartnerEntity.class));
        return modelMapper.map(result, PartnerDTO.class);
    }

    //수정(대상, 수정할 값)
    public PartnerDTO update(Integer id, PartnerDTO partnerDTO) {
        //수정할 데이터를 조회
        Optional<PartnerEntity> read = partnerRepository.findById(id);
        if (read.isPresent()) {
            //불러온 값에 수정할 값을 저장
            read.get().setPartnerCode(partnerDTO.getPartnerCode()); //거래처코드 수정
            read.get().setPartnerName(partnerDTO.getPartnerName()); //거래처이름
            read.get().setStartDate(partnerDTO.getStartDate()); //거래개시일
            read.get().setQuantity(partnerDTO.getQuantity()); //거래수량
            read.get().setUnitPrice(partnerDTO.getUnitPrice()); //거래가격
            read.get().setManagerCode(partnerDTO.getManagerCode()); //담당자 코드

            return modelMapper.map(partnerDTO, PartnerDTO.class);
        }

        return null;
    }

    //삭제
    public void delete(Integer id) {
        Optional<PartnerEntity> read = partnerRepository.findById(id);
        if (read.isPresent()) {
            partnerRepository.deleteById(id);
        }
    }
}
