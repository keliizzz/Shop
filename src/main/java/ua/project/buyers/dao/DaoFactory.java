package ua.project.buyers.dao;

import org.springframework.context.annotation.Bean;

public abstract class DaoFactory {

	DAOConfig config;

	public static PoultryFarmDao getDAOInstance() {
		PoultryFarmDao dao = null;
		dao = new MySqlPoultryFarmDao(
				new DAOConfig("dbc:mysql://localhost:3306/poultryfarm", "liza", ""));

		return dao;
	}

	@Bean
	public PoultryFarmDao getDAOInstance(DAOConfig config) {
		return new MySqlPoultryFarmDao(config);
	}

}
