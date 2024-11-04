package ma.enset.wallet_service;

import ma.enset.wallet_service.entities.Client;

import ma.enset.wallet_service.repositories.ClientPepository;
import ma.enset.wallet_service.services.WalletServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.stream.Stream;

@SpringBootApplication
public class WalletServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ClientPepository clientPepository,
							WalletServiceImpl walletService){
		return  args -> {
			Stream.of("mohamed","ibrahim","Anouar").forEach(name->{
				Client client=new Client();
				client.setNom(name);
				client.setEmail(name+"@gmail.com");
				clientPepository.save(client);
			});
			walletService.getClients().forEach(client->{
				for (int i = 0; i < 3; i++) {
					walletService.saveWallet(client.getId());
				}

            });

		};
	}

}
