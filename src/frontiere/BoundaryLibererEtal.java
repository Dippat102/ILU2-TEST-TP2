package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui!");
		}
		else {
			String[] donneesEtal=controlLibererEtal.libererEtal(nomVendeur);
			Boolean etalOccupe=Boolean.valueOf(donneesEtal[0]);
			if (etalOccupe) {
				String produit = donneesEtal[2];
				String quantiteInitial=donneesEtal[3];
				String quantiteVendu=donneesEtal[4];
				System.out.println("Vous avez vendue "+quantiteVendu+" sur" +quantiteInitial+" "+produit+"." );
				System.out.println("En revoir "+nomVendeur+", passez une bonne journée.");
			}
		}
	}

}
