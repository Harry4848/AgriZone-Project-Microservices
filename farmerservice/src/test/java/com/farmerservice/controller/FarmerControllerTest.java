package com.farmerservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.farmerservice.dto.FarmerDTO;
import com.farmerservice.service.FarmerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FarmerController.class)
class FarmerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean  // 🔥 IMPORTANT (Spring context me inject hota hai)
    private FarmerService farmerService;

    @Autowired
    private ObjectMapper objectMapper;

    // ---------------- CREATE FARMER TEST ----------------
    @Test
    void testCreateFarmer() throws Exception { // if we dont handle exception there it will throw JsonProcessingException

        FarmerDTO farmerDTO = new FarmerDTO();
        farmerDTO.setId(1L);
        farmerDTO.setName("Ramesh");
        farmerDTO.setMobileNumber("903724733");

        when(farmerService.createFarmer(any(FarmerDTO.class)))
                .thenReturn(farmerDTO);

        mockMvc.perform(post("/api/farmers/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(farmerDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Ramesh"))
                .andExpect(jsonPath("$.mobileNumber").value("903724733"));
    }

    // ---------------- GET FARMER BY ID TEST ----------------
    @Test
    void testGetFarmerById() throws Exception {

        FarmerDTO farmerDTO = new FarmerDTO();
        farmerDTO.setId(1L);
        farmerDTO.setName("Suresh");
        farmerDTO.setMobileNumber("903700033");

        when(farmerService.getFarmerById(anyLong()))
                .thenReturn(farmerDTO);

        mockMvc.perform(get("/api/farmers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Suresh"))
                .andExpect(jsonPath("$.mobileNumber").value("903700033"));
    }

    // ---------------- GET ALL FARMERS TEST ----------------
    @Test
    void testGetAllFarmers() throws Exception {

        FarmerDTO farmer1 = new FarmerDTO();
        farmer1.setId(1L);
        farmer1.setName("Ramesh");
        farmer1.setMobileNumber("9022224733");

        FarmerDTO farmer2 = new FarmerDTO();
        farmer2.setId(2L);
        farmer2.setName("Suresh");
        farmer2.setMobileNumber("9024454733");

        List<FarmerDTO> farmerList = Arrays.asList(farmer1, farmer2);

        when(farmerService.getAllFarmers())
                .thenReturn(farmerList);

        mockMvc.perform(get("/api/farmers/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Ramesh"))
                .andExpect(jsonPath("$[1].name").value("Suresh"));
    }

    // ---------------- UPDATE FARMER TEST ----------------
    @Test
    void testUpdateFarmer() throws Exception {

        FarmerDTO farmerDTO = new FarmerDTO();
        farmerDTO.setId(1L);
        farmerDTO.setName("Updated Farmer");
        farmerDTO.setMobileNumber("9234424733");

        when(farmerService.updateFarmer(anyLong(), any(FarmerDTO.class)))
                .thenReturn(farmerDTO);

        mockMvc.perform(put("/api/farmers/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(farmerDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Updated Farmer"))
                .andExpect(jsonPath("$.mobileNumber").value("9234424733"));
    }

    // ---------------- DELETE FARMER TEST ----------------
    @Test
    void testDeleteFarmer() throws Exception {

        doNothing().when(farmerService).deleteFarmer(anyLong());

        mockMvc.perform(delete("/api/farmers/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Farmer deleted successfully"));
    }

}