package fr.ihm.action;

import java.util.logging.Logger;

import fr.ihm.IhmUtilClient;

public class CommandePizza extends ActionClient {
	private IhmUtilClient ihmUtilClient;

	public CommandePizza(IhmUtilClient ihmUtilClient) {
		super();
		this.setDescription("Commander une pizza");
		this.ihmUtilClient = ihmUtilClient;
	}

	@Override
	public void doAction() {
		ihmUtilClient.getClientDao().findAllPizza();
		System.out.println("Veuillez la reference de la pizza:");
		String libelle = ihmUtilClient.getScanner().next();
		System.out.println("Veuillez la quantitee de " + libelle + " :");
		String quantite = ihmUtilClient.getScanner().next();
		ihmUtilClient.getClientDao().save(libelle, Integer.parseInt(quantite));
	}

	@Override
	public void describeAction() {
		Logger.getLogger(this.getDescription());
		System.out.println(this.getDescription());

	}

}
