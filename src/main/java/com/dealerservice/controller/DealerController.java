package com.dealerservice.controller;

import com.dealerservice.dto.DealerDTO;
import com.dealerservice.service.DealerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dealers")
public class DealerController {

    private DealerService dealerService;


    public DealerController(DealerService dealerService) {
        this.dealerService = dealerService;
    }

    // http://localhost:9191/api/dealers/create
    @PostMapping(name = "create_dealer" , value = "/create")
    public ResponseEntity<DealerDTO> createDealer(@RequestBody DealerDTO dealerDTO){
        DealerDTO savedDealer = dealerService.createDealer(dealerDTO);
        return new ResponseEntity<>(savedDealer , HttpStatus.CREATED);
    }

    // http://localhost:9191/api/dealers/1
    @GetMapping(name = "get_dealer_by_id" , value = "/{id}")
    public ResponseEntity<DealerDTO> getDealerById(@PathVariable Long id){
        DealerDTO dealerDTO = dealerService.getDealerById(id);
        return ResponseEntity.ok(dealerDTO);
    }

    // http://localhost:9191/api/dealers/all
    @GetMapping(name = "get_all_dealers" , value = "/all")
    public ResponseEntity<List<DealerDTO>> getAllDealers(){
        List<DealerDTO> dealers = dealerService.getAllDealers();
        return ResponseEntity.ok(dealers);
    }


   // http://localhost:9191/api/dealers/update/1
    @PutMapping(name = "update_dealer" , value = "/update/{id}")
    public ResponseEntity<DealerDTO> updateDealer(
            @PathVariable Long id ,
            @RequestBody DealerDTO dealerDTO) {
        DealerDTO updatedDealer = dealerService.updateDealer(id , dealerDTO);
        return ResponseEntity.ok(updatedDealer);
    }

    // http://localhost:9191/api/dealers/delete/1
    @DeleteMapping(name = "delete_farmer" , value = "/delete/{id}")
    public ResponseEntity<String> deleteDealer(@PathVariable Long id){
        dealerService.deleteDealer(id);
        return null;
    }
}
