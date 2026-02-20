package com.farmerservice.service;

import com.farmerservice.dto.FarmerDTO;
import com.farmerservice.entity.Farmer;
import com.farmerservice.repository.FarmerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FarmerService {

    private FarmerRepository farmerRepository;

    public FarmerService(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }


    public FarmerDTO createFarmer(FarmerDTO farmerDTO) {
        Farmer farmer = mapToEntity(farmerDTO);
        Farmer savedFarmer = farmerRepository.save(farmer);
        return mapToDTO(savedFarmer);
    }


    public FarmerDTO getFarmerById(Long id) {
        Farmer farmer = farmerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmer Not Found"));
        return mapToDTO(farmer);
    }


    public List<FarmerDTO> getAllFarmers() {
        return farmerRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }


    public FarmerDTO updateFarmer(Long id, FarmerDTO farmerDTO) {
        Farmer farmer = farmerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));

        farmer.setName(farmerDTO.getName());
        farmer.setMobileNumber(farmerDTO.getMobileNumber());
        farmer.setGmail(farmerDTO.getGmail());

        Farmer updatedFarmer = farmerRepository.save(farmer);
        return mapToDTO(updatedFarmer);
    }


    public void deleteFarmer(Long id) {
        Farmer farmer = farmerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));
        farmerRepository.delete(farmer);
    }

    private Farmer mapToEntity(FarmerDTO dto) {
        Farmer farmer = new Farmer();
        farmer.setId(dto.getId());
        farmer.setName(dto.getName());
        farmer.setMobileNumber(dto.getMobileNumber());
        farmer.setGmail(dto.getGmail());
        return farmer;
    }

    private FarmerDTO mapToDTO(Farmer farmer) {
        FarmerDTO dto = new FarmerDTO();
        dto.setId(farmer.getId());
        dto.setName(farmer.getName());
        dto.setMobileNumber(farmer.getMobileNumber());
        dto.setGmail(farmer.getGmail());
        return dto;
    }
}

