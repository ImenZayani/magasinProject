package tn.esprit._cinfogl1.magasinproject.DAO.Repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._cinfogl1.magasinproject.DAO.Entities.CarteFid;

@Repository
public interface CarteFidRepository extends CrudRepository<CarteFid, Integer> {
}
