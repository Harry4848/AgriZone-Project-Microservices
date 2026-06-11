package com.dealerservice.controller;

import com.dealerservice.dto.DealerDTO;
import com.dealerservice.service.DealerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DealerController.class)
class DealerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DealerService dealerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateDealer() throws Exception {
        DealerDTO dealerDTO = new DealerDTO();
        dealerDTO.setId(1L);
        dealerDTO.setName("Shubhankar");
        dealerDTO.setMobileNumber("2389493785");
        dealerDTO.setEmail("Shubhankar@gmail.com");

        when(dealerService.createDealer(any(DealerDTO.class)))
                .thenReturn(dealerDTO);

        mockMvc.perform(post("/api/dealers/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dealerDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Shubhankar"))
                .andExpect(jsonPath("$.mobileNumber").value("2389493785"))
                .andExpect(jsonPath("$.email").value("Shubhankar@gmail.com"));
    }

    @Test
    void testGetDealerById() throws Exception {
        DealerDTO dealerDTO = new DealerDTO();
        dealerDTO.setId(1L);
        dealerDTO.setName("Hariom");
        dealerDTO.setMobileNumber("8103696982");
        dealerDTO.setEmail("Harry@gmail.com");

        when(dealerService.getDealerById(anyLong()))
                .thenReturn(dealerDTO);

        mockMvc.perform(get("/api/dealers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Hariom"))
                .andExpect(jsonPath("$.mobileNumber").value("8103696982"))
                .andExpect(jsonPath("$.email").value("Harry@gmail.com"));
    }

    @Test
    void testGetAllDealers() throws Exception{
        DealerDTO dealerDTO1 = new DealerDTO();
        dealerDTO1.setId(1L);
        dealerDTO1.setName("Shubhankar");
        dealerDTO1.setMobileNumber("2389493785");
        dealerDTO1.setEmail("Shubhankar@gmail.com");

        DealerDTO dealerDTO2 = new DealerDTO();
        dealerDTO2.setId(1L);
        dealerDTO2.setName("Hariom");
        dealerDTO2.setMobileNumber("8103696982");
        dealerDTO2.setEmail("Harry@gmail.com");

        List<DealerDTO> dealerDTOList = Arrays.asList(dealerDTO1, dealerDTO2);

        when(dealerService.getAllDealers())
                .thenReturn(dealerDTOList);

        mockMvc.perform(get("/api/dealers/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Shubhankar"))
                .andExpect(jsonPath("$[1].name").value("Hariom"));
    }
}