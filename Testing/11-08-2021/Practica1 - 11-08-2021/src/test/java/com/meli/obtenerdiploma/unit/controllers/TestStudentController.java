package com.meli.obtenerdiploma.unit.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class TestStudentController {

    @Autowired
    private MockMvc mockMvc;

    static Long longId;
    static StudentDTO studentDTO;

    @BeforeAll
    static void initilize(){
        longId = Integer.toUnsignedLong(12);
        studentDTO = new StudentDTO();
        List<SubjectDTO> dtoList = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Mate");
        subjectDTO.setScore(8.1);
        dtoList.add(subjectDTO);

        studentDTO.setStudentName("Juan");
        studentDTO.setAverageScore(8.2);
        studentDTO.setId(Integer.toUnsignedLong(8));
        studentDTO.setMessage("Bien");
        studentDTO.setSubjects(dtoList);
    }

    @AfterEach
    void sendData(){
        longId = Integer.toUnsignedLong(12);
        studentDTO = new StudentDTO();
        List<SubjectDTO> dtoList = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Mate");
        subjectDTO.setScore(8.1);
        dtoList.add(subjectDTO);

        studentDTO.setStudentName("Juan");
        studentDTO.setAverageScore(8.2);
        studentDTO.setId(Integer.toUnsignedLong(8));
        studentDTO.setMessage("Bien");
        studentDTO.setSubjects(dtoList);
    }

    @Test
    public void testRegisterStudent() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonValue = objectMapper.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonValue))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRegisterStudentMethodArgumentNotValidException() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        studentDTO.setStudentName("juan");

        String jsonValue = objectMapper.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonValue))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));

    }

    @Test
    public void testRegisterStudentHttpMessageNotReadableException() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonValue = objectMapper.writeValueAsString("{studentDTO},");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonValue))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("HttpMessageNotReadableException"));
    }

    @Test
    public void testGetStudent() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"));
    }

    @Test
    public void testGetStudentNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 100))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"));
    }

    @Test
    public void testModifyStudent() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        studentDTO.setStudentName("Manuel");

        String jsonValue = objectMapper.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonValue))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testModifyStudentMethodArgumentNotValidException() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        studentDTO.setStudentName("anuel");

        String jsonValue = objectMapper.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonValue))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void testModifyStudentMHttpMessageNotReadableException() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonValue = objectMapper.writeValueAsString("{studentDTO},");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonValue))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("HttpMessageNotReadableException"));
    }

    @Test
    public void testRemoveStudent() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 12))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testListStudents() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
