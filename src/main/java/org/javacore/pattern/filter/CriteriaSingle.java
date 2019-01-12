package org.javacore.pattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
* className: CriteriaSingle
* Package: org.javacore.pattern.filter
* Description:
* Author:znq
* Date 19/1/8 下午2:58
*/
public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if (person.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }
}
