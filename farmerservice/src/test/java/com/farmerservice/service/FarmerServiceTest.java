package com.farmerservice.service;

import com.farmerservice.dto.FarmerDTO;
import com.farmerservice.entity.Farmer;
import com.farmerservice.repository.FarmerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;

class FarmerServiceTest {
    @Mock
    private FarmerRepository farmerRepository;

    @InjectMocks
    private FarmerService farmerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // ---------------- CREATE FARMER ----------------
    @Test
    void testCreateFarmer() {

        FarmerDTO dto = new FarmerDTO();
        dto.setId(1L);
        dto.setName("Ramesh");
        dto.setMobileNumber("9999999999");
        dto.setGmail("ramesh@gmail.com");

        Farmer saved = new Farmer();
        saved.setId(1L);
        saved.setName("Ramesh");
        saved.setMobileNumber("9999999999");
        saved.setGmail("ramesh@gmail.com");

        when(farmerRepository.save(any(Farmer.class))).thenReturn(saved);

        FarmerDTO result = farmerService.createFarmer(dto);

        assertNotNull(result);
        assertEquals("Ramesh", result.getName());
        verify(farmerRepository, times(1)).save(any(Farmer.class));
    }

    // ---------------- GET BY ID SUCCESS ----------------
    @Test
    void testGetFarmerById_Success() {

        Farmer farmer = new Farmer();
        farmer.setId(1L);
        farmer.setName("Suresh");

        when(farmerRepository.findById(1L)).thenReturn(Optional.of(farmer));

        FarmerDTO result = farmerService.getFarmerById(1L);

        assertEquals("Suresh", result.getName());
    }

    // ---------------- GET BY ID EXCEPTION ----------------
    @Test
    void testGetFarmerById_NotFound() {

        when(farmerRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> farmerService.getFarmerById(1L));

        assertEquals("Farmer Not Found", ex.getMessage());
    }

    // ---------------- GET ALL ----------------
    @Test
    void testGetAllFarmers() {

        Farmer f1 = new Farmer();
        f1.setId(1L);
        f1.setName("Ramesh");

        Farmer f2 = new Farmer();
        f2.setId(2L);
        f2.setName("Suresh");

        when(farmerRepository.findAll()).thenReturn(Arrays.asList(f1, f2));

        List<FarmerDTO> result = farmerService.getAllFarmers();

        assertEquals(2, result.size());
        assertEquals("Ramesh", result.get(0).getName());
    }

    // ---------------- UPDATE SUCCESS ----------------
    @Test
    void testUpdateFarmer_Success() {

        Farmer existing = new Farmer();
        existing.setId(1L);
        existing.setName("Old");

        FarmerDTO dto = new FarmerDTO();
        dto.setName("New Name");
        dto.setMobileNumber("8888888888");
        dto.setGmail("new@gmail.com");

        when(farmerRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(farmerRepository.save(any(Farmer.class))).thenReturn(existing);

        FarmerDTO result = farmerService.updateFarmer(1L, dto);

        assertEquals("New Name", result.getName());
    }

    // ---------------- UPDATE EXCEPTION ----------------
    @Test
    void testUpdateFarmer_NotFound() {

        when(farmerRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> farmerService.updateFarmer(1L, new FarmerDTO()));

        assertEquals("Farmer not found", ex.getMessage());
    }

    // ---------------- DELETE SUCCESS ----------------
    @Test
    void testDeleteFarmer_Success() {

        Farmer farmer = new Farmer();
        farmer.setId(1L);

        when(farmerRepository.findById(1L)).thenReturn(Optional.of(farmer));

        farmerService.deleteFarmer(1L);

        verify(farmerRepository).delete(farmer);
    }

    // ---------------- DELETE EXCEPTION ----------------
    @Test
    void testDeleteFarmer_NotFound() {

        when(farmerRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> farmerService.deleteFarmer(1L));

        assertEquals("Farmer not found", ex.getMessage());
    }
}