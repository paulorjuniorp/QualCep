package br.paulorjuniorp.testes;

import java.util.List;

import br.paulorjuniorp.entidades.Bairro;
import br.paulorjuniorp.entidades.Cidade;
import br.paulorjuniorp.entidades.Estado;
import br.paulorjuniorp.jdbc.BairroDao;
import br.paulorjuniorp.jdbc.CidadeDao;
import br.paulorjuniorp.jdbc.EstadoDao;

public class TesteConsultaEstado {

	public static void main(String[] args) {
		
		EstadoDao dao = new EstadoDao();
		List<Estado> estados = dao.pegaTodos();
		
		for (Estado estado : estados) {
			System.out.println("id: " + estado.getId());
			System.out.println("Uf: " + estado.getUf());
			System.out.println("Nome: " + estado.getNome());
			}
		
	}

}
