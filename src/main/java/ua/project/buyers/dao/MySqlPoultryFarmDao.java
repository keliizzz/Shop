package ua.project.buyers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.project.buyers.entity.Buyer;

@Repository
public class MySqlPoultryFarmDao implements PoultryFarmDao {

	private final String url;
	private final Properties dbProps = new Properties();

	@Autowired
	public MySqlPoultryFarmDao(DAOConfig config) {
		url = config.getUrl();
		dbProps.setProperty("user", config.getUser());
		dbProps.setProperty("password", config.getPassword());
	}

	public Connection getConnection() throws SQLException {
		// return DriverManager.getConnection(URL, conProps);
		return getConnection(true);
	}

	public Connection getConnection(boolean autocommit) throws SQLException {
		Connection con = DriverManager.getConnection(url, dbProps);
		con.setAutoCommit(autocommit);
		if (!autocommit) {
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		}
		return con;
	}

	public List<Buyer> getAllBuyers() throws SQLException {
		try (Connection con = getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from buyer");) {
			List<Buyer> buyers = new ArrayList<Buyer>();
			while (rs.next()) {
				Buyer buyer = mapBuyer(rs);
				buyers.add(buyer);
			}
			return buyers;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DbException("Cannot get buyers", e);
		}
	}

	private Buyer mapBuyer(ResultSet rs) throws SQLException {
		Buyer buyer = new Buyer();
		buyer.setId(rs.getInt("idBuyer"));
		buyer.setNameOfBuyer(rs.getString("name_of_buyer"));
		buyer.setFirstNameOfRepresentative(rs.getString("firstName_of_representative"));
		buyer.setLastNameOfRepresentative(rs.getString("lastName_of_representative"));
		buyer.setAddress(rs.getString("address"));
		buyer.setTelNumber(rs.getString("tel_number"));
		return buyer;
	}

	public List<Buyer> findBuyerByName(String name) throws SQLException {
		List<Buyer> buyers = new ArrayList<>();
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement("select * from buyer where name_of_buyer like ?");) {
			int k = 1;
			st.setString(k++, "%" + escapeForLike(name) + "%");
			try (ResultSet rs = st.executeQuery();) {
				while (rs.next()) {
					buyers.add(mapBuyer(rs));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return buyers;
	}

	static String escapeForLike(String param) {
		return param.replace("!", "!!").replace("%", "!%").replace("_", "!_");
	}

	public void addBuyer(Buyer buyer) throws SQLException {
		Connection con = null;
		try {
			con = getConnection(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			insertBuyer(buyer, con);
			con.commit();
			//return buyer;
		} catch (SQLException e) {
			rollback(con);
			 System.err.println(e.getMessage());
			throw e;
		} finally {
			close(con);
		}

	}

	private void insertBuyer(Buyer buyer, Connection con) throws SQLException {
		try (PreparedStatement st = con.prepareStatement(
				"INSERT INTO buyer (name_of_buyer, firstName_of_representative, lastName_of_representative, address, tel_number)"
						+ "VALUES (?, ?, ?, ?, ?)")) {
			int idx = 0;
			st.setString(++idx, buyer.getNameOfBuyer());
			st.setString(++idx, buyer.getFirstNameOfRepresentative());
			st.setString(++idx, buyer.getLastNameOfRepresentative());
			st.setString(++idx, buyer.getAddress());
			st.setString(++idx, buyer.getTelNumber());
			st.executeUpdate();
		}
	}

	public void deleteBuyer(String buyerName) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = getConnection();
			st = con.prepareStatement("DELETE FROM buyer WHERE name_of_buyer = ?");
			st.setString(1, buyerName);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			close(con);
			close(st);
		}

	}

	private void close(AutoCloseable con) {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void rollback(Connection con) {
		if (con != null) {
            try {
                con.rollback();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
        }
	}

}
