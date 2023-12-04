package ms.library.mylibrary.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ms.library.mylibrary.Repository.BookRequesterRepository;
import ms.library.mylibrary.models.Requester;
import ms.library.mylibrary.utils.Validation;

@Service
public class BookRequestService {
	
	@Autowired
	BookRequesterRepository requesterRepo;

	public List<Requester> getAllRequester() {
		return requesterRepo.findAll();
	}

	public ResponseEntity<String> addRequester(Requester requester) {
		if(Validation.isValidEmail(requester.getEmail())) {
			if(Validation.isValidNumber(requester.getMobile())) {
				if(Validation.isValidName(requester.getName())) {
					requesterRepo.save(requester);
				}else {
					return new ResponseEntity<String>("Your name is not correct",HttpStatus.BAD_REQUEST);
				}
			}else {
				return new ResponseEntity<String>("Your mob num is not correct",HttpStatus.BAD_REQUEST);
			}
		}else {
			return new ResponseEntity<String>("Your email is not correct",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("your data is saved",HttpStatus.CREATED);	
	}

	public ResponseEntity<Requester> getRequesterById(int id) {
		if(!requesterRepo.existsById(id)) {
			return new ResponseEntity("Id="+id+"not found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(requesterRepo.findById(id),HttpStatus.FOUND);
	}

	public List<Requester> getRequesterByNumber(String number) {
		return requesterRepo.findByMobile(number);
	}

	public List<Requester> getRequesterByExamTarget(String examTarget) {
		
		return requesterRepo.findByexamTarget(examTarget);
	}

	public List<Requester> getRequesterByBookRquest(String book_request) {
		
		return requesterRepo.findBybookRequest(book_request);
	}

	public String removeRequester(int id) {
		 requesterRepo.deleteById(id);
		return "resource is deleted";
	}

	
}
