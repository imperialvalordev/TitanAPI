package net.imperialvalor.titanapi.share.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author Whitescan
 *
 */
public abstract class AbstractDatabase {

	protected Logger logger;

	protected String database;

	protected String prefix;

	protected Connection connection;

	public AbstractDatabase(Logger logger, String database, String prefix) {
		this.logger = logger;
		this.database = database;
		this.prefix = prefix;
	}

	protected abstract void connect();

	public void close() {

		try {

			if (connection != null) {
				connection.close();
				logger.info("Connection to database: " + database + " was closed.");
			}

		} catch (SQLException e) {
			logger.warning("Connection to database: " + database + " could not close!");
			e.printStackTrace();
		}

	}

	public Connection getConnection() {

		try {
			if (connection == null || connection.isClosed()) {
				connect();
			}
		} catch (SQLException e) {
			logger.severe("Could not retreive a connection from database: " + database + "! This is most likely a follow up error.");
			e.printStackTrace();
		}

		return connection;
	}

	public String getPrefix() {
		return prefix;
	}

}
