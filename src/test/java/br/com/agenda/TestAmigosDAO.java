package br.com.agenda;

import br.com.candystore.persistencia.entidades.Amigos;
import br.com.candystore.persistencia.jdbc.AmigosDAO;

public class TestAmigosDAO {
	public static void main(String[] args) {
	testExcluirIntervalo();
//		testExcluir();
//		testEditar();
//	testCadastrar();
		
	}
	
	public static void testCadastrar(){
		
		Amigos amigos = new Amigos();
		amigos.setNome("Assis");
		amigos.setApelido("Dió");
		amigos.setTelefone(9995027);
		amigos.setRedeSocial("Dió");
		
		AmigosDAO amigoDAO = new AmigosDAO();
		amigoDAO.cadastrar(amigos);
		System.out.println("Cadastro realizado com sucesso!!!");
		
	}
	public static void testEditar(){
		Amigos amigos = new Amigos();
		amigos.setId(1);
		amigos.setNome("Assis");
		amigos.setApelido("Dió");
		amigos.setTelefone(9995027);
		amigos.setRedeSocial("Dió");
		
		AmigosDAO amigoDAO = new AmigosDAO();
		amigoDAO.editar(amigos);
		System.out.println("Edição realizada com sucesso!!!");
		
	}
	
	public static void testExcluir(){
		Amigos amigos = new Amigos();
		amigos.setId(1);
		
		AmigosDAO amigoDAO = new AmigosDAO();
		amigoDAO.excluir(amigos);
		System.out.println("Exclusão  realizada com sucesso!!!");
		
	}
	
	public static void testExcluirIntervalo(){
		Amigos amigos = new Amigos();
		amigos.setId(3);
		amigos.setId(19);
		
		AmigosDAO amigoDAO = new AmigosDAO();
		amigoDAO.excluirIntervalo(amigos);
		amigoDAO.excluirIntervalo(amigos);
		System.out.println("Intervalo exluido com sucesso!!!");
	}

}
