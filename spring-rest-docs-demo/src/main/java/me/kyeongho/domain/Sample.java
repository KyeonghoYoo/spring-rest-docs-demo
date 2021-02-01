package me.kyeongho.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"name"})
public class Sample {

	@Id @GeneratedValue
	private Long id;
	
	private String name;

	public Sample(String name) {
		super();
		this.name = name;
	}
	
}
