package th.thuchanh3;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import th.thuchanh3.model.Product;
import th.thuchanh3.repositories.ProductRepository;

@SpringBootApplication
public class Thuchanh3Application implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;
	private static final Logger logger = LoggerFactory.getLogger(Thuchanh3Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Thuchanh3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Product> list = productRepository.findAll();
		for(Product p:list){
			logger.info(p.getCode() + " " + p.getDescription() + " " + p.getPrice());
		}
		
		// Product p = productRepository.findByCode("SP1");
		// logger.info(p.getCode() + " " + p.getDescription() + " " + p.getPrice());
	}

}
