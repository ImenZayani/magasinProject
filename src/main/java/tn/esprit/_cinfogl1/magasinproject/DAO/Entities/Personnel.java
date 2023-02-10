package tn.esprit._cinfogl1.magasinproject.DAO.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idPersonnel;

    String nomPersonnel;
    String prenomPersonnel;

    @Temporal(TemporalType.DATE)
    Date dateNaissance;

    @Enumerated(EnumType.STRING)
    TypePersonnel typePersonnel;

    @OneToOne
    @JsonIgnore
    Magasin magasinD;

    @ManyToOne
    @JsonIgnore
    Magasin magasinC;


}
