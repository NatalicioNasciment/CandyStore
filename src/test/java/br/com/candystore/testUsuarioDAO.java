package br.com.candystore;

import br.com.candystore.persistencia.entidades.Usuario;
import br.com.candystore.persistencia.jdbc.UsuarioDAO;

public class testUsuarioDAO {
	public static void main(String[] args) {
		alterar();
	}

	public static void cadastrar() {

		Usuario usuario = new Usuario();
		usuario.setNome("Natalicio");
		usuario.setLogin("licio");
		usuario.setSenha("licio");
		usuario.setTipo("Administrador");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrar(usuario);

		System.out.println("Usuario cadastrado com sucesso!!!");
	}

	public static void alterar() {
		Usuario usuario = new Usuario();
		usuario.setId(2);
		usuario.setNome("Natalicio");
		usuario.setLogin("licio");
		usuario.setSenha("licio");
		usuario.setTipo("Administrador");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.alterar(usuario);

		System.out.println("Usuario alterado com sucesso!!!");
	}
}
