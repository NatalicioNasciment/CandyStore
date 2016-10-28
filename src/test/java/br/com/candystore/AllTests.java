package br.com.candystore;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.candystore.persistencia.entidades.Usuario;
import br.com.candystore.persistencia.jdbc.UsuarioDAO;

@RunWith(Suite.class)
@SuiteClasses({})
public class AllTests {
	
	@Test
	public void testCadastrar(){
		Usuario usuario = new Usuario();
		usuario.setNome("Natalicio");
		usuario.setLogin("licio");
		usuario.setSenha("licio");
		usuario.setTipo("Administrador");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
//		assertTrue(usuarioDAO.cadastrar(usuario));
	}

}
