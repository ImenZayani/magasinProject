package tn.esprit._cinfogl1.magasinproject.DAO.Entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Magasin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idMagasin;
    String nomMagasin;
    long contactMagasin;
    String adresseMagasin;

    @OneToOne(mappedBy = "magasinD")
    Personnel directeur;

    @OneToMany(mappedBy = "magasinC")
    List<Personnel> caissiers;

    @ManyToMany(mappedBy = "magasins",fetch = FetchType.EAGER)
    List<Client> clients;


}
