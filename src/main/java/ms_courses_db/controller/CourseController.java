package ms_courses_db.controller;

import org.springframework.web.bind.annotation.RestController;
import ms_courses_db.model.dto.CourseDTO;
//import ms_courses_db.model.entities.Course;
import ms_courses_db.service.CourseService;
//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;
    
    @GetMapping("/{id:\\d+}")
    public ResponseEntity<CourseDTO> findCourseById(@PathVariable(name = "id") Long id) {
        CourseDTO CourseDTO = courseService.findCourseById(id);
        if (CourseDTO != null) {
            return ResponseEntity.ok(CourseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


  
