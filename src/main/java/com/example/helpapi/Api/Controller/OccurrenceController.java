package com.example.helpapi.Api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.helpapi.Domain.Commands.CustomerCommands.Outputs.OccurrenceMapsTO;
import com.example.helpapi.Domain.Models.Customer;
import com.example.helpapi.Domain.Models.Occurrence;
import com.example.helpapi.Domain.Services.CustomerService;
import com.example.helpapi.Domain.Services.OccurrenceService;

@RestController
@RequestMapping("api/Occurrence")
public class OccurrenceController {
	
	@Autowired
	OccurrenceService service;
	
	@Autowired
	CustomerService customerService;

	@GetMapping("GetAllOccurrence")
	public List<Occurrence> getOccurrence(){
		return service.findAll();
	}
	@GetMapping("GetOccurrenceMaps")
	public List<OccurrenceMapsTO> getOccurrenceMaps(){
		return service.findAllMaps();
	}
	
	@PostMapping("/PostOccurrence")
	public Occurrence postOccurrence(@RequestBody Occurrence occurrence,UriComponentsBuilder builder) {
		occurrence.setCustomer(customerService.getThisUser());
		return service.register(occurrence);
	}
	
}
