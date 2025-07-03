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
    public List<PartnerDTO> getAllPartners() {
        //전체조회
        List<PartnerEntity> partnerEntities = partnerRepository.findAll();
        //변환
        List<PartnerDTO> partnerDTOS = Arrays.asList(modelMapper.map(partnerEntities, PartnerDTO[].class));
        //전달
        return partnerDTOS;
    }

    //개별조회(조회할 대상)
    public PartnerDTO getPartnerById(Integer id) {
        //개별조회 방법 1
        PartnerEntity partnerEntity = partnerRepository.findById(id).orElse(null);
        //개별 조회 방법 2
        //Optional<PartnerEntity> partnerEntity1 = partnerRepository.findById(id);
        //변환
        PartnerDTO partnerDTO = modelMapper.map(partnerEntity, PartnerDTO.class);
        return partnerDTO;  //return modelMapper.map(partnerEntity, PartnerDTO.class);
    }

    //삽입(저장할 DTO필요)
    public PartnerDTO createPartner(PartnerDTO partnerDTO) {
        //변환
        PartnerEntity partnerEntity = modelMapper.map(partnerDTO, PartnerEntity.class);
        PartnerEntity result = partnerRepository.save(partnerEntity);
        //변환
        PartnerDTO partnerDTOS = modelMapper.map(result, PartnerDTO.class);

        return partnerDTOS;
        //return modelMapper.map(partnerRepository.save(partnerEntity), PartnerDTO.class);
    }

    //수정(대상, 수정할 값)
    public PartnerDTO updatePartner(Integer id, PartnerDTO partnerDTO) {
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

            PartnerDTO partnerDTOS = modelMapper.map(partnerDTO, PartnerDTO.class);
            return partnerDTOS;
        }

        return null;

        //PartnerEntity read = partnerRepository.findById(id).orElse(null);
        //if (read != null) {}
    }

    //삭제
    public void deletePartner(Integer id) {
        Optional<PartnerEntity> read = partnerRepository.findById(id);
        if (read.isPresent()) {
            partnerRepository.deleteById(id);
        }
    }
}
