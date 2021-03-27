package org.example.Repository.XMLFileRepository;

import org.example.Domain.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.example.Validator.StudentValidator;


public class StudentXMLRepo extends AbstractXMLRepo<Integer, Student> {
    //private String fileName;

    public StudentXMLRepo(StudentValidator v, String fileName) {
        super(v,fileName);
    }

    @Override
    protected Element createElementFromEntity(Document document,Student s) {
        Element root = document.getDocumentElement();
        Element e = document.createElement("student");
        e.appendChild(createElement("id", document, s.getId().toString()));
        e.appendChild(createElement("nume", document, s.getNume()));
        e.appendChild(createElement("grupa", document, s.getGrupa()));
        e.appendChild(createElement("email", document, s.getEmail()));
        e.appendChild(createElement("profesor", document, s.getIndrumator()));
        return e;
    }


    @Override
    protected Student createEntityFromElement(Element studentElement){
        int id=Integer.parseInt(studentElement
                .getAttribute("id"));
        String nume=studentElement
                .getElementsByTagName("nume")
                .item(0)
                .getTextContent();
        String grupa=studentElement
                .getElementsByTagName("grupa")
                .item(0)
                .getTextContent();
        String gr=grupa;
        String email=studentElement
                .getElementsByTagName("email")
                .item(0)
                .getTextContent();
        String prof=studentElement
                .getElementsByTagName("prof")
                .item(0)
                .getTextContent();
        return new Student(id,nume,gr,email,prof);
    }

}

