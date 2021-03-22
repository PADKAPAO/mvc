package kmitl.charanpat.mvc.model.repository;

import kmitl.charanpat.mvc.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query(value = "select * from student order by temperature desc limit 100",nativeQuery = true)
    List<Student> findTop10();
}
