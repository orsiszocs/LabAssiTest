package org.example.Service.XMLFileService;

import org.example.Domain.Student;
import org.example.Repository.XMLFileRepository.StudentXMLRepo;

public class StudentXMLService extends AbstractXMLService<Integer,Student>{
    private StudentXMLRepo xmlrepo;

    public StudentXMLService(StudentXMLRepo xmlrepo)  {
        super(xmlrepo);
    }

    @Override
    protected Student extractEntity(String[] params){
        return new Student(Integer.parseInt(params[0]),params[1],params[2],params[3],params[4]);
    }

}