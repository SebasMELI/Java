package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class TestRepository {

    private static Long longId;
    private static StudentDTO studentDTO;

    @BeforeAll
    public static void initilize(){
        longId = Integer.toUnsignedLong(19);
        studentDTO = new StudentDTO();
        List<SubjectDTO> dtoList = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("mate");
        subjectDTO.setScore(8.1);
        dtoList.add(subjectDTO);

        studentDTO.setStudentName("Juan");
        studentDTO.setAverageScore(8.2);
        studentDTO.setId(Integer.toUnsignedLong(8));
        studentDTO.setMessage("Bien");
        studentDTO.setSubjects(dtoList);
    }

    @Test
    public void testAgregarAlumno(){
        StudentDAO studentDAO = new StudentDAO();

        studentDAO.save(studentDTO);

        Assertions.assertNotNull(studentDTO);
    }

    @Test
    public void testModificarDatosAlumno(){
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.save(studentDTO);
        Assertions.assertNotNull(studentDTO);
    }

    @Test
    public void testEliminarAlumno(){
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.delete(longId);
        Assertions.assertNotNull(studentDTO);
    }

    @Test
    public void testListarAlumnos(){
        StudentRepository studentRepository = new StudentRepository();
        Set<StudentDTO> student = studentRepository.findAll();
        Assertions.assertNotNull(student);
    }

    @Test
    public void testExist(){
        StudentDAO studentDAO = new StudentDAO();
        Assertions.assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    public void testNotExist(){
        Long longer = Integer.toUnsignedLong(-1);
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO dto = new StudentDTO();
        dto.setId(longer);
        Assertions.assertFalse(studentDAO.exists(dto));
    }

    @Test
    public void testBuscarAlumnoPorIdThrows(){
        Long longer = Integer.toUnsignedLong(-5);
        StudentDAO studentDAO = new StudentDAO();
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(longer));
    }
}
