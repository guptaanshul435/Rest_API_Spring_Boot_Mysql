package ms.library.mylibrary.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ms.library.mylibrary.Repository.FounderRepository;
import ms.library.mylibrary.models.Founder;
import ms.library.mylibrary.utils.Validation;

@Service
public class FounderService {

	@Autowired
	FounderRepository founderRepo;
	public ResponseEntity<List<Founder>> getAllFounder() {
		try {
			return new ResponseEntity<List<Founder>>(founderRepo.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	public ResponseEntity<Founder> setFounder(Founder founder) {
		try {
			if(Validation.isValidEmail(founder.getEmail())) {
				if(Validation.isValidNumber(founder.getNumber())) {
					if(Validation.isValidName(founder.getName())) {
						return new ResponseEntity<>(founderRepo.save(founder),HttpStatus.CREATED);	
					}else {
						return new ResponseEntity("Your name is not correct please recheck it",HttpStatus.BAD_REQUEST);
					}
				}else {
					return new ResponseEntity("Your Number is not correct please recheck it",HttpStatus.BAD_REQUEST);
				}	
			}else {
				return new ResponseEntity("Your Email is not correct please recheck it",HttpStatus.BAD_REQUEST);
			}	
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity("process got failed with error message:"+e.getMessage(),HttpStatus.BAD_GATEWAY);
		}
		
		
	}
	public ResponseEntity<Founder> getFounderById(int id) {
		try {
			return new ResponseEntity(founderRepo.findById(id),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		 return new ResponseEntity("process got failed",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public ResponseEntity<List<Founder>> getFounderByNumber(String number) {
		try {
			return new ResponseEntity(founderRepo.findByNumber(number),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity("Resquest got failed please try again",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	public ResponseEntity<List<Founder>> getFounderByEmail(String em) {
		try {
			return new ResponseEntity(founderRepo.findByEmail(em),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity("Resquest got failed please try again",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	public Founder putFounder(Founder founder) {
		return founderRepo.save(founder);
	}
	public ResponseEntity<String> deleteFounder(int id) {
		if(founderRepo.existsById(id)) {
			founderRepo.deleteById(id);	
		}else {
			return new ResponseEntity<String>("Id ="+id+" not found",HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<String>("Id ="+id+" is deleted",HttpStatus.ACCEPTED);
	}

}
