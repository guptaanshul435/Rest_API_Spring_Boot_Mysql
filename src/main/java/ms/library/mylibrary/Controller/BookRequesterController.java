package ms.library.mylibrary.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ms.library.mylibrary.Services.BookRequestService;
import ms.library.mylibrary.models.Requester;

@RestController
@RequestMapping("requester")
public class BookRequesterController {
	
	@Autowired
	BookRequestService requesterService;

	@GetMapping("allrequester")
	public List<Requester> getAllRequester() {
		return requesterService.getAllRequester();	
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<Requester> getRequesterById(@PathVariable int id) {
		return requesterService.getRequesterById(id);
	}
	
	@GetMapping("number/{number}")
	public List<Requester> getRequesterByNumber(@PathVariable String number) {
		return requesterService.getRequesterByNumber(number);
	}
	
	@GetMapping("examtarget/{examTarget}")
	public List<Requester> getRequesterByExamTarget(@PathVariable String examTarget) {
		return requesterService.getRequesterByExamTarget(examTarget);
	}
	
	@GetMapping("bookrequest/{book_request}")
	public List<Requester> getRequesterByBookRquest(@PathVariable String book_request) {
		return requesterService.getRequesterByBookRquest(book_request);
	}
	
	@PostMapping("addrequester")
	public ResponseEntity<String> addRequester(@RequestBody Requester requester) {
		return requesterService.addRequester(requester);
	}
	
	@DeleteMapping("remove/{id}")
	public String removeRequester(@PathVariable int id) {
		return requesterService.removeRequester(id);
		
	}
	
}
