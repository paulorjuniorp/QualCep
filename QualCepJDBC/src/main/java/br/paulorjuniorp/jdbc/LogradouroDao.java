package br.paulorjuniorp.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.paulorjuniorp.entidades.Logradouro;
import br.paulorjuniorp.entidades.TiposLogradouro;

public class LogradouroDao {
	
	private Connection connection;

	public LogradouroDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Logradouro log) {
		String sql = "insert into logradouros "
				+ "(id,cep,nome,id_tipo_logradouro,id_bairro)" + " values (?,?,?,?,?)";

		try {

			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);


			stmt.setLong(1, log.getId());
			stmt.setString(2, log.getCep());
			stmt.setString(3, log.getNome());
			stmt.setLong(4, log.getTipoLogradouro().getId());
			stmt.setLong(5, log.getBairro().getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Logradouro> pegaTodos() {
		try {
			List<Logradouro> logs = new ArrayList<Logradouro>();
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement("select * from logradouros");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Logradouro log = new Logradouro();
				log.setId(rs.getLong("id"));
				log.setCep(rs.getString("cep"));
				log.setNome(rs.getString("nome"));
				log.getTipoLogradouro().setId(rs.getLong("id_tipo_logradouro"));
				log.getBairro().setId(rs.getLong("id_bairro"));
				
				logs.add(log);
			}
			rs.close();
			stmt.close();
			return logs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public List<Logradouro> ordenadosPeloNome() {
		try {
			List<Logradouro> logs = new ArrayList<Logradouro>();
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement("select * from logradouros order By nome");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Logradouro log = new Logradouro();
				log.setId(rs.getLong("id"));
				log.setCep(rs.getString("cep"));
				log.setNome(rs.getString("nome"));
				log.getTipoLogradouro().setId(rs.getLong("id_tipo_logradouro"));
				log.getBairro().setId(rs.getLong("id_bairro"));
				
				logs.add(log);
			}
			rs.close();
			stmt.close();
			return logs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void altera(Logradouro log) {
		String sql = "update logradouros set cep=?, nome=?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);
			stmt.setLong(1, log.getId());
			stmt.setString(2, log.getCep());
			stmt.setString(3, log.getNome());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Logradouro log) {
		try {
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement("delete from logradouros where id=?");
			stmt.setLong(1, log.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Logradouro buscaPorCep(String cep) {
		Logradouro log = new Logradouro();
		
		 try {
	         PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("select * from logradouros where id=?");
	         stmt.setString(1, cep);
	         
	         ResultSet rs = stmt.executeQuery();
	         
				if (rs.next()) {
					log.setId(rs.getLong("id"));
					log.setCep(rs.getString("cep"));
					log.setNome(rs.getString("nome"));
					log.getTipoLogradouro().setId(rs.getLong("id_tipo_logradouro"));
					log.getBairro().setId(rs.getLong("id_bairro"));
				}
	         stmt.close();
	         return log;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }		
	}

}
