package dev.luanc.library.repository;

import dev.luanc.library.model.Infraction;
import dev.luanc.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfractionRepository extends JpaRepository<Infraction, Integer> {

    public Integer countInfractionByUser(User user);
}
