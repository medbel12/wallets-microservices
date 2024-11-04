package ma.enset.wallet_service.web;


import lombok.AllArgsConstructor;
import ma.enset.wallet_service.dtos.ClientDto;
import ma.enset.wallet_service.dtos.WalletDto;
import ma.enset.wallet_service.services.WalletServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class WalletRestController {
    private WalletServiceImpl walletService;

    @GetMapping("/clients")
    public List<ClientDto> clients(){
        return walletService.getClients();
    }

    @GetMapping("/clients/{id}")
    public ClientDto getClients(@PathVariable(name = "id") Long clientId){
        return walletService.getClientById(clientId);
    }
    @PostMapping("/clients")
    public ClientDto saveClient(@RequestBody ClientDto client){
        return walletService.saveClient(client);
    }
    @GetMapping("/wallets")
    public List<WalletDto> wallets(){
        return walletService.getAllWallets();
    }
    @GetMapping("/wallets/{id}")
    public WalletDto getWallet(@PathVariable(name = "id") String walletId){
        return walletService.getWallet(walletId);
    }
    @PutMapping("/wallets/{walletId}")
    public WalletDto updateWallet(@RequestBody WalletDto walletDTO,@PathVariable String walletId){
        walletDTO.setId(walletId);
        return walletService.updateWallet(walletDTO);
    }
    @DeleteMapping("/wallets/{id}")
    public void deleteWallet(@PathVariable String id){
        walletService.deleteWalletById(id);
    }
    @GetMapping("/clients/{id}/wallets")
    public List<WalletDto> walletsOfClient(@PathVariable Long id){
        return walletService.getWalletsByClientId(id);
    }
    @PostMapping("/wallets")
    public WalletDto saveWallet(Long clientId){
        return walletService.saveWallet(clientId);
    }
}