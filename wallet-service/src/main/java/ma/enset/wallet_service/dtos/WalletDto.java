package ma.enset.wallet_service.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletDto {

    private String id;
    private double solde;
    private Date dateCreation;
    private String devise;
    private ClientDto client;
}
