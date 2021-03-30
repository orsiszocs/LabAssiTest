package org.example;

import org.example.Domain.Student;
import org.example.Domain.TemaLab;
import org.example.Exceptions.ValidatorException;
import org.example.Repository.MemoryRepository.StudentRepo;
import org.example.Repository.MemoryRepository.TemaLabRepo;
import org.example.Repository.TxtFileRepository.StudentFileRepo;
import org.example.Validator.StudentValidator;
import org.example.Validator.TemaLabValidator;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class WBTest
{

    @Test()
    public void tc_1_AddAssignment() {
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

    @Test(expected = ValidatorException.class)
    public void tc_2_AddAssignment() throws ValidatorException {
        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabRepo temaLabRepo = new TemaLabRepo(temaLabValidator);
        temaLabRepo.save(new TemaLab(7, "description", 100, 10));
    }
}
