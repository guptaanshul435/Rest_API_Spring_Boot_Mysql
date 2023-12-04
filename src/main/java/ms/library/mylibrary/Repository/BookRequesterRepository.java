package ms.library.mylibrary.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ms.library.mylibrary.models.Requester;

@Repository
public interface BookRequesterRepository extends JpaRepository<Requester, Integer> {

	List<Requester> findByMobile(String mobile);

	List<Requester> findByexamTarget(String exam_target);

	List<Requester> findBybookRequest(String book_request);

}
