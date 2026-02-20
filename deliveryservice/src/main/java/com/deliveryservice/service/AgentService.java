package com.deliveryservice.service;

import com.deliveryservice.dto.AgentDto;
import com.deliveryservice.entity.Agent;
import com.deliveryservice.repository.AgentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AgentService {

    private AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }


    public AgentDto createAgent(AgentDto agentDto) {
        Agent agent = mapToEntity(agentDto);
        Agent savedAgent = agentRepository.save(agent);
        return mapToDTO(savedAgent);
    }

    public AgentDto getAgentById(Long id) {
        Agent agent = agentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agent Not Found"));
        return mapToDTO(agent);
    }


    public List<AgentDto> getAllAgents() {
        return agentRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public AgentDto updateAgent(Long id, AgentDto agentDto) {
        Optional<Agent> agent = Optional.ofNullable(agentRepository.findById(id).orElseThrow(RuntimeException::new));
        agent.get().setId(agentDto.getId());
        agent.get().setName(agentDto.getName());
        return agentDto;
    }


    public void deleteAgent(Long id) {
        Agent agent = agentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Agent Not Found"));
        agentRepository.delete(agent);
    }

    private Agent mapToEntity(AgentDto dto){
        Agent agent = new Agent();
        agent.setId(dto.getId());
        agent.setName(dto.getName());
        agent.setMobileNumber(dto.getMobileNumber());
        agent.setEmail(dto.getEmail());
        return agent;
    }
    
    private AgentDto mapToDTO(Agent agent){
        AgentDto dto = new AgentDto();
        dto.setId(agent.getId());
        dto.setName(agent.getName());
        dto.setMobileNumber(agent.getMobileNumber());
        dto.setEmail(agent.getEmail());
        return dto;
    }



}
