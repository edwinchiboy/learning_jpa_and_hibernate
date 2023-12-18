package com.in28minutes.springboot.learnjpaandhibernate.course;

//import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    //    @Autowired
//    private CourseJdbcRepository repository;
//    @Autowired
//    private CourseJpaRepository repository;
    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(final String... args) throws Exception {
//        repository.insert(new Course(1, "Learn AWS Jpa! ", "in 28 minutes"));
//        repository.insert(new Course(2, "Learn Azure Jpa! ", "in 28 minutes"));
//        repository.insert(new Course(3, "Learn Devops jpa! ", "in 28 minutes"));
//        System.out.println(repository.findById(3));

//        repository.deleteById(1);

//
        repository.save(new Course(1, "Learn AWS Jpa! ", "in 28 minutes"));
        repository.save(new Course(2, "Learn Azure Jpa!  ", "in 28 minutes"));
        repository.save(new Course(3, "Learn Devops jpa!", "in 28 minutes"));

        repository.deleteById(1L);
        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));
        System.out.println(repository.findAll());
        System.out.println(repository.count());


    }
}
