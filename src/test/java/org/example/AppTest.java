package org.example;

import org.example.Domain.Student;
import org.example.Exceptions.ValidatorException;
import org.example.Repository.MemoryRepository.StudentRepo;
import org.example.Repository.TxtFileRepository.StudentFileRepo;
import org.example.Validator.StudentValidator;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test()
    public void tc_1_AddStudent() {
        StudentValidator studentValidator = new StudentValidator();
        try {
            StudentRepo studentRepo = new StudentRepo(studentValidator);
            studentRepo.save(new Student("10", "name", 700, "email@email", "Teacher"));
            assertEquals(studentRepo.findOne("10").getId(), "10");
        } catch (ValidatorException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(expected = ValidatorException.class)
    public void tc_2_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student("10", "name", 700, "email", "Teacher"));
    }
}
