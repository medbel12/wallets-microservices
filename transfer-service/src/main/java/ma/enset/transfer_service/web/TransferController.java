package ma.enset.transfer_service.web;

import ma.enset.transfer_service.model.TransferRequestDTO;
import ma.enset.transfer_service.model.TransferResponseDTO;
import ma.enset.transfer_service.exceptions.TransferException;
import ma.enset.transfer_service.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    private  TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public TransferResponseDTO transfer(@RequestBody TransferRequestDTO transferRequest) throws TransferException {
        return transferService.transfer(transferRequest);
    }
}