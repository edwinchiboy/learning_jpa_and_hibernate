package com.in28minutes.springboot.learnjpaandhibernate.course.Jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {


    public CourseJdbcRepository(final JdbcTemplate springJbdcTemplate) {
        this.springJbdcTemplate = springJbdcTemplate;
    }

    private JdbcTemplate springJbdcTemplate;

    private static String INSERT_QUERY =
        """
            insert into course (id, name, author) 
            values(?,?, ?)
            """;
    private static String DELETE_QUERY =
        """
            delete from course
            where id = ?
            """;
    private static String SELECT_QUERY =
        """
            select * from course
            where id = ?
            """;


    public void insert(Course course) {
        springJbdcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        springJbdcTemplate.update(DELETE_QUERY, id);

    }

    public Course findById(long id) {
        return springJbdcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);

    }
}
