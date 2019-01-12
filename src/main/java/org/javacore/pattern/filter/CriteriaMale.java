package org.javacore.pattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
* className: CriteriaMale
* Package: org.javacore.pattern.filter
* Description:
* Author:znq
* Date 19/1/8 下午2:57
*/
public class CriteriaMale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("MALE")) {
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}
