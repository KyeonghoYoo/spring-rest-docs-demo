package me.kyeongho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import me.kyeongho.domain.Sample;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SampleService {

	private final SampleRepository sampleRepository;

	public List<Sample> getSamples() {
		return sampleRepository.findAll();
	}

	public Sample getSampleById(Long id) {
		Optional<Sample> result = sampleRepository.findById(id);
		return result.isPresent() ? result.get() : null;
	}

	@Transactional
	public Sample postSample(@RequestParam("name") String name) {
		return sampleRepository.save(new Sample(name));
	}

	@Transactional
	public Sample putSample(Long id, String name) {
		Optional<Sample> find = sampleRepository.findById(id);
		find.ifPresent(e -> {
			e.setName(name);
		});
		sampleRepository.flush();
		return find.isPresent() ? find.get() : null;
	}

	@Transactional
	public String deleteSample(Long id) {
		sampleRepository.deleteById(id);
		return "done";
	}
}
