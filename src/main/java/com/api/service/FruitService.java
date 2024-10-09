package com.api.service;

import com.api.entity.Fruits;
import com.api.exception.ResourceNotFoundException;
import com.api.payload.FruitsDto;
import com.api.repository.FruitRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FruitService {
    private ModelMapper modelMapper;
    private FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository, ModelMapper modelMapper){
        this.fruitRepository = fruitRepository;
        this.modelMapper=modelMapper;
    }
     @GetMapping
    public List<FruitsDto> getFruits() {
        List<Fruits> dto = fruitRepository.findAll();
        List<FruitsDto> dtos = dto.stream().map(r->mapToDto(r)).collect(Collectors.toList());
        return dtos;
    }

    public FruitsDto createFruits(FruitsDto fruitsDto) {
        Fruits fruits = mapToEntity(fruitsDto);
        Fruits saveEntity = fruitRepository.save(fruits);
        FruitsDto dto = mapToDto(saveEntity);
        //FruitsDto dto = new FruitsDto();
        return dto;
       // dto.setFruit_name(saveEntity.getFruit_name());
        //dto.setFruit_price(saveEntity.getFruit_price());
        //dto.setFruit_quantity(saveEntity.getFruit_quantity());


    }

    public Fruits updateFruits(long id, Fruits fruits) {
        Fruits f = fruitRepository.findById(id).get();
        f.setFruit_name(fruits.getFruit_name());
        f.setFruit_price(fruits.getFruit_price());
        f.setFruit_quantity(fruits.getFruit_quantity());
        Fruits saveEntity = fruitRepository.save(f);
        return saveEntity;
    }

    public void deleteFruits(long id) {
        fruitRepository.deleteById(id);
    }

    Fruits mapToEntity(FruitsDto fruitsDto){
        Fruits frr = modelMapper.map(fruitsDto, Fruits.class);
        return  frr;

    }

    FruitsDto mapToDto(Fruits fruits){
        FruitsDto frDto = modelMapper.map(fruits,FruitsDto.class);
        return frDto;
    }

    public FruitsDto getFruitsById(long id) {
        Fruits fruits = fruitRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Record not found: ")
        );
        return mapToDto(fruits);
    }


}
