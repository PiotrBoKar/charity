package pl.coderslab.charity.donation;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DonationDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Donation find(Long id) {
        return entityManager.find(Donation.class, id);
    }

    public void save(Donation donation) {
        entityManager.persist(donation);
    }

    public void update(Donation donation) {
        entityManager.merge(donation);
    }

    public void delete(Long id) {
        Donation donation = find(id);
        if (donation != null) {
            entityManager.remove(donation);
        }
    }
}