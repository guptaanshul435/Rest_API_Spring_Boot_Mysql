package ms.library.mylibrary.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ms.library.mylibrary.Repository.DonatorRepository;
import ms.library.mylibrary.models.Donator;
import ms.library.mylibrary.utils.Validation;

@Service
public class DonatorService {
	
	@Autowired
	DonatorRepository donatorRepo;

	public ResponseEntity<List<Donator>> getAllDonator() {
		try {
			return new ResponseEntity<List<Donator>>(donatorRepo.findAll(), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<List<Donator>>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<String> addDonator(Donator donator) {
		try {
			if(Validation.isValidNumber(donator.getNumber())) {
				if(Validation.isValidName(donator.getName())) {
					return new ResponseEntity(donatorRepo.save(donator),HttpStatus.CREATED);
				}else {
					return new ResponseEntity("Mobile Name is not correct: Please provide corrent mobile number",HttpStatus.CHECKPOINT);
				}
				
			}else {
				return new ResponseEntity("Mobile Number is not correct: Please provide corrent mobile number",HttpStatus.CHECKPOINT);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Your Resource is not created successfully | Messege:"+e.getMessage(),HttpStatus.BAD_GATEWAY);
		}
		
		
	}

}
