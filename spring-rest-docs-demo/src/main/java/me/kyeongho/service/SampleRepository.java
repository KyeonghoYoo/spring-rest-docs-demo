package me.kyeongho.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import me.kyeongho.domain.Sample;

public interface SampleRepository extends JpaRepository<Sample, Long> {
	List<Sample> findByName(String name);
}
