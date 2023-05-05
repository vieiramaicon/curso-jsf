package br.gov.al.ce.repository;

import java.util.Date;
import java.util.List;

import br.gov.al.ce.model.Empresa;
import br.gov.al.ce.model.RamoAtividade;
import br.gov.al.ce.model.TipoEmpresa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CamadaPersistencia {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("curso-jsf");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Declarando repositórios
		RamoAtividades ramoAtividades = new RamoAtividades(em);
		Empresas empresas = new Empresas(em);
		
		//Buscando informações
		List<RamoAtividade> listaRamoAtividades = ramoAtividades.pesquisar("");
		List<Empresa> listaEmpresas = empresas.pesquisar("");
		System.out.println(listaEmpresas);
		
		//Criando uma empresa
		Empresa empresa = new Empresa();
		empresa.setNomeFantasia("João Silva");
		empresa.setCnpj("41.952.519/0001-57");
		empresa.setRazaoSocial("João da Silva 41952519000157");
		empresa.setTipo(TipoEmpresa.MEI);
		empresa.setDataFundacao(new Date());
		empresa.setRamoAtividade(listaRamoAtividades.get(0));
		
		//Salvando a empresa
		empresas.guardar(empresa);
		
		em.getTransaction().commit();
		
		//Verificando se funcionou
		List<Empresa> listaDeEmpresasPosAtualziacao = empresas.pesquisar("");
		System.out.println(listaDeEmpresasPosAtualziacao);
		
		em.close();
		emf.close();
	}
}
