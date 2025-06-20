package ms_courses_db.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ms_courses_db.model.entities.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
