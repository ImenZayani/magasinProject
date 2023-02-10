package tn.esprit._cinfogl1.magasinproject.DAO.Entities;


import lombok.*;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarteFid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCarte;
    @Column(unique = true)
    long numCarte;
    int solde;
    @Temporal(TemporalType.DATE)
    Date dateCreation;
}
