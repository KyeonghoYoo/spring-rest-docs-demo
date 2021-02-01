package me.kyeongho.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.kyeongho.domain.Sample;
import me.kyeongho.service.SampleService;

@RestController
@RequiredArgsConstructor
public class SampleController {
	
	private final SampleService sampleService;
	
	@GetMapping("/api/sample")
	public List<Sample> getSamples() {
		return sampleService.getSamples();
	}
	
	@GetMapping("/api/sample/{id}")
	public Sample getSampleById(@PathVariable("id") Long id) {
		return sampleService.getSampleById(id);
	}
	
	@PostMapping("/api/sample")
	public Sample postSample(@RequestParam("name") String name) {
		return sampleService.postSample(name);
	}
	
	@PutMapping("/api/sample/{id}")
	public Sample putSample(@PathVariable("id") Long id, @RequestParam("name") String name) {
		return sampleService.putSample(id, name);
	}
	
	@DeleteMapping("/api/sample/{id}")
	public String deleteSample(@PathVariable("id") Long id) {
		try {
			sampleService.deleteSample(id);
		} catch (Exception e) {
			throw new IllegalStateException();
		}
		return "done";
	}
}
