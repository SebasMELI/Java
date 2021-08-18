package com.bootcamp.desafiotesting.integration;

import com.bootcamp.desafiotesting.dtos.BarrioDTO;
import com.bootcamp.desafiotesting.dtos.CuartoDTO;
import com.bootcamp.desafiotesting.dtos.PropiedadRequestDTO;
import com.bootcamp.desafiotesting.model.BarrioModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    private List<BarrioModel> barrioModels;
    private static BarrioModel barrioModel1;
    private static BarrioModel barrioModel2;

    private static PropiedadRequestDTO requestDTO;
    private static List<CuartoDTO> rooms;
    private static CuartoDTO cuarto1;
    private static CuartoDTO cuarto2;
    private static CuartoDTO cuarto3;

    @BeforeEach
    private void init(){
        objectMapper = new ObjectMapper();
        rooms = new ArrayList<>();
        barrioModels = new ArrayList<>();

        barrioModel1 = new BarrioModel();
        barrioModel1.setName("Palermo");
        barrioModel1.setArea(87373.0);
        barrioModel1.setPrice(1200.0);

        barrioModel2 = new BarrioModel();
        barrioModel1.setName("Belgrano");
        barrioModel1.setArea(1.0);
        barrioModel1.setPrice(100.0);

        barrioModels.add(barrioModel1);
        barrioModels.add(barrioModel2);

        cuarto1 = CuartoDTO.builder()
                .room_name("Sala")
                .room_width(17.1)
                .room_length(7.9)
                .build();

        cuarto2 = CuartoDTO.builder()
                .room_name("Cocina")
                .room_width(7.2)
                .room_length(13.3)
                .build();

        cuarto3 = CuartoDTO.builder()
                .room_name("Cuarto Normal")
                .room_width(15.5)
                .room_length(15.0)
                .build();

        rooms.add(cuarto1);
        rooms.add(cuarto2);
        rooms.add(cuarto3);

        requestDTO = PropiedadRequestDTO.builder()
                .prop_name("Mi rancho")
                .prop_land_width(34.1)
                .prop_land_length(87.8)
                .district_name("Palermo")
                .district_built_price(2580)
                .district_unbuilt_price(255)
                .rooms(rooms)
                .build();


    }

    @Test
    public void testTotalMetrosCuadradosPropiedad() throws Exception {
        String jsonValue = this.objectMapper.writeValueAsString(requestDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/totalMetrosCuadradosPropiedad")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonValue))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.prop_total_prop").value(1440.76));
    }

    @Test
    public void testTotalMetrosCuadradosPropiedadException() throws Exception {
        cuarto3.setRoom_width(25.5);
        String jsonValue = this.objectMapper.writeValueAsString(requestDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/totalMetrosCuadradosPropiedad")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonValue))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("MethodArgumentNotValidException"));
    }

    @Test
    public void testTotalSuperficieSinConstruccion() throws Exception {
        String jsonValue = this.objectMapper.writeValueAsString(requestDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/totalSuperficieSinConstruccion")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonValue))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.terreno_faltante").value(85932.24));
    }

    @Test
    public void testTotalSuperficieSinConstruccionException() throws Exception {
        requestDTO.setDistrict_name("Belgrano");
        String jsonValue = this.objectMapper.writeValueAsString(requestDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/totalSuperficieSinConstruccion")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonValue))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("ExededException"));
    }

    @Test
    public void testPrecioPropiedad() throws Exception {
        String jsonValue = this.objectMapper.writeValueAsString(requestDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/precioPropiedad")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonValue))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.precio_terreno").value(3717160.8));
    }

    @Test
    public void testPrecioPropiedadException() throws Exception {
        String jsonValue = this.objectMapper.writeValueAsString("{requestDTO}");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/precioPropiedad")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonValue))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("HttpMessageNotReadableException"));
    }

    @Test
    public void testCuartoMasGrande() throws Exception {
        String jsonValue = this.objectMapper.writeValueAsString(requestDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/cuartoMasGrande")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonValue))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.room_name").value("Cuarto Normal"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.room_width").value(15.5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.room_length").value(15.0));
    }

    @Test
    public void testCuartoMasGrandeException() throws Exception {
        requestDTO.getRooms().remove(cuarto3);
        cuarto3.setRoom_width(25.5);
        requestDTO.getRooms().add(cuarto3);
        String jsonValue = this.objectMapper.writeValueAsString(requestDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/cuartoMasGrande")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonValue))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("MethodArgumentNotValidException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El máximo ancho permitido por propiedad es de 25 mts."));
    }

    @Test
    public void testMetrosPorCuarto() throws Exception {
        String jsonValue = this.objectMapper.writeValueAsString(requestDTO);
        MvcResult result =  this.mockMvc.perform(MockMvcRequestBuilders.post("/metrosPorCuarto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonValue))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Assertions.assertNotNull(this.objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<CuartoDTO>>(){}));
    }

    @Test
    public void testGetBarrios() throws Exception {
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/getBarrios"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Assertions.assertNotNull(this.objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<BarrioDTO>>(){}));
    }

    @Test
    public void testGetBarrioPorNombre() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/getBarrioPorNombre/{nombre}","Centro"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Centro"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.area").value(5555.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(500.0));
    }

    @Test
    public void testGetBarrioPorNombreException() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/getBarrioPorNombre/{nombre}","Anaroima"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("NoSuchBarrioException"));
    }

}
