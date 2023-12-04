package ms.library.mylibrary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ms.library.mylibrary.models.Donator;

@Repository
public interface DonatorRepository extends JpaRepository<Donator, Integer> {


}
