package br.gov.al.ce.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.gov.al.ce.model.Empresa;
import br.gov.al.ce.repository.Empresas;
import br.gov.al.ce.util.Transacional;

public class CadastroEmpresaService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Empresas empresas;
	
	@Transacional
	public void salvar(Empresa empresa) {
		 empresas.guardar(empresa);
	}
	
	@Transacional
	public void excluir(Empresa empresa) {
		empresas.remover(empresa);
	}
}
