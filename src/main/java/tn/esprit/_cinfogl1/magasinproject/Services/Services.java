package tn.esprit._cinfogl1.magasinproject.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit._cinfogl1.magasinproject.DAO.Entities.CarteFid;
import tn.esprit._cinfogl1.magasinproject.DAO.Entities.Client;
import tn.esprit._cinfogl1.magasinproject.DAO.Entities.Magasin;
import tn.esprit._cinfogl1.magasinproject.DAO.Entities.Personnel;
import tn.esprit._cinfogl1.magasinproject.DAO.Repositories.CarteFidRepository;
import tn.esprit._cinfogl1.magasinproject.DAO.Repositories.ClientRepository;
import tn.esprit._cinfogl1.magasinproject.DAO.Repositories.MagasinRepository;
import tn.esprit._cinfogl1.magasinproject.DAO.Repositories.PersonnelRepository;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class Services implements IServices {
    @Autowired
    CarteFidRepository carteFidRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    MagasinRepository magasinRepository;
    @Autowired
    PersonnelRepository personnelRepository;

    @Override
    public Client ajouterClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public Magasin ajouterMagasinEtPersonnels(Magasin magasin){
        Personnel directeur = personnelRepository.save(magasin.getDirecteur());
        List<Personnel> caissiers = (List<Personnel>) personnelRepository.saveAll(magasin.getCaissiers());
        magasin = magasinRepository.save(magasin);

        directeur.setMagasinD(magasin);
        for (Personnel p : caissiers){
            p.setMagasinC(magasin);
            personnelRepository.save(p);
        }
        return magasin;
    }
    @Override
    public void affecterClientAMagasin(int idClient, int idMagasin){
        Client client = clientRepository.findById(idClient).get(); //Parent
        Magasin magasin = magasinRepository.findById(idMagasin).get(); //Child
        //On affecte le child au parent
        client.getMagasins().add(magasin);
        clientRepository.save(client);


    }

    @Override
    public void ajouterCarteEtAffecterClient(CarteFid carteFid, long cin) {
        Client client = clientRepository.findByCin(cin); // Parent
        // Carte fidelite Child (On peut utiliser Cascade)
        //On affecte le child au parent
        carteFid.setDateCreation(new Date());
        carteFid.setSolde(0);
        client.setCarteFid(carteFid);
        clientRepository.save(client);

    }

    @Override
    public long effectuerOperation(String typeOperation, long numCarte, int montant) {
        CarteFid carteFid = carteFidRepository.findByNumCarte(numCarte);
        if ( typeOperation.equals("+")) {
            carteFid.setSolde(carteFid.getSolde() + montant);
            carteFid = carteFidRepository.save(carteFid);
        }
        else if (typeOperation.equals("-")) {
            carteFid.setSolde(carteFid.getSolde() - montant);
            carteFid = carteFidRepository.save(carteFid);
        }
        return  carteFid.getSolde();
    }

}
