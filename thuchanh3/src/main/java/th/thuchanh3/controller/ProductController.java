package th.thuchanh3.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;
import th.thuchanh3.database.Database;
import th.thuchanh3.model.Product;

@Log4j2
@Controller
@RequestMapping("/index")
public class ProductController {
    @Autowired
    private Database db;

    @GetMapping("/products")
    public String getAllProducts(Model model){
        List<Product> list = db.getAllProducts();
        model.addAttribute("listP", list);
        return "/products";
    }

    @GetMapping("/newProduct")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		return "/new_product";
	}

	@PostMapping("/saveProduct")
	public String saveNewProduct(@ModelAttribute("product") Product product, Model model) {
		if(!db.checkValidCode(product.getCode())) {
			model.addAttribute("product", product);
			model.addAttribute("errorCode", "Không được để trống");
			return "/new_product";
		}
		else if(product.getDescription().trim().equals("")) {
			model.addAttribute("product", product);
			model.addAttribute("errorDes", "Không được để trống");
			return "/new_product";
		}
		else if(!db.isNumeric(String.valueOf(product.getPrice()))) {
			model.addAttribute("product", product);
			model.addAttribute("errorPrice", "Nhập số");
			return "/new_product";
		}
		else {
			db.saveProduct(product);
			return "redirect:/index/products";
		}
		
	}

	@GetMapping("/update/{code}")
	public String updateProduct(@PathVariable("code") String code,Model model) {
		Product product = db.getProductByCode(code);
		model.addAttribute("product", product);
		return "/update_product";
	}

	@PostMapping("/saveupdate/{code}")
	public String saveUpdate(@PathVariable("code") String code,
			Model model,
			@ModelAttribute("product") Product product) {
		if(product.getDescription().trim().equals("")) {
			model.addAttribute("product", product);
			model.addAttribute("errorDes", "Không được để trống");
			return "/update_product";
		}
		else if(!db.isNumeric(String.valueOf(product.getPrice()))) {
			model.addAttribute("product", product);
			model.addAttribute("errorPrice", "Nhập số");
			return "/update_product";
		}
		else {
			Product p = db.getProductByCode(code);
			db.saveUpdateProduct(p, product);
			return "redirect:/index/products";
		}
	}

	@GetMapping("/delete/{code}")
	public String delete(@PathVariable("code") String code ,Model model) {
		Product product = db.getProductByCode(code);
		model.addAttribute("product", product);
		return "/delete";
	}
	
	@PostMapping("/confirmDelete/{code}")
	public String confirmDelete(@PathVariable("code") String code) {
		db.deleteProduct(code);
		return "redirect:/index/products";
	}

    @GetMapping()
    public String home(){
        return "/index";
    }
}
