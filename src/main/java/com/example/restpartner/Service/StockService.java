package com.example.restpartner.Service;

import com.example.restpartner.DTO.StockDTO;
import com.example.restpartner.Entity.AnalystEntity;
import com.example.restpartner.Entity.StaffEntity;
import com.example.restpartner.Entity.StockEntity;
import com.example.restpartner.Repository.AnalystRepository;
import com.example.restpartner.Repository.StockRepository;
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
public class StockService {

    private final StockRepository stockRepository;
    private final AnalystRepository analystRepository;
    private final ModelMapper modelMapper;

    public StockDTO create(Integer analystId, StockDTO stockDTO) {
        AnalystEntity analystEntity = analystRepository.findById(analystId).get();
        StockEntity stockEntity = modelMapper.map(stockDTO, StockEntity.class);
        stockEntity.setAnalyst(analystEntity);
        return modelMapper.map(stockRepository.save(stockEntity), StockDTO.class);
    }

    public List<StockDTO> list_by_analyst_id(Integer analyst_id) {
        return Arrays.asList(modelMapper.map(stockRepository.findByAnalyst_Id(analyst_id), StockDTO[].class));
    }

    public StockDTO read(Integer id) {
        return modelMapper.map(stockRepository.findById(id), StockDTO.class);
    }

    public StockDTO update(Integer id, StockDTO stockDTO) {
        Optional<StockEntity> read = stockRepository.findById(id);
        if (read.isPresent()) {
            read.get().setName(stockDTO.getName()); //이름
            read.get().setMarket(stockDTO.getMarket()); //경력
            read.get().setPrice(stockDTO.getPrice()); //현재가
            read.get().setClose(stockDTO.getClose()); //종가
            read.get().setVolume(stockDTO.getVolume()); //종가

            return modelMapper.map(read.get(), StockDTO.class);
        }

        return null;
    }

    public void delete(Integer id) {
        stockRepository.deleteById(id);
    }
}
