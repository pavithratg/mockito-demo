package com.eviac.blog.exceptions;

import java.sql.SQLException;

public class BOException extends Exception {

	private static final long serialVersionUID = -5538571683901193547L;

	public BOException(SQLException e) {
		super(e);
	}

}
