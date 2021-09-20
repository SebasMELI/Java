package com.mercadolibre.demo_app_sebas.beans;

import com.mercadolibre.demo_app_sebas.dtos.SampleDTO;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class RandomSampleBean {
	private Random random = new Random();

	public SampleDTO random() {
		return new SampleDTO(random.nextInt(Integer.MAX_VALUE));
	}
}

