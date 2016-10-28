package br.com.candystore;

import br.com.candystore.persistencia.entidades.Usuario;
import br.com.candystore.persistencia.jdbc.UsuarioDAO;

public class testUsuarioDAO {
	public static void main(String[] args) {
		testExcluir();
	}

	public static void testCadastrar() {

		Usuario usuario = new Usuario();
		usuario.setNome("Natalicio");
		usuario.setLogin("licio");
		usuario.setSenha("licio");
		usuario.setTipo("Administrador");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrar(usuario);

		System.out.println("Usuario cadastrado com sucesso!!!");
	}

	public static void testAlterar() {
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
	
	public static void testExcluir() {
		Usuario usuario = new Usuario();
		usuario.setId(5);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.excluir(usuario);

		System.out.println("Usuario excluido com sucesso!!!");
	}
}
