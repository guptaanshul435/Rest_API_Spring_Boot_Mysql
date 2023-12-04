package ms.library.mylibrary.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ms.library.mylibrary.Services.FounderService;
import ms.library.mylibrary.models.Founder;

@RestController
@RequestMapping("founder")
public class FounderController {

	@Autowired
	FounderService founderService;
	
	@GetMapping("allfounder")
	public ResponseEntity<List<Founder>> getAllFounder() {
		return founderService.getAllFounder();
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<Founder> getFounderById(@PathVariable int id) {
		return founderService.getFounderById(id);
	}
	
	@GetMapping("number/{number}")
	public ResponseEntity<List<Founder>> getFounderByNumber(@PathVariable("number")String number){
		return founderService.getFounderByNumber(number);
	}
	@GetMapping("email/{email}")
	public ResponseEntity<List<Founder>> getFounderByEmail(@PathVariable("email") String em){
		return founderService.getFounderByEmail(em);
	}
	
	@PutMapping("putfounder")
	public Founder putFounder(@RequestBody Founder founder) {
		return founderService.putFounder(founder);
	}
	
	@DeleteMapping("remove/{id}")
	public ResponseEntity<String> deleteFounder(@PathVariable int id) {
		return founderService.deleteFounder(id);
		
	}
	
	@PostMapping("addfounder")
	public ResponseEntity<Founder> setFounder(@RequestBody Founder founder) {
		return founderService.setFounder(founder);
	}
	
	
	
}
