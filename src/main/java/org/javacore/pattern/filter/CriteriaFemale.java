package org.javacore.pattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * className: CriteriaFemale
 * Package: org.javacore.pattern.filter
 * Description:
 * Author:znq
 * Date 19/1/8 下午2:58
 */
public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("FEMALE")) {
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
