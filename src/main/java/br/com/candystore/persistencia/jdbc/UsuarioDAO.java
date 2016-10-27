package br.com.candystore.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.candystore.persistencia.entidades.Usuario;

public class UsuarioDAO {
	private Connection con = conexaoFactory.getConnection();

	public void cadastrar(Usuario usuario) {
		String sql = "INSERT INTO usuario (nome, tipo,senha) VALUES(?, ?, ?)";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getTipo());
			pst.setString(3, usuario.getTipo());
			
			pst.execute();
			pst.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
