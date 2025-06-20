package ms_courses_db.service;
//import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ms_courses_db.model.dto.CourseDTO;
import ms_courses_db.model.entities.Course;
import ms_courses_db.model.repository.CourseRepository;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public CourseDTO findCourseById(Long id){
        Optional<Course> course = courseRepository.findById(id);
        CourseDTO courseDTO = null;

        if(course.isPresent()) {
            courseDTO = traslateEntityToDTO(course.get());
        }
        return courseDTO; 
    }

    private CourseDTO traslateEntityToDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setTitle(course.getTitle());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setInstructorId(course.getInstructorId());
        courseDTO.setPrice(course.getPrice());
        return courseDTO;
    }

    /*public List<Course> selectAllCourses(){
       List<Course> listaCursos = courseRepository.findAll();
      return listaCursos;
    }*/ 

}
