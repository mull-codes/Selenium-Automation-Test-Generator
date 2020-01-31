package com.k00217982.fyp.cloud;

import java.sql.SQLException;

public interface Database {
	boolean connect() throws SQLException;
	boolean close();
}
