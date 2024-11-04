package ma.enset.wallet_service.repositories;

import ma.enset.wallet_service.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ClientPepository extends JpaRepository<Client,Long> {
    Client findClientById(Long id);
}
