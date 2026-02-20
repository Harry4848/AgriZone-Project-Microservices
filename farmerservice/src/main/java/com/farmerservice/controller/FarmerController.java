package com.farmerservice.controller;

import com.farmerservice.dto.FarmerDTO;
import com.farmerservice.service.FarmerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farmers")
// http://localhost:9191/api/farmers
public class FarmerController {

    private FarmerService farmerService;

    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    // http://localhost:9191/api/farmers/create
    @PostMapping(name = "create_farmer", value = "/create")
    public ResponseEntity<FarmerDTO> createFarmer(@RequestBody FarmerDTO farmerDTO) {
        FarmerDTO savedFarmer = farmerService.createFarmer(farmerDTO);
        return new ResponseEntity<>(savedFarmer, HttpStatus.CREATED);
    }

    // http://localhost:9191/api/farmers/1
    @GetMapping(name = "get_farmer_by_id", value = "/{id}")
    public ResponseEntity<FarmerDTO> getFarmerById(@PathVariable Long id) {
        FarmerDTO farmerDTO = farmerService.getFarmerById(id);
        return ResponseEntity.ok(farmerDTO);
    }

    // http://localhost:9191/api/farmers/all
    @GetMapping(name = "get_all_farmers", value = "/all")
    public ResponseEntity<List<FarmerDTO>> getAllFarmers() {
        List<FarmerDTO> farmers = farmerService.getAllFarmers();
        return ResponseEntity.ok(farmers);
    }

    // http://localhost:9191/api/farmers/update/1
    @PutMapping(name = "update_farmer", value = "/update/{id}")
    public ResponseEntity<FarmerDTO> updateFarmer(
            @PathVariable Long id,
            @RequestBody FarmerDTO farmerDTO) {

        FarmerDTO updatedFarmer = farmerService.updateFarmer(id, farmerDTO);
        return ResponseEntity.ok(updatedFarmer);
    }

    // http://localhost:9191/api/farmers/delete/1
    @DeleteMapping(name = "delete_farmer", value = "/delete/{id}")
    public ResponseEntity<String> deleteFarmer(@PathVariable Long id) {
        farmerService.deleteFarmer(id);
        return ResponseEntity.ok("Farmer deleted successfully");
    }
}