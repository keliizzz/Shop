package ua.project.buyers.dao;

import java.sql.SQLException;


import java.util.List;

import org.springframework.stereotype.Service;

import ua.project.buyers.entity.Buyer;

@Service
public interface PoultryFarmDao {
	List<Buyer> getAllBuyers() throws SQLException;
	List<Buyer> findBuyerByName(String name) throws SQLException;
	void addBuyer(Buyer buyer) throws SQLException;
	void deleteBuyer(String buyerName) throws SQLException;
}
