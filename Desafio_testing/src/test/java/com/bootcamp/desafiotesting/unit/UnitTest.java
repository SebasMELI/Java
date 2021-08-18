package com.bootcamp.desafiotesting.unit;

import com.bootcamp.desafiotesting.dtos.CuartoDTO;
import com.bootcamp.desafiotesting.dtos.PropiedadRequestDTO;
import com.bootcamp.desafiotesting.dtos.PropiedadResponseDTO;
import com.bootcamp.desafiotesting.exception.ExededException;
import com.bootcamp.desafiotesting.exception.NoSuchBarrioException;
import com.bootcamp.desafiotesting.model.BarrioModel;
import com.bootcamp.desafiotesting.model.CuartoModel;
import com.bootcamp.desafiotesting.model.PropiedadModel;
import com.bootcamp.desafiotesting.repository.IPropiedadRepository;
import com.bootcamp.desafiotesting.service.PropiedadService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class UnitTest {

    @Mock
    private IPropiedadRepository propiedadRepository;

    @InjectMocks
    private PropiedadService propiedadService;

    private List<BarrioModel> barrioModels;
    private static BarrioModel barrioModel1;
    private static BarrioModel barrioModel2;

    private static PropiedadRequestDTO requestDTO;
    private static List<CuartoDTO> rooms;
    private static CuartoDTO cuarto1;
    private static CuartoDTO cuarto2;
    private static CuartoDTO cuarto3;

    private static CuartoModel cuarto4;
    private static CuartoModel cuarto5;
    private static CuartoModel cuarto6;

    private static CuartoModel cuartoTest;

    private static PropiedadResponseDTO propiedadResponseDTO;

    @BeforeEach
    private void init(){
        rooms = new ArrayList<>();
        barrioModels = new ArrayList<>();

        barrioModel1 = new BarrioModel();
        barrioModel1.setName("Belgrano");
        barrioModel1.setArea(1.0);
        barrioModel1.setPrice(100.0);

        barrioModel2 = new BarrioModel();
        barrioModel2.setName("Palermo");
        barrioModel2.setArea(87373.0);
        barrioModel2.setPrice(1200.0);

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
                .room_width(25.5)
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
                .rooms(rooms)
                .build();

        //-------------------------------------------------------------------------------//

        propiedadResponseDTO = new PropiedadResponseDTO();
        propiedadResponseDTO.setProp_name("Mi rancho");
        propiedadResponseDTO.setProp_total_prop(0.0);
        propiedadResponseDTO.setBarrio_name("Palermo");

        cuartoTest = new CuartoModel();
        cuartoTest.setRoom_name("Cuarto Normal");
        cuartoTest.setRoom_width(25.5);
        cuartoTest.setRoom_length(15.0);

        cuarto4 = new CuartoModel();
        cuarto4.setRoom_name("Sala");
        cuarto4.setRoom_width(17.1);
        cuarto4.setRoom_length(7.9);
        cuarto4.setCantidad_metros_cuadrados(135.09);

        cuarto5 = new CuartoModel();
        cuarto5.setRoom_name("Cocina");
        cuarto5.setRoom_width(7.2);
        cuarto5.setRoom_length(13.3);
        cuarto5.setCantidad_metros_cuadrados(95.76);

        cuarto6 = new CuartoModel();
        cuarto6.setRoom_name("Cuarto Normal");
        cuarto6.setRoom_width(25.5);
        cuarto6.setRoom_length(15.0);
        cuarto6.setCantidad_metros_cuadrados(382.5);

    }

    @Test
    public void testTotalSuperficieSinConstruccion() throws ExededException, NoSuchBarrioException {
        Mockito.when(propiedadRepository.getBarrioByName(requestDTO.getDistrict_name())).thenReturn(barrioModel2);
        PropiedadModel propiedadModel = propiedadService.totalSuperficieSinConstruccion(requestDTO);
        Mockito.verify(propiedadRepository, Mockito.atLeast(1)).getBarrioByName(requestDTO.getDistrict_name());
        Assertions.assertNotNull(propiedadModel);
    }

    @Test
    public void testTotalSuperficieSinConstruccionException() throws NoSuchBarrioException{
        requestDTO.setDistrict_name("Belgrano");
        Mockito.when(propiedadRepository.getBarrioByName(requestDTO.getDistrict_name())).thenReturn(barrioModel1);
        Assertions.assertThrows(ExededException.class, () -> propiedadService.totalSuperficieSinConstruccion(requestDTO));
        Mockito.verify(propiedadRepository, Mockito.atLeast(1)).getBarrioByName(requestDTO.getDistrict_name());
    }

    @Test
    public void testTotalSuperficieSinConstruccionCalculoCorrecto() throws NoSuchBarrioException, ExededException {
        Mockito.when(propiedadRepository.getBarrioByName(requestDTO.getDistrict_name())).thenReturn(barrioModel2);
        PropiedadModel propiedadModel = propiedadService.totalSuperficieSinConstruccion(requestDTO);
        Mockito.verify(propiedadRepository, Mockito.atLeast(1)).getBarrioByName(requestDTO.getDistrict_name());
        Assertions.assertEquals(propiedadModel.getTerreno_faltante(), 85570.24);
    }

    @Test
    public void testGetBarrioPorNombre() throws NoSuchBarrioException {
        Mockito.when(propiedadRepository.getBarrioByName(requestDTO.getDistrict_name())).thenReturn(barrioModel2);
        BarrioModel barrioModel = propiedadService.getBarrioPorNombre(requestDTO.getDistrict_name());
        Mockito.verify(propiedadRepository).getBarrioByName(requestDTO.getDistrict_name());
        Assertions.assertEquals(barrioModel.getName(), "Palermo");
        Assertions.assertEquals(barrioModel.getPrice(), 1200.0);
        Assertions.assertEquals(barrioModel.getArea(), 87373.0);
    }

    @Test
    public void testGetBarrioPorNombreException() throws NoSuchBarrioException {
        requestDTO.setDistrict_name("Ani");
        Mockito.when(propiedadRepository.getBarrioByName(requestDTO.getDistrict_name())).thenThrow(NoSuchBarrioException.class);
        Assertions.assertThrows(NoSuchBarrioException.class, () -> propiedadService.getBarrioPorNombre(requestDTO.getDistrict_name()));
        Mockito.verify(propiedadRepository).getBarrioByName(requestDTO.getDistrict_name());
    }

    @Test
    public void testCuartoMasGrande(){
        CuartoModel cuartoModel = propiedadService.cuartoMasGrande(requestDTO);
        Assertions.assertNotNull(cuartoModel);
        Assertions.assertEquals(cuartoTest, cuartoModel);
    }

    @Test
    public void testMetrosPorCuarto(){
        List<CuartoModel> cuartoModels = propiedadService.metrosPorCuarto(requestDTO);
        Assertions.assertNotNull(cuartoModels);
        Assertions.assertEquals(cuarto4.getCantidad_metros_cuadrados(), cuartoModels.get(0).getCantidad_metros_cuadrados());
        Assertions.assertEquals(cuarto5.getCantidad_metros_cuadrados(), cuartoModels.get(1).getCantidad_metros_cuadrados());
        Assertions.assertEquals(cuarto6.getCantidad_metros_cuadrados(), cuartoModels.get(2).getCantidad_metros_cuadrados());

    }
}
