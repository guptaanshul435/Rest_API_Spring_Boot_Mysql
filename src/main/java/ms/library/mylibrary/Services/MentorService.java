package ms.library.mylibrary.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms.library.mylibrary.Repository.MentorRepository;
import ms.library.mylibrary.models.Mentor;

@Service
public class MentorService {
	
	@Autowired
	MentorRepository mentorRepo;

	public List<Mentor> getAllMentor() {
		return mentorRepo.findAll();
	}

	public String addMentor(Mentor mentor) {
		// TODO Auto-generated method stub
		 mentorRepo.save(mentor);
		 return "resource is add successfully!!!";
	}

	public Optional<Mentor> getByMentorId(int id) {
		return mentorRepo.findById(id);
		
	}

	public List<Mentor> getByMentorName(String name) {
		
		return mentorRepo.findByName(name);
	}

}
