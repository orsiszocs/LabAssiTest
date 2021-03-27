package org.example.Validator;
import org.example.Exceptions.ValidatorException;
import org.example.Domain.Student;

public class StudentValidator implements IValidator<Student> {

    private boolean validEmail(String email) {
        if (email.length() < 5 || email.length() > 100 || !email.contains("@") || email.contains(";") || email.contains(" ")) {
            return false;
        }
        int index = email.indexOf("@");
        if (index == 0 || index == email.length() - 5) {
            return false;
        }
        if (!(email.charAt(email.length() - 1) == 'm' && email.charAt(email.length() - 2) == 'o' && email.charAt(email.length() - 3) == 'c' && email.charAt(email.length() - 4) == '.')) {
            return false;
        }
        return true;
    }

    public void validate(Student s) throws ValidatorException {
        String errors="";
        if(s.getId()<1 || s.getId()>10000){
            //throw new ValidatorException("Id invalid\n");
            errors+="Invalid id\n";
        }
        if(s.getNume()==null || s.getNume().length()==0 || s.getNume().length()>100 || s.getNume().contains(";")){
            //throw new ValidatorException("Nume invalid\n");
            errors+="Invalid name\n";
        }
        if(s.getGrupa()==null || s.getGrupa().length()==0 || s.getGrupa().length() > 100 || s.getGrupa().contains(";")) {
            errors+="Invalid group\n";
        }
        if(s.getEmail()==null || !validEmail(s.getEmail())){
            //throw new ValidatorException("Email invalid\n");
            errors+="Invalid email\n";
        }
        if(s.getIndrumator()==null || s.getIndrumator().length() == 0 || s.getIndrumator().length() > 100 || !s.getIndrumator().contains(" ") || s.getIndrumator().contains(";")) {
            errors+="Invalid professor name\n";
        }
        if (errors.length()!=0){
            throw  new ValidatorException(errors);
        }
    }
}