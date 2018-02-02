package com.huios.dao;

/** @author Étienne, Sophia, Maria, Louis */
public class ClientOADException extends Exception {

	private static final long serialVersionUID = -4485207299675400262L;

	/**
	 * @param msg
	 *            le message d’erreur
	 */
	public ClientOADException(final String msg) {
		super(msg);
	}
}
