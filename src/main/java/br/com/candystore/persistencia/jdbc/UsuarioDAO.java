package br.com.candystore.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.candystore.persistencia.entidades.Usuario;

public class UsuarioDAO {

	private Connection con = conexaoFactory.getConnection();

	public void cadastrar(Usuario usuario) {
		String sql = "INSERT INTO usuarios(nome, login, senha, tipo) VALUES(?, ?, ?, ?)";

		try (PreparedStatement pst = con.prepareStatement(sql)) {
			
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getLogin());
			pst.setString(3, usuario.getSenha());
			pst.setString(4, usuario.getTipo());

			pst.executeUpdate();
			pst.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Usuario usuario){
		String sql = "UPDATE usuarios SET nome = ?, login = ?, senha = ?, tipo = ? WHERE id = ?";

		try (PreparedStatement pst = con.prepareStatement(sql)) {
			
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getLogin());
			pst.setString(3, usuario.getSenha());
			pst.setString(4, usuario.getTipo());
			pst.setInt(5, usuario.getId());

			pst.executeUpdate();
			pst.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
