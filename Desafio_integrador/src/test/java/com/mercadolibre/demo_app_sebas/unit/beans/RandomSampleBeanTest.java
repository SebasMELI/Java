package com.mercadolibre.demo_app_sebas.unit.beans;

import com.mercadolibre.demo_app_sebas.dtos.SampleDTO;
import com.mercadolibre.demo_app_sebas.beans.RandomSampleBean;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomSampleBeanTest {

	@Test
	public void randomPositiveTestOK() {
		RandomSampleBean randomSample = new RandomSampleBean();

		SampleDTO sample = randomSample.random();
		
		assertTrue(sample.getRandom() >= 0);
	}
}
