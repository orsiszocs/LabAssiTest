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
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        try {
            studentRepo.save(new Student(7,"Valid Name","937","email@email.com","Valid Name"));
            assertEquals(7, (int) studentRepo.findOne(7).getId());
        } catch (ValidatorException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(expected = ValidatorException.class)
    public void tc_2_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(1,"i","i","@email.com","i "));
    }

    @Test(expected = ValidatorException.class)
    public void tc_3_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(2,"ii","ii","email@.com", "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii iiiiiiiiiiiiiiiiiii"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_4_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(999,"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii","iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii","e;mail@email.com","iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii iiiiiiiiiiiiiiiiiiii"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_5_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(10000,"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii", "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii","email@email","Valid Name"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_6_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(7,"Valid Name","937","iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii@email.com","Valid Name"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_7_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(7,"Valid Name","937","","Valid Name"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_8_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(7,"Valid Name","","email@email.com","Valid Name"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_9_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(7,"Valid Name","iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii", "email@email.com","Valid Name"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_10_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(7,"Valid Name","937","email@email.com",""));
    }

    @Test(expected = ValidatorException.class)
    public void tc_11_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(7,"Valid Name","937","email@email.com", "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_12_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(0,"Valid Name","937","email@email.com","Valid Name"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_13_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(10001,"Valid Name","937","email@email.com","Valid Name"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_14_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(7,"","937","email@email.com","Valid Name"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_15_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(7,"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii", "937","email@email.com","Valid Name"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_16_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(7,"Valid Name","937","emailemail.com","Valid Name"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_17_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(7,"Valid Name","gr;oup", "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii@yahoo.com","Valid Name"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_18_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(7,"Valid Name","937", "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii@yahoo.com","Invalid; Name"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_19_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(7,"Valid Name","937","a@email.com","InvalidName"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_20_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(7,"Invalid; Name","937","aa@email.com","Valid Name"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_21_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(7,"Valid Name","937","i","Valid Name"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_22_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(7,"Valid Name","937","ii","Valid Name"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_23_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(7,"Valid Name","937","@email.com","Valid Name"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_24_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(7,"Valid Name","937","a@.com","Valid Name"));
    }

    @Test(expected = ValidatorException.class)
    public void tc_25_AddStudent() throws ValidatorException {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        studentRepo.save(new Student(7,"Valid Name","937","email@email.com","i"));
    }

    @Test
    public void tc_26_AddStudent() {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        try {
            studentRepo.save(new Student(7,"Valid Name","937","a@a.com","Valid Name"));
            assertEquals(7, (int) studentRepo.findOne(7).getId());
        } catch (ValidatorException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void tc_27_AddStudent() {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        try {
            studentRepo.save(new Student(7,"Valid Name","937","a@aa.com","Valid Name"));
            assertEquals(7, (int) studentRepo.findOne(7).getId());
        } catch (ValidatorException e) {
            e.printStackTrace();
            fail();
        }
    }
}
