package br.com.agenda.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.agenda.persistencia.entidades.Amigos;

public class AmigosDAO {
	
	private Connection con = ConexaoFactory.getConection();
	
	public AmigosDAO(){}

	public void cadastrar(Amigos amigos) {
		
		String sql = "INSERT INTO amigos(nome, apelido, telefone, redeSocial) VALUES(?, ?, ?, ?)";
		try (PreparedStatement pst = con.prepareStatement(sql)){
			pst.setString(1, amigos.getNome());
			pst.setString(2, amigos.getApelido());
			pst.setInt(3, amigos.getTelefone());
			pst.setString(4, amigos.getRedeSocial());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void editar(Amigos amigos) {
		String sql = "UPDATE amigos SET nome = ?, apelido = ?, telefone = ?, redesocial = ? WHERE id = ?";
		
		try (PreparedStatement pst = con.prepareStatement(sql)){
			pst.setString(1, amigos.getNome());
			pst.setString(2, amigos.getApelido());
			pst.setInt(3, amigos.getTelefone());
			pst.setString(4, amigos.getRedeSocial());
			pst.setInt(5, amigos.getId());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void excluir(Amigos amigos) {
		String sql = "DELETE FROM amigos WHERE id = ?";
		
		try (PreparedStatement pst = con.prepareStatement(sql)){
			pst.setInt(1, amigos.getId());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluirIntervalo(Amigos amigos) {
//		delete from tabela where id >= 20 and id <= 60;
		String sql = "DELETE FROM amigos WHERE id >= ? AND id <= ?";
		
		try (PreparedStatement pst = con.prepareStatement(sql)){
			pst.setInt(1, amigos.getId());
			pst.setInt(2, amigos.getId());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
