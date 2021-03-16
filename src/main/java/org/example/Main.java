package org.example;

import org.example.Exceptions.*;
import org.example.Repository.MemoryRepository.NotaRepo;
import org.example.Repository.MemoryRepository.StudentRepo;
import org.example.Repository.MemoryRepository.TemaLabRepo;
import org.example.Repository.TxtFileRepository.NotaFileRepo;
import org.example.Repository.TxtFileRepository.StudentFileRepo;
import org.example.Repository.TxtFileRepository.TemaLabFileRepo;
import org.example.Repository.XMLFileRepository.NotaXMLRepo;
import org.example.Repository.XMLFileRepository.StudentXMLRepo;
import org.example.Repository.XMLFileRepository.TemaLabXMLRepo;
import org.example.Service.TxtFileService.NotaService;
import org.example.Service.TxtFileService.StudentService;
import org.example.Service.TxtFileService.TemaLabService;
import org.example.Service.XMLFileService.NotaXMLService;
import org.example.Service.XMLFileService.StudentXMLService;
import org.example.Service.XMLFileService.TemaLabXMLService;
import org.example.Validator.*;
import org.example.UI.*;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {

    public static void callFunctionalities() throws IOException {
        //initialization
        StudentValidator studentValidator = new StudentValidator();
        TemaLabValidator temaLabValidator = new TemaLabValidator();
        NotaValidator notaValidator = new NotaValidator();
        StudentFileRepo studentFileRepo = new StudentFileRepo("students.txt", studentValidator);
        TemaLabFileRepo temaLabRepo = new TemaLabFileRepo("assignments.txt", temaLabValidator);
        NotaFileRepo notaFileRepo = new NotaFileRepo("grades.txt", notaValidator);
        StudentService studentService = new StudentService(studentFileRepo);
        TemaLabService temaLabService = new TemaLabService(temaLabRepo);
        NotaService notaService = new NotaService(notaFileRepo);

        //add student
        try {
            studentService.add(new String[]{"abc", "First Last", "100", "email", "Name Teacher"});
        } catch (ValidatorException e) {
            System.out.println("Invalid student.");
        }

        //add assignment
        try {
            temaLabService.add(new String[]{"6", "Description", "7", "3"});
        } catch (ValidatorException e) {
            System.out.println("Invalid assignment.");
        }

        //add grade
        try {
            notaService.add(new String[]{"3", "abc", "6", "8.7", "2021-03-03T10:15:30"});
        } catch (ValidatorException e) {
            System.out.println("Invalid grade.");
        }
    }

    public static void main(String[] args) throws IOException, ValidatorException {
        callFunctionalities();

        //System.out.println("Hello World!");
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
        NotaXMLService ntsrv=new NotaXMLService(ntrepo);
        ui ui=new ui(stsrv,tmsrv,ntsrv);
        ui.run();
    }
}