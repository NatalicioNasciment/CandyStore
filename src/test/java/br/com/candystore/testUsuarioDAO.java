package br.com.candystore;

import br.com.candystore.persistencia.entidades.Usuario;
import br.com.candystore.persistencia.jdbc.UsuarioDAO;

public class testUsuarioDAO {
	public static void main(String[] args) {
		
		//criando o usuario
		Usuario usuario = new Usuario();
		usuario.setNome("Natalicio");
		usuario.setSenha("natalicio");
		usuario.setTipo("administrador");
		//cadastrando o usuario no banco
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrar(usuario);
		
		System.out.println("Cadastro realizado com sucesso!!!");
	}
}
