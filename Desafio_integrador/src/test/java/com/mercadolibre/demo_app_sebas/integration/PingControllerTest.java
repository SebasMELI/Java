package com.mercadolibre.demo_app_sebas.integration;

import com.mercadolibre.demo_app_sebas.controller.PingController;
import com.mercadolibre.demo_app_sebas.dtos.NormalDataDTO;
import com.mercadolibre.demo_app_sebas.dtos.SampleDTO;
import com.mercadolibre.demo_app_sebas.repository.InsertarYConsultarRepository;
import com.mercadolibre.demo_app_sebas.service.PingService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PingControllerTest extends ControllerTest {

	@Mock
	private InsertarYConsultarRepository repository;
	@InjectMocks
	private PingService pingService;
	private PingController pingController;

	@Test
	void ping() {
		ResponseEntity<String> responseEntity = this.testRestTemplate.exchange("/ping", HttpMethod.GET, this.getDefaultRequestEntity(), String.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("pong", responseEntity.getBody());
	}

	@Test
	void insertTest(){
		/*ResponseEntity<NormalDataDTO> responseEntity = this.testRestTemplate
				.exchange("/test", HttpMethod.POST, this.getDefaultRequestEntity(), NormalDataDTO.class);*/

		NormalDataDTO dataDTO = NormalDataDTO.builder().id(1).name("Holi").date(new Date()).build();

		Mockito.when(this.repository.save(dataDTO)).thenReturn(dataDTO);
		pingService.insertarYConsultar(dataDTO);
		Mockito.verify(this.repository, Mockito.atLeast(1)).save(dataDTO);

		pingService.consultar(1);

		SampleDTO sampleDTO = new SampleDTO();
		sampleDTO.setRandom(123);


		assertNotNull(dataDTO);
		assertNotNull(dataDTO.getId());
		assertNotNull(dataDTO.getName());
		assertNotNull(dataDTO.getDate());


		/*NormalDataDTO normalDataDTO = this.pingService.insertarYConsultar(NormalDataDTO.builder().id(1).name("Holi").build());
		Mockito.verify(this.pingService).insertarYConsultar();

		assertNotNull(responseEntity);
		assertNotNull(normalDataDTO);*/
		//this.pingController.insertarYConsultar(NormalDataDTO.builder().id(1).name("Holi").build());

	}
}
