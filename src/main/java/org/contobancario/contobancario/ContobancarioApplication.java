package org.contobancario.contobancario;

import java.util.Optional;

import org.contobancario.contobancario.db.pojo.ContoBancario;
import org.contobancario.contobancario.db.serv.ContoBancarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContobancarioApplication implements CommandLineRunner {
	
	@Autowired
	private ContoBancarioService contoService;

	public static void main(String[] args) {
		SpringApplication.run(ContobancarioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			ContoBancario c1 = new ContoBancario();
			ContoBancario c2 = new ContoBancario();
			ContoBancario c3 = new ContoBancario();
	
			c1.deposita(100);
			c2.deposita(200);
			c3.deposita(300);

			c1.preleva(50);
			c2.preleva(50);
			c3.preleva(50);
	
			System.out.println(c1);
			System.out.println(c2);
			System.out.println(c3);
	
			contoService.save(c1);
			contoService.save(c2);
			contoService.save(c3);
	
			System.out.println("------------------------------");
	
			contoService.getAllContoBancario().forEach(System.out::println);
			
			System.out.println("------------------------------");
	
			Optional<ContoBancario> oldContOpt = contoService.getContoBancarioById(1);
	
			if (oldContOpt.isEmpty()) {
				System.out.println("Conto not found!");
				return;
			}


			ContoBancario oldCont = oldContOpt.get();
			System.out.println(oldCont);

			oldCont.setId(0);
			oldCont.deposita(20);
	
			contoService.save(oldCont);
			System.out.println(oldCont);

			System.out.println("-------------BEFORE DELETE----------------");

			contoService.getAllContoBancario().forEach(System.out::println);

			contoService.delete(oldCont);

			System.out.println("-------------AFTER DELETE----------------");

			contoService.getAllContoBancario().forEach(System.out::println);

		} 

		catch (IllegalArgumentException | IllegalStateException e) {
			System.out.println(e.getMessage());
		} 
	}	
}