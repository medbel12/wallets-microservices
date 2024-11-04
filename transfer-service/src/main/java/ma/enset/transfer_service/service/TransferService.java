package ma.enset.transfer_service.service;

import ma.enset.transfer_service.exceptions.TransferException;
import ma.enset.transfer_service.model.TransferRequestDTO;
import ma.enset.transfer_service.model.TransferResponseDTO;
import org.springframework.stereotype.Service;


public interface TransferService {
    TransferResponseDTO transfer(TransferRequestDTO transferRequest) throws TransferException;

}
