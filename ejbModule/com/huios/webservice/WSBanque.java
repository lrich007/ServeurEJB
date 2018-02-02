package com.huios.webservice;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.huios.dao.ClientOADException;
import com.huios.domaine.Client;
import com.huios.domaine.Compte;
import com.huios.service.ConseillerServiceException;
import com.huios.service.IServiceLocal;

@Path("/banque")
public class WSBanque {

	@Inject
	IServiceLocal service;
	
	// Ok
	/**
	 * Permet de faire la connexion du conseiller.
	 * Il s'agit de l'authentification du conseiller
	 * 
	 * @param courriel
	 * 				l'identifiant du conseiller
	 * @param motDePasse
	 * 				mot de passe du conseiller
	 * @return	true ou false
	 * @throws ConseillerServiceException
	 */
	@GET
	@Path("/authentification/{courriel}/{motDePasse}")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean verifAuthentification(@PathParam("courriel") String courriel,
			@PathParam("motDePasse") String motDePasse)
					throws ConseillerServiceException {
		return service.verifAuthentification(courriel, motDePasse);
	}
	
	
	// Ok
	/**
	 * Permet au conseiller de faire un virement 
	 * compte à compte
	 * 
	 * @param idCompteADebiter 
	 * 				compte à débiter
	 * @param idCompteACrediter
	 * 				compte à crediter
	 * @param montant
	 * 				montant à virer
	 * @return	true ou false
	 * 				
	 * @throws ConseillerServiceException
	 */
	@GET
	@Path("/virement/{idCompteADebiter}/{idCompteACrediter}/{montant}")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean effectuerVirement(@PathParam("idCompteADebiter") int idCompteADebiter,
			@PathParam("idCompteACrediter") int idCompteACrediter, @PathParam("montant") double montant)
			throws ConseillerServiceException {
		Compte compteADebiter = service.getCompteById(idCompteADebiter);
		Compte compteACrediter = service.getCompteById(idCompteACrediter);
		return service.effectuerVirement(compteADebiter, compteACrediter, montant);
	}
	
	// Ok
	/**
	 * Permet de lister tous les clients
	 * @return une liste de client
	 */
	@GET
	@Path("/listAllClients")
	@Produces(MediaType.TEXT_PLAIN)
	public List<Client> getTousLesClients() {
		return service.getTousLesClients();
	}

	// Ok
	/**
	 * Permet d'afficher le client en fonction de son Identifiant
	 * @param id
	 * 			l'identifiant du client
	 * @return	le client en fonction de son Id
	 */
	@GET
	@Path("/client/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Client getClientByID(@PathParam("id") int id) {
		return service.getClientByID(id);
	}
	
	/**
	 * Permet de lister tous les clients du conseiller
	 * en fonction du courriel du conseiller
	 * 
	 * @param authName
	 * 				courriel du conseiller
	 * @return	une liste de clients
	 */
	@GET
	@Path("/listAuthName/{authName}")
	@Produces(MediaType.TEXT_PLAIN)
	public List<Client> getClientsByConseillerAuthName(@PathParam("authName") String authName) {
		return service.getClientsByConseillerAuthName(authName);
	}
	
	
	/**
	 * Permet de modifier le nom du client grace à son identifiant
	 * @param idClient
	 * 				identifiant du client
	 * @param nom
	 * 			nom du client
	 * @return	true ou false
	 * @throws ClientOADException
	 */
	@GET
	@Path("/nomclient/{idClient}/{nom}")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean modifierNomClient(@PathParam("idClient") int idClient, @PathParam("nom") String nom)
			throws ClientOADException {
		Client client = service.getClientByID(idClient);
		client.setNom(nom);
		return service.majClient(client);
	}
	
	/**
	 * Permet de modifier le prenom du client en fonction de son identifiant
	 * @param idClient
	 * 			identifiant du client
	 * @param prenom
	 * 			prenom du client
	 * @return	true ou false
	 * @throws ClientOADException
	 */
	@GET
	@Path("/prenomclient/{idClient}/{prenom}")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean modifierPrenomClient(@PathParam("idClient") int idClient, @PathParam("prenom") String prenom)
			throws ClientOADException {
		Client client = service.getClientByID(idClient);
		client.setPrenom(prenom);
		return service.majClient(client);
	}
	
	/**
	 * Permet de modifier le courriel du client en fonction de son identifiant
	 * @param idClient
	 * 			identifiant du client
	 * @param courriel
	 * 			courriel du client
	 * @return	true ou false
	 * @throws ClientOADException
	 */
	@GET
	@Path("/courrielclient/{idClient}/{courriel}")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean modifierCourrielClient(@PathParam("idClient") int idClient, @PathParam("courriel") String courriel)
			throws ClientOADException {
		Client client = service.getClientByID(idClient);
		client.setCourriel(courriel);
		return service.majClient(client);
	}
	
	/**
	 * Permet de modifier l'adresse du client en fonction de l'identifiant
	 * @param idClient
	 * 			identifiant du client
	 * @param adresse
	 * 			adresse du client
	 * @return	true ou false
	 * @throws ClientOADException
	 */
	@GET
	@Path("/adresseclient/{idClient}/{adresse}")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean modifierAdresseClient(@PathParam("idClient") int idClient, @PathParam("adresse") String adresse)
			throws ClientOADException {
		Client client = service.getClientByID(idClient);
		client.setAdresse(adresse);
		return service.majClient(client);
	}

	/**
	 * Permet de récupérer un compte en fonction de son Identifiant
	 * @param id
	 * 		identifiant du compte
	 * @return un compte
	 */
	@GET
	@Path("/compte/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Compte getCompteById(@PathParam("id") int id) {
		return service.getCompteById(id);
	}

	/**
	 * Permet d'afficher tous les comptes en fonction de l'identifiant
	 * 
	 * @param idClient
	 * 			identifiant du client
	 * 			
	 * @return	une liste de comtpe
	 */
	@GET
	@Path("/listComptes/{idClient}")
	@Produces(MediaType.TEXT_PLAIN)
	public List<Compte> getComptesByID(@PathParam("idClient") int idClient) {
		return service.getComptesByID(idClient);
	}

}
