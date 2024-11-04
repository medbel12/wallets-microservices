package ma.enset.wallet_service.repositories;

import ma.enset.wallet_service.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet,String> {

    void deleteWalletById(String id);
    Wallet findWalletById(String id);

    List<Wallet> findWalletsByClientId(Long clientId);


}
