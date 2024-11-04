package ma.enset.wallet_service.services;

import ma.enset.wallet_service.dtos.ClientDto;
import ma.enset.wallet_service.dtos.WalletDto;
import ma.enset.wallet_service.exceptions.ClientException;
import ma.enset.wallet_service.exceptions.WalletException;

import java.util.List;

public interface WalletService {

     WalletDto saveWallet(Long clientId);
     WalletDto updateWallet(WalletDto wall);
     void deleteWalletById(String id);
     WalletDto getWallet(String walletId);
     List<WalletDto> getAllWallets();
     List<WalletDto> getWalletsByClientId(Long clientId);



     List<ClientDto> getClients();
     ClientDto saveClient(ClientDto clientDTO);
     ClientDto getClientById(Long id);
}