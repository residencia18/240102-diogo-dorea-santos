package com.residenciatic18.PP002.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.residenciatic18.PP003.model.Paciente;

@SpringBootTest
public class PacienteTest {


    @Test
    public void testPaciente() {
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setNome("João");
        paciente.setEndereco("Rua ABC");
        paciente.setTelefone("1234567890");
        
        assertEquals(Long.valueOf(1L), paciente.getId());
        assertEquals("João", paciente.getNome());
        assertEquals("Rua ABC", paciente.getEndereco());
        assertEquals("1234567890", paciente.getTelefone());
    }

}
