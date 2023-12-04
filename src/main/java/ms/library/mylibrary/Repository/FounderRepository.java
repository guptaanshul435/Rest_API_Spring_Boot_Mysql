package ms.library.mylibrary.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ms.library.mylibrary.models.Founder;

@Repository
public interface FounderRepository extends JpaRepository<Founder, Integer> {

	List<Founder> findByNumber(String number);

	List<Founder> findByEmail(String email);


}
