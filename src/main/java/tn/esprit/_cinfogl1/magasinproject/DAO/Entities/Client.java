package tn.esprit._cinfogl1.magasinproject.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idClient;
    @Column(unique = true)
    long cin;
    String nomClient;
    String prenomClient;
    String adresse;

    @ManyToMany
    @JsonIgnore
    List<Magasin> magasins;

    @OneToOne(cascade = CascadeType.ALL)
    CarteFid carteFid;
}

