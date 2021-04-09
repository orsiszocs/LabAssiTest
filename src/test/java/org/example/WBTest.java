package org.example;

import org.example.Domain.Student;
import org.example.Domain.TemaLab;
import org.example.Exceptions.ValidatorException;
import org.example.Repository.MemoryRepository.StudentRepo;
import org.example.Repository.MemoryRepository.TemaLabRepo;
import org.example.Repository.TxtFileRepository.StudentFileRepo;
import org.example.Repository.XMLFileRepository.TemaLabXMLRepo;
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
    @Test(expected = IllegalArgumentException.class)
    public void tc_1_AddAssignment() {
        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabXMLRepo temaLabRepo = new TemaLabXMLRepo(temaLabValidator, "labs1");
        try {
            temaLabRepo.save(null);
            fail();
        } catch (ValidatorException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(expected = ValidatorException.class)
    public void tc_2_AddAssignment() throws ValidatorException {
        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabXMLRepo temaLabRepo = new TemaLabXMLRepo(temaLabValidator, "labs2");
        temaLabRepo.save(new TemaLab(7, null, 2, 10));
    }

    @Test(expected = ValidatorException.class)
    public void tc_3_AddAssignment() throws ValidatorException {
        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabXMLRepo temaLabRepo = new TemaLabXMLRepo(temaLabValidator, "labs3");
        temaLabRepo.save(new TemaLab(7, "description", -1, 10));
    }

    @Test(expected = ValidatorException.class)
    public void tc_4_AddAssignment() throws ValidatorException {
        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabXMLRepo temaLabRepo = new TemaLabXMLRepo(temaLabValidator, "labs4");
        temaLabRepo.save(new TemaLab(7, "description", 2, -1));
    }

    @Test
    public void tc_5_AddAssignment() {
        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabXMLRepo temaLabRepo = new TemaLabXMLRepo(temaLabValidator, "labs5");
        try {
            temaLabRepo.save(new TemaLab(7, "description", 2, 10));
            assertEquals(7, (int) temaLabRepo.findOne(7).getId());
        } catch (ValidatorException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void tc_6_AddAssignment() {
        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabXMLRepo temaLabRepo = new TemaLabXMLRepo(temaLabValidator, "labs6");
        try {
            temaLabRepo.save(new TemaLab(7, "description", 2, 10));
            assertEquals(7, (int) temaLabRepo.findOne(7).getId());
            assertEquals(temaLabRepo.getSize(), 1);
            assertNotEquals(null, temaLabRepo.save(new TemaLab(7, "description", 2, 10)));
            assertEquals(temaLabRepo.getSize(), 1);
        } catch (ValidatorException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void tc_7_AddAssignment() {
        TemaLabValidator temaLabValidator = new TemaLabValidator();
        TemaLabXMLRepo temaLabRepo = new TemaLabXMLRepo(temaLabValidator, "labs7");
        try {
            temaLabRepo.save(new TemaLab(7, "description", 2, 10));
            temaLabRepo.save(new TemaLab(8, "description", 2, 10));
            assertEquals(temaLabRepo.getSize(), 2);
            assertNotEquals(null, temaLabRepo.save(new TemaLab(7, "description", 2, 10)));
            assertEquals(temaLabRepo.getSize(), 2);
        } catch (ValidatorException e) {
            e.printStackTrace();
            fail();
        }
    }

//    @Test()
//    public void tc_1_AddAssignment() {
//        TemaLabValidator temaLabValidator = new TemaLabValidator();
//        TemaLabRepo temaLabRepo = new TemaLabRepo(temaLabValidator);
//        try {
//            temaLabRepo.save(new TemaLab(7, "description", 2, 10));
//            assertEquals(7, (int) temaLabRepo.findOne(7).getId());
//        } catch (ValidatorException e) {
//            e.printStackTrace();
//            fail();
//        }
//    }
//
//    @Test(expected = ValidatorException.class)
//    public void tc_2_AddAssignment() throws ValidatorException {
//        TemaLabValidator temaLabValidator = new TemaLabValidator();
//        TemaLabRepo temaLabRepo = new TemaLabRepo(temaLabValidator);
//        temaLabRepo.save(new TemaLab(7, "description", 100, 10));
//    }
}
