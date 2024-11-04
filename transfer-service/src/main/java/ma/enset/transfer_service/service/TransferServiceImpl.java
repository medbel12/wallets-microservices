package ma.enset.transfer_service.service;

import lombok.AllArgsConstructor;
import ma.enset.transfer_service.Repositories.TransferRepository;
import ma.enset.transfer_service.feign.WalletRestClient;
import ma.enset.transfer_service.model.TransferRequestDTO;
import ma.enset.transfer_service.model.TransferResponseDTO;
import ma.enset.transfer_service.model.WalletDTO;
import ma.enset.transfer_service.entities.Transfer;
import ma.enset.transfer_service.exceptions.TransferException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class TransferServiceImpl implements TransferService {

    private  WalletRestClient walletRestClient;
    private TransferRepository transferRepository;

    @Override
    public TransferResponseDTO transfer(TransferRequestDTO transferRequest) throws TransferException {
        WalletDTO sourceWallet = walletRestClient.getWalletById(transferRequest.getSourceWalletId());
        WalletDTO destinationWallet = walletRestClient.getWalletById(transferRequest.getDestinationWalletId());

        if (sourceWallet.getSolde() < transferRequest.getAmount()) {
            throw new TransferException("Insufficient funds in source wallet");
        }

        sourceWallet.setSolde(sourceWallet.getSolde() - transferRequest.getAmount());
        destinationWallet.setSolde(destinationWallet.getSolde() + transferRequest.getAmount());

        walletRestClient.saveWallet(sourceWallet);
        walletRestClient.saveWallet(destinationWallet);

        Transfer transfer = Transfer.builder()
                .walletSource(transferRequest.getSourceWalletId())
                .walletDest(transferRequest.getDestinationWalletId())
                .amount(transferRequest.getAmount())
                .build();
        transferRepository.save(transfer);

        return new TransferResponseDTO(sourceWallet, destinationWallet);
    }
}