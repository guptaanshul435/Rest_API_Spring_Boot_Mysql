package ms.library.mylibrary.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ms.library.mylibrary.Services.MentorService;
import ms.library.mylibrary.models.Mentor;

@RestController
@RequestMapping("mentor")
public class MentorController {

	
	@Autowired
	MentorService mentorService;
	
	
	@GetMapping("allmentor")
	public List<Mentor> getAllMentor(){
		return mentorService.getAllMentor();
	}
	
	@GetMapping("id/{id}")
	public Optional<Mentor> getByMentorId(@PathVariable int id) {
		return mentorService.getByMentorId(id);
	}
	@GetMapping("name/{name}")
	public List<Mentor> getByMentorName(@PathVariable String name) {
		return mentorService.getByMentorName(name);
	}
	
	@PostMapping("addmentor")
	public String addMentor(@RequestBody Mentor mentor) {
		return mentorService.addMentor(mentor);
		
	}
	
	
}
