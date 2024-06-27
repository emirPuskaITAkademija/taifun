package ba.smoki.taifun;

import ba.smoki.taifun.demo.ServiceOperationExecutor;
import ba.smoki.taifun.demo.Taifun;
import ba.smoki.taifun.entity.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static ba.smoki.taifun.demo.PostpaidServiceActivationOperation.POSTPAID_ACTIVATION;
@SpringBootApplication
public class TaifunApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ServiceOperationExecutor serviceOperationExecutor;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(TaifunApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		serviceOperationExecutor.triggerServiceOperationExecution(POSTPAID_ACTIVATION);
		//		User user = userRepository.findByUsername("ferid.bobar");
//		if(user == null){
//			user = new User();
//			user.setUsername("ferid.bobar");
//			String plainPassword = "bobar123";
//			String hashedPassword = passwordEncoder.encode(plainPassword);
//			user.setPassword(hashedPassword);
//			user.setRole("USER");
//			user.setEmail("ferid.bobar@gmail.com");
//			user.setFirstName("Ferid");
//			user.setLastName("Bobar");
//			userRepository.save(user);
//		}
	}
}
