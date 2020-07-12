package pl.coderslab.charity.institution;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class InstitutionDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Institution find(Long id) {
        return entityManager.find(Institution.class, id);
    }

    public void save(Institution institution) {
        entityManager.persist(institution);
    }

    public void update(Institution institution) {
        entityManager.merge(institution);
    }

    public void delete(Long id) {
        Institution institution = find(id);
        if (institution != null) {
            entityManager.remove(institution);
        }
    }
}