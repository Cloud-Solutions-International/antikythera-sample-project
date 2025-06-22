package sa.com.cloudsolutions.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import sa.com.cloudsolutions.model.Department;
import sa.com.cloudsolutions.model.Person;

import java.util.List;

public class Util {

    public static String toJson() throws JsonProcessingException {
        Person person = new Person("Hornblower","Admiralty House","Le Harve","governor@leharve.fr");
        Department department = new Department();
        department.setId(1L);
        department.setPersons(List.of(person));

        person.setDepartment(department);

        // Use Jackson ObjectMapper which respects the @JsonManagedReference and @JsonBackReference annotations
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(person);

    }

    public static void main(String[] args) throws JsonProcessingException {
        String json = toJson();
        System.out.println(json);
    }
}
