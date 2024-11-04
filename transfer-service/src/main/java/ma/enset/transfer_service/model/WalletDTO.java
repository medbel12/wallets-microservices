package ma.enset.transfer_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletDTO {
    private String walletId;
    private ClientDTO client;
    private double solde;
    private Date dateCreation;
    private String devise;
}
