package ms.library.mylibrary.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ms.library.mylibrary.Services.DonatorService;
import ms.library.mylibrary.models.Donator;

@RestController
@RequestMapping("donator")
public class DonatorController {
	
	@Autowired
	DonatorService donatorService;
	
	@GetMapping("alldonator")
	public ResponseEntity<List<Donator>> getAllDonator(){
		return donatorService.getAllDonator();
	}
	
	@PostMapping("adddonator")
	public ResponseEntity<String> addDonator(@RequestBody Donator donator) {
		return donatorService.addDonator(donator);
	}
	
	

}
