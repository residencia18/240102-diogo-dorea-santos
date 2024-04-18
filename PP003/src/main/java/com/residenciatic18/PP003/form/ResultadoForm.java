package com.residenciatic18.PP003.form;

import org.springframework.beans.factory.annotation.Autowired;

import com.residenciatic18.PP003.model.Resultado;
import com.residenciatic18.PP003.repository.PacienteRepository;

public class ResultadoForm {
	
	@Autowired
	private PacienteRepository pacienteRepository; 
	
	private String nomeExame;
	//Retirar o paciente inteiro e receber só o ID
	//private Paciente paciente;

	private Long idPaciente;
		
	public Long getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNomeExame() {
		return nomeExame;
	}
	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}

	/*	
	public ResultadoForm(Paciente paciente, String _nomeExame) {
		super();
		this.paciente = paciente;
		this.nomeExame = _nomeExame;
	}
	*/
	public ResultadoForm(Long _idPaciente, String _nomeExame) {
		super();
		this.idPaciente = _idPaciente;
		this.nomeExame = _nomeExame;
	}

	public ResultadoForm() {
		super();
	}

	public Resultado toModel() {
		return new Resultado(pacienteRepository.findById(idPaciente).get(), nomeExame);
	}
}
