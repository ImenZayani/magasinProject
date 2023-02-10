package tn.esprit._cinfogl1.magasinproject.RestControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit._cinfogl1.magasinproject.DAO.Entities.CarteFid;
import tn.esprit._cinfogl1.magasinproject.DAO.Entities.Client;
import tn.esprit._cinfogl1.magasinproject.DAO.Entities.Magasin;
import tn.esprit._cinfogl1.magasinproject.Services.IServices;

@RestController
public class RestControllers {

    @Autowired
    IServices iServices;
    @PostMapping("ajouterClient")
    Client ajouterClient(@RequestBody Client c) {
        return iServices.ajouterClient(c);
    }

    @PostMapping("ajouterMagasinEtPersonnels")
    Magasin ajouterMagasinEtPersonnels(@RequestBody Magasin magasin){
        return iServices.ajouterMagasinEtPersonnels(magasin);
    }

    @PutMapping("affecterClientAMagasin")
    void affecterClientAMagasin(@RequestParam int idClient, @RequestParam int idMagasin){
        iServices.affecterClientAMagasin(idClient, idMagasin);

    }

    @PutMapping("ajouterCarteEtAffecterClient")
    void ajouterCarteEtAffecterClient(@RequestBody CarteFid carteFid,@RequestParam long cin){
        iServices.ajouterCarteEtAffecterClient(carteFid, cin);
    }

    @PutMapping("effectuerOperation")
    long effectuerOperation(@RequestParam String typeOperation,@RequestParam long numCarte,@RequestParam int montant){
        return iServices.effectuerOperation(typeOperation, numCarte, montant);
    }

}
