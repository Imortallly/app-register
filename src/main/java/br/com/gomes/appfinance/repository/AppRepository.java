package br.com.gomes.appfinance.repository;

import br.com.gomes.appfinance.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);

}
