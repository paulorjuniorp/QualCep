package br.paulorjuniorp.testes;

import java.util.List;

import br.paulorjuniorp.entidades.Logradouro;
import br.paulorjuniorp.jdbc.LogradouroDao;

public class TesteConsultaLogradouro {

	public static void main(String[] args) {
		
		LogradouroDao dao = new LogradouroDao();
		List<Logradouro> logradouros = dao.pegaTodos();
		
		for (Logradouro logradouro : logradouros) {
			System.out.println("Nome: " + logradouro.getNome());
			System.out.println("Cep: " + logradouro.getCep());
			System.out.println("Logradouro: " + logradouro.getTipoLogradouro().getNome());
			System.out.println("Bairro: " + logradouro.getBairro().getNome());
			}

	}

}
