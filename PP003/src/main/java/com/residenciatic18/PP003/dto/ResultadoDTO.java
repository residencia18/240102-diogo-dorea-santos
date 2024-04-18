package com.residenciatic18.PP003.dto;
import com.residenciatic18.PP003.model.Paciente;
import com.residenciatic18.PP003.model.Resultado;

public class ResultadoDTO {
    private Long id;
    private Paciente paciente;
	private String nomeExame;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}

	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public ResultadoDTO(Resultado resultado) {
		super();
		this.id = resultado.getId();
		this.nomeExame = resultado.getNomeExame();
		this.paciente = resultado.getPaciente();
	}

    public ResultadoDTO() {
        super();
    }
}
