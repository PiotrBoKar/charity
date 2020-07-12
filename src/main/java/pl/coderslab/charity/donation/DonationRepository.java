package pl.coderslab.charity.donation;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findAll();

    void deleteById(Long id);



    @Query("SELECT sum (q.quantity) FROM Donation q")
    int selectTotals();



}
