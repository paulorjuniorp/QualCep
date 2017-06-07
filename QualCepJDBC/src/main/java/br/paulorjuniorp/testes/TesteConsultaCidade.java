package br.paulorjuniorp.testes;

import java.util.ArrayList;
import java.util.List;

import br.paulorjuniorp.entidades.Cidade;
import br.paulorjuniorp.jdbc.CidadeDao;

public class TesteConsultaCidade {

	public static void main(String[] args) {
		
		CidadeDao cidades = new CidadeDao();
		
		List<Cidade> listCidades = new ArrayList<Cidade>();
		
		listCidades = cidades.getCidade();
		
		for(int a = 0 ; a< listCidades.size(); a++){
			System.out.println(listCidades.get(a));
		}

	}

}
