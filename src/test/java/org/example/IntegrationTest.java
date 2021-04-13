package org.example;

import org.example.Domain.Nota;
import org.example.Domain.Student;
import org.example.Domain.TemaLab;
import org.example.Exceptions.ValidatorException;
import org.example.Repository.MemoryRepository.NotaRepo;
import org.example.Repository.MemoryRepository.StudentRepo;
import org.example.Repository.MemoryRepository.TemaLabRepo;
import org.example.Repository.XMLFileRepository.TemaLabXMLRepo;
import org.example.Validator.NotaValidator;
import org.example.Validator.StudentValidator;
import org.example.Validator.TemaLabValidator;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class IntegrationTest {
    @Test()
    public void tc_AddStudent() {
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

    @Test
    public void tc_AddAssignment() {
        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabRepo temaLabRepo = new TemaLabRepo(temaLabValidator);
        try {
            temaLabRepo.save(new TemaLab(7, "description", 2, 10));
            assertEquals(7, (int) temaLabRepo.findOne(7).getId());
        } catch (ValidatorException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void tc_AddGrade() {
        NotaValidator notaValidator = new NotaValidator();
        NotaRepo notaRepo = new NotaRepo(notaValidator);
        try {
            notaRepo.save(new Nota(7, "7", 7, 7.5, LocalDateTime.now()));
            assertEquals(7, (int) notaRepo.findOne(7).getId());
        } catch (ValidatorException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void tc_AddAll() {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepo studentRepo = new StudentRepo(studentValidator);
        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabRepo temaLabRepo = new TemaLabRepo(temaLabValidator);
        NotaValidator notaValidator = new NotaValidator();
        NotaRepo notaRepo = new NotaRepo(notaValidator);
        try {
            studentRepo.save(new Student(7,"Valid Name","937","email@email.com","Valid Name"));
            assertEquals(7, (int) studentRepo.findOne(7).getId());
            temaLabRepo.save(new TemaLab(7, "description", 2, 10));
            assertEquals(7, (int) temaLabRepo.findOne(7).getId());
            notaRepo.save(new Nota(7, "7", 7, 7.5, LocalDateTime.now()));
            assertEquals(7, (int) notaRepo.findOne(7).getId());
        } catch (ValidatorException e) {
            e.printStackTrace();
            fail();
        }
    }
}
