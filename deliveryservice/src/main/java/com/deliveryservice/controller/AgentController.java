package com.deliveryservice.controller;

import com.deliveryservice.dto.AgentDto;
import com.deliveryservice.service.AgentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agents")
// http://localhost:9191/api/agents
public class AgentController {

    private AgentService agentService;


    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    // http://localhost:9393/api/agents/create
    @PostMapping(name ="create_agent" , value = "/create")
    public ResponseEntity<AgentDto> createAgent(@RequestBody AgentDto agentDto){
        AgentDto savedAgent = agentService.createAgent(agentDto);
        return new ResponseEntity<>(savedAgent , HttpStatus.CREATED);
    }

    // http://localhost:9393/api/agents/1
    @GetMapping(name = "get_agent_by_id" , value = "/{id}")
    public ResponseEntity<AgentDto> getAgentById(@PathVariable Long id){
        AgentDto agentDto = agentService.getAgentById(id);
        return ResponseEntity.ok(agentDto);
    }

    // http://localhost:9393/api/agents/all
    @GetMapping(name = "get_all_agents" , value = "/all")
    public ResponseEntity<List<AgentDto>> getAllAgents(){
        List<AgentDto> agents = agentService.getAllAgents();
        return ResponseEntity.ok(agents);
    }

    // http://localhost:9393/api/agents/update/1
    @PutMapping(name = "update_agent" , value = "/update/{id}")
    public ResponseEntity<AgentDto> updateAgent(
            @PathVariable Long id,
            @RequestBody AgentDto agentDto){

        AgentDto updatedAgent = agentService.updateAgent(id , agentDto);
        return ResponseEntity.ok(updatedAgent);
    }

    // http://localhost:9393/api/agents/delete/1
    @DeleteMapping(name = "delete_agent" , value = "/delete/{id}")
    public ResponseEntity<String> deleteAgent(@PathVariable Long id){
        agentService.deleteAgent(id);
        return ResponseEntity.ok("Agent deleted successfully");
    }
}
