package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class TestStudentService {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    static Long longId;
    static StudentDTO studentDTO;

    @BeforeAll
    static void initilize(){
        longId = Integer.toUnsignedLong(7);

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
    public void testAgregarAlumno(){
        this.studentService.create(studentDTO);
        Mockito.verify(this.studentDAO, Mockito.atLeast(1)).save(studentDTO);
    }

    @Test
    public void testBuscarAlumnoPorId(){
        Mockito.when(this.studentDAO.findById(longId)).thenReturn(studentDTO);
        StudentDTO student = this.studentService.read(longId);
        Mockito.verify(this.studentDAO, Mockito.atLeast(1)).findById(longId);
        Assertions.assertEquals(student, studentDTO);
    }

    @Test
    public void testModificarDatosAlumno(){
        this.studentService.update(studentDTO);
        Mockito.verify(this.studentDAO, Mockito.atLeast(1)).save(studentDTO);
    }

    @Test
    public void testEliminarAlumno(){
        this.studentService.delete(longId);
        Mockito.verify(this.studentDAO, Mockito.atLeast(1)).delete(longId);
    }

    @Test
    //Tener el cuenta este
    public void testBuscarAlumnoPorIdThrows(){
        Long longer = Integer.toUnsignedLong(-1);
        Mockito.when(this.studentDAO.findById(longer)).thenThrow(StudentNotFoundException.class);
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(longer));
        Mockito.verify(this.studentDAO, Mockito.atLeast(1)).findById(longer);
    }

    @Test
    public void testListarAlumnos(){
        Set<StudentDTO> students = this.studentService.getAll();
        Mockito.verify(this.studentRepository, Mockito.atLeast(1)).findAll();
        Assertions.assertNotNull(students);
    }

}
