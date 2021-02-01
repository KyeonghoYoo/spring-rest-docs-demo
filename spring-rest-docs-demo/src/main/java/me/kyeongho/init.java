package me.kyeongho;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import me.kyeongho.domain.Sample;
import me.kyeongho.service.SampleRepository;

@Component
@RequiredArgsConstructor
public class init {
	
	private final SampleRepository sampleRepository;
	
	@PostConstruct
	public void init() {
		for (int i = 1; i <= 100 ; i++) {
			sampleRepository.save(new Sample("sample" + i));
		}
	}
	
}
