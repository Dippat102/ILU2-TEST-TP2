package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolée "+nomVendeur+" mais il faut être un habitant de notre village pour commencer ici.");
		}
		else {
			System.out.println("Bonjour "+nomVendeur+" ,je vais regarder si je peux vous trouver un étal.");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolée "+nomVendeur+" ,je n'ai plus d'étal qui ne soit pas déjà occupé.");
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("c'est parfait, il me reste un étal pour vous! ");
		System.out.println("Il me faudrait quelques renseignements ");
		StringBuilder question = new StringBuilder();
		System.out.println("Quelle produit souhaitez_vous vendre?");
		String produit=Clavier.entrerChaine(question.toString());
		System.out.println("Combien souhaitez_vous en vendre?");
		int nbProduit=Clavier.entrerEntier(question.toString());
		int numeroEtal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal!=-1) {
			System.out.println("Le vendeur "+nomVendeur+" s'est installé àl'étals n°"+numeroEtal);
		}
	}
}
