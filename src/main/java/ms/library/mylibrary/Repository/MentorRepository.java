package ms.library.mylibrary.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ms.library.mylibrary.models.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Integer>{

	List<Mentor> findByName(String name);

}
