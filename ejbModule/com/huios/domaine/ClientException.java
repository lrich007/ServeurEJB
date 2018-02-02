package com.huios.domaine;

/** @author Étienne, Sophia, Maria, Louis */
public class ClientException extends Exception {

	private static final long serialVersionUID = -8087198673383393222L;

	/**
	 * @param msg
	 *            le message d’erreur
	 */
	public ClientException(final String msg) {
		super(msg);
	}
}
