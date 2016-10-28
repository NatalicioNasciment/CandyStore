package br.com.candystore;

import java.util.List;

import br.com.candystore.persistencia.entidades.Usuario;
import br.com.candystore.persistencia.jdbc.UsuarioDAO;

public class testUsuarioDAO {
	public static void main(String[] args) {
		testBuscaTodos();
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

	public static void testSalvar() {
		Usuario usuario = new Usuario();
		// usuario.setId(2);
		usuario.setNome("Natalicio Nascimento");
		usuario.setLogin("NatalicioNasc");
		usuario.setSenha("liciocios");
		usuario.setTipo("Adm");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);

		System.out.println("Usuario salvo com sucesso!!!");
	}

	public static void testBuscaPorId() {
		UsuarioDAO usuarioDAO =  new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscaPorId(3);
		System.out.println(usuario);
	}
	
	public static void testBuscaTodos() {
		UsuarioDAO usuarioDAO =  new UsuarioDAO();
		List<Usuario> usuarios = usuarioDAO.buscaTodos();
		System.out.println(usuarios);
	}
}
