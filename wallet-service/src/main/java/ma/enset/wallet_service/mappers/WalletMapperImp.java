package ma.enset.wallet_service.mappers;

import ma.enset.wallet_service.dtos.ClientDto;
import ma.enset.wallet_service.dtos.WalletDto;
import ma.enset.wallet_service.entities.Client;
import ma.enset.wallet_service.entities.Wallet;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class WalletMapperImp {

    public ClientDto fromClient(Client client){
        ClientDto clientDTO = new ClientDto();
        BeanUtils.copyProperties(client, clientDTO);
        return clientDTO;
    }
    public Client fromClientDTO(ClientDto clientDTO){
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        return client;
    }
    public WalletDto fromWallet(Wallet wallet){
        WalletDto walletDTO = new WalletDto();
        BeanUtils.copyProperties(wallet, walletDTO);
        walletDTO.setClient(fromClient(wallet.getClient()));
        return walletDTO;
    }
    public Wallet fromWalletDTO(WalletDto walletDTO){
        Wallet wallet = new Wallet();
        BeanUtils.copyProperties(walletDTO, wallet);
        wallet.setClient(fromClientDTO(walletDTO.getClient()));
        return wallet;
    }
}