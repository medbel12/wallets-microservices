package ma.enset.transfer_service.feign;

import ma.enset.transfer_service.model.ClientDTO;
import ma.enset.transfer_service.model.WalletDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

    @FeignClient(name = "wallet-service")
    public interface WalletRestClient {
        @GetMapping("/wallets/{walletId}")
        WalletDTO getWalletById(@PathVariable("id") String walletId);
        @GetMapping("/wallets")
        List<WalletDTO> getAllWallets();
        @PostMapping("/wallets")
        WalletDTO saveWallet(WalletDTO wallet);

        @GetMapping("/clients/{clientId}")
        ClientDTO getClientById(@PathVariable("id") Long clientId);
        @GetMapping("/clients")
        List<ClientDTO> getAllClients();
}
