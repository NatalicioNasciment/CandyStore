package br.com.candystore.persistencia.jdbc;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public void alterar(Usuario usuario) {
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

	public void excluir(Usuario usuario) {

		String sql = "DELETE FROM usuarios WHERE id = ?";

		try (PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, usuario.getId());
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void salvar(Usuario usuario) {
		if (usuario.getId() > 0) {
			alterar(usuario);
		} else {
			cadastrar(usuario);
		}
	}

	public Usuario buscaPorId(int id) {

		String sql = "SELECT * FROM usuarios WHERE id = ?";

		try (PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();

			if (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				usuario.setTipo(resultado.getString("tipo"));
				return usuario;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public java.util.List<Usuario> buscaTodos() {

		java.util.List<Usuario> lista = new ArrayList<Usuario>();

		String sql = "SELECT * FROM usuarios ";

		try (PreparedStatement pst = con.prepareStatement(sql)) {
			ResultSet resultado = pst.executeQuery();
			
			while(resultado.next()){
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				usuario.setTipo(resultado.getString("tipo"));
				lista.add(usuario);
			}
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
