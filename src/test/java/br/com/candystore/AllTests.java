package br.com.candystore;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.candystore.persistencia.entidades.Usuario;
import br.com.candystore.persistencia.jdbc.UsuarioDAO;

@RunWith(Suite.class)
@SuiteClasses({})
public class AllTests {
	//objeto do dbunit
	JdbcDatabaseTester jdt;
	
	@Before
	public void setUp() throws Exception {
		
			jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost/candystore", "postgres", "root");
			//cara que recupera as informações do arquivo xml
			FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
			jdt.setDataSet(loader.load("/inicio.xml"));
			jdt.onSetup();
	}

//	@Test
//	public void buscaTodos(){
//		UsuarioDAO usuarioDAO = new UsuarioDAO();
//		
//		List<Usuario> lista  = usuarioDAO.buscaTodos();
// 		assertEquals(3, lista.size());
// 		assertEquals("liano", lista.get(3).getLogin());
//	}
	
	@Test
	public void insereUsuario() throws Exception{
		Usuario usuario = new Usuario();
		usuario.setNome("todo liano");
		usuario.setLogin("liano");
		usuario.setSenha("suelly");
		usuario.setTipo("adm");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrar(usuario);
		
		IDataSet currentDataSet  = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataSet.getTable("USUARIOS");
		
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataSet = loader.load("/verifica.xml");
		
		ITable expectedTable = expectedDataSet.getTable("USUARIOS");
		Assertion.assertEquals(expectedTable, currentTable);
	}
}
