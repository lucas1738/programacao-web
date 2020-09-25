package br.com.unipe.aula.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.unipe.aula.web.model.Torcedor;

@Repository
public class TorcedorDAO {

	private static List<Torcedor> torcedores;

	public TorcedorDAO() {
		torcedores = new LinkedList<Torcedor>();
	}

	public void salvar(Torcedor torcedor) {
		torcedores.add(torcedor);
		torcedores.forEach(a -> {
			System.out.println(a.getNome());
			System.out.println(a.getTime());
			System.out.println(" ");
		});

	}

	public List<Torcedor> getAll() {
		return torcedores;
	}

}
