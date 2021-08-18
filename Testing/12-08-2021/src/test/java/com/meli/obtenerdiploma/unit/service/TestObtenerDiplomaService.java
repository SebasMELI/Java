package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestObtenerDiplomaService {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    private static Long longId;
    private static StudentDTO studentDTO;

    @BeforeAll
    public static void initilize(){
        longId = Integer.toUnsignedLong(5);

        studentDTO = new StudentDTO();
        List<SubjectDTO> dtoList = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("mate");
        subjectDTO.setScore(8.1);
        dtoList.add(subjectDTO);

        studentDTO.setStudentName("Juan");
        studentDTO.setAverageScore(8.2);
        studentDTO.setId(longId);
        studentDTO.setMessage("Bien");
        studentDTO.setSubjects(dtoList);
    }

    @Test
    public void testAnalyzeScores(){
        Mockito.when(this.studentDAO.findById(longId)).thenReturn(studentDTO);
        StudentDTO student = this.obtenerDiplomaService.analyzeScores(longId);
        Mockito.verify(this.studentDAO, Mockito.atLeast(1)).findById(longId);
        Assertions.assertNotNull(student);
        Assertions.assertEquals(student, studentDTO);
    }

}
