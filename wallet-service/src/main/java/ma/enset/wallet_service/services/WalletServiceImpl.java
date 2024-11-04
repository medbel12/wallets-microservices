package ma.enset.wallet_service.services;

import ma.enset.wallet_service.dtos.ClientDto;
import ma.enset.wallet_service.dtos.WalletDto;
import ma.enset.wallet_service.entities.Client;
import ma.enset.wallet_service.entities.Wallet;
import ma.enset.wallet_service.mappers.WalletMapperImp;
import ma.enset.wallet_service.repositories.ClientPepository;
import ma.enset.wallet_service.repositories.WalletRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class WalletServiceImpl implements WalletService {

    private ClientPepository clientRepository;
    private WalletRepository walletRepository;
    private WalletMapperImp dtoMapper;

    public WalletServiceImpl(ClientPepository clientRepository, WalletRepository walletRepository, WalletMapperImp dtoMapper) {
        this.clientRepository = clientRepository;
        this.walletRepository = walletRepository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public ClientDto saveClient(ClientDto clientDto) {
        Client client = dtoMapper.fromClientDTO(clientDto);
        Client savedClient = clientRepository.save(client);
        return dtoMapper.fromClient(savedClient);
    }

    @Override
    public List<ClientDto> getClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDto> clientDTOList = clients.stream()
                .map(cl-> dtoMapper.fromClient(cl))
                .collect(Collectors.toList());
        return clientDTOList;
    }

    @Override
    public ClientDto getClientById(Long id) {
        Client client = clientRepository.findById(id).get();
        return dtoMapper.fromClient(client);
    }

//    @Override
//    public ClientDto updateClient(ClientDto clientDto) {
//        Client client = dtoMapper.fromClientDto(clientDto);
//        Client savedClient = clientRepository.save(client);
//        return dtoMapper.fromClient(savedClient);
//    }

//    @Override
//    public void deleteClient(Long clientId) {
//        clientRepository.deleteById(clientId);
//    }

    @Override
    public WalletDto saveWallet(Long clientId) {
        Client client = clientRepository.findById(clientId).get();
        Wallet wallet = Wallet.builder()
                .id(UUID.randomUUID().toString())
                .solde(Math.random() * 10000)
                .client(client)
                .dateCreation(new Date())
                .devise("MAD")
                .build();
        Wallet savedWallet = walletRepository.save(wallet);
        return dtoMapper.fromWallet(savedWallet);

    }


    @Override
    public List<WalletDto> getAllWallets() {
        List<Wallet> wallets = walletRepository.findAll();
        List<WalletDto> walletDtos = wallets.stream()
                .map(wall -> dtoMapper.fromWallet(wall))
                .collect(Collectors.toList());
        return walletDtos;
    }

    @Override
    public WalletDto getWallet(String walletId) {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow();
        return dtoMapper.fromWallet(wallet);
    }

    @Override
    public WalletDto updateWallet(WalletDto wall) {
        Wallet wallet = dtoMapper.fromWalletDTO(wall);
        Wallet savedWallet = walletRepository.save(wallet);
        return dtoMapper.fromWallet(savedWallet);
    }

    @Override
    public void deleteWalletById(String id) {
        walletRepository.deleteWalletById(id);
    }

    @Override
    public List<WalletDto> getWalletsByClientId(Long clientId) {
        List<Wallet> wallets = walletRepository.findWalletsByClientId(clientId);
        List<WalletDto> walletDTOList = wallets.stream()
                .map(wal-> dtoMapper.fromWallet(wal))
                .collect(Collectors.toList());
        return walletDTOList;
    }
}