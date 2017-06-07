package br.paulorjuniorp.testes;

import java.util.List;

import br.paulorjuniorp.entidades.Bairro;
import br.paulorjuniorp.jdbc.BairroDao;

public class TesteConsultaBairro {

	public static void main(String[] args) {
		
		BairroDao dao = new BairroDao();
		List<Bairro> bairros = dao.pegaTodos();
		
		for (Bairro bairro: bairros) {
			System.out.println("Nome: " + bairro.getNome());
			System.out.println("Estado: " + bairro.getCidade().getNome());
			}
	}

	}
