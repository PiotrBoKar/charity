package pl.coderslab.charity.category;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Category find(Long id) {
        return entityManager.find(Category.class, id);
    }

    public void save(Category category) {
        entityManager.persist(category);
    }

    public void update(Category category) {
        entityManager.merge(category);
    }

    public void delete(Long id) {
        Category category = find(id);
        if (category != null) {
            entityManager.remove(category);
        }
    }
}