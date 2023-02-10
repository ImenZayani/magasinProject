package tn.esprit._cinfogl1.magasinproject.Services;

import tn.esprit._cinfogl1.magasinproject.DAO.Entities.CarteFid;
import tn.esprit._cinfogl1.magasinproject.DAO.Entities.Client;
import tn.esprit._cinfogl1.magasinproject.DAO.Entities.Magasin;

import java.util.List;

public interface IServices {

    //ajouter les clients
    Client ajouterClient(Client c);


    //ajouter le magasin et ses personnels(directeur, caissiers)
    Magasin ajouterMagasinEtPersonnels(Magasin magasin) ;


    //affecter les clients « Ahmed » et « Ala » à
    //« Bonus »
    void affecterClientAMagasin(int idClient, int idMagasin) ;


    //Ajouter les deux cartes et les affecter au client ci-dessous en respectant la signature suivante
    //Lors de l’ajout de la carte, le solde sera initialisé à zéro et la date création prendra la date
    //système comme valeur.
    void ajouterCarteEtAffecterClient(CarteFid carteFid, long cin) ;



    //effectuer une opération sur le solde de la
    //carte de fidélité dont son numéro est passé en paramètre
    //NB : La méthode vérifie les conditions suivantes :
    //✓ Si le type de l’opération est égale à « + », le montant sera additionné au solde.
    //✓ Si le type de l’opération est égale à « - », le montant sera soustrait du solde.
    //✓ Cette méthode retourne le nouveau solde de la carte de fidélité.
    long effectuerOperation(String typeOperation, long numCarte, int montant) ;


    //En respectant la signature de la méthode ci-dessous, afficher la liste des clients du magasin dont son
    //nom est passé en paramètre
    List<Client> afficherClients(String nomMagasin) ;
}
