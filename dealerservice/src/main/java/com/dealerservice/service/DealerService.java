package com.dealerservice.service;

import com.dealerservice.dto.DealerDTO;
import com.dealerservice.entity.Dealer;
import com.dealerservice.repository.DealerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DealerService {

    private DealerRepository dealerRepository;

    public DealerService(DealerRepository dealerRepository) {
        this.dealerRepository = dealerRepository;
    }

    public DealerDTO createDealer(DealerDTO dealerDTO) {
        Dealer dealer = mapToEntity(dealerDTO);
        Dealer savedDealer = dealerRepository.save(dealer);
        return mapToDTO(savedDealer);
    }


    public DealerDTO getDealerById(Long id) {
        Dealer dealer = dealerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dealer Not Found"));
        return mapToDTO(dealer);
    }

    public List<DealerDTO> getAllDealers() {
        return dealerRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public DealerDTO updateDealer(Long id, DealerDTO dealerDTO) {
        Dealer dealer = dealerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dealer Not Found"));

        dealer.setName(dealerDTO.getName());
        dealer.setMobileNumber(dealerDTO.getMobileNumber());
        dealer.setEmail(dealerDTO.getEmail());

        Dealer updatedDealer = dealerRepository.save(dealer);
        return mapToDTO(updatedDealer);
    }


    public void deleteDealer(Long id) {
        Dealer dealer = dealerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dealer Not Found"));
        dealerRepository.delete(dealer);
    }

    private Dealer mapToEntity(DealerDTO dto) {
        Dealer dealer = new Dealer();
        dealer.setId(dto.getId());
        dealer.setName(dto.getName());
        dealer.setMobileNumber(dto.getMobileNumber());
        dealer.setEmail(dto.getEmail());
        return dealer;
    }

    private DealerDTO mapToDTO(Dealer dealer) {
        DealerDTO dto = new DealerDTO();
        dto.setId(dealer.getId());
        dto.setName(dealer.getName());
        dto.setMobileNumber(dealer.getMobileNumber());
        dto.setEmail(dealer.getEmail());
        return dto;
    }



}
