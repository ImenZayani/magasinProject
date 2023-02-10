package tn.esprit._cinfogl1.magasinproject.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit._cinfogl1.magasinproject.DAO.Entities.Client;
import tn.esprit._cinfogl1.magasinproject.DAO.Repositories.CarteFidRepository;
import tn.esprit._cinfogl1.magasinproject.DAO.Repositories.ClientRepository;
import tn.esprit._cinfogl1.magasinproject.DAO.Repositories.MagasinRepository;
import tn.esprit._cinfogl1.magasinproject.DAO.Repositories.PersonnelRepository;

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

}
