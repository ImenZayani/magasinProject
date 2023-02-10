package tn.esprit._cinfogl1.magasinproject.RestControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit._cinfogl1.magasinproject.DAO.Entities.Client;
import tn.esprit._cinfogl1.magasinproject.Services.IServices;

@RestController
public class RestControllers {

    @Autowired
    IServices iServices;
    @PostMapping("ajouterClient")
    Client ajouterClient(@RequestBody Client c) {
        return iServices.ajouterClient(c);
    }
}
