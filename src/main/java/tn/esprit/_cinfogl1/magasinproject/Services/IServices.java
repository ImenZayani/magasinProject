package tn.esprit._cinfogl1.magasinproject.Services;

import tn.esprit._cinfogl1.magasinproject.DAO.Entities.CarteFid;
import tn.esprit._cinfogl1.magasinproject.DAO.Entities.Client;
import tn.esprit._cinfogl1.magasinproject.DAO.Entities.Magasin;

public interface IServices {
    Client ajouterClient(Client c);

    Magasin ajouterMagasinEtPersonnels(Magasin magasin) ;

    void affecterClientAMagasin(int idClient, int idMagasin) ;

    void ajouterCarteEtAffecterClient(CarteFid carteFid, long cin) ;

    long effectuerOperation(String typeOperation, long numCarte, int montant) ;
}
