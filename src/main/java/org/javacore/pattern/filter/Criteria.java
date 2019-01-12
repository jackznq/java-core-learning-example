package org.javacore.pattern.filter;

import java.util.List;

/**
* className: Criteria
* Package: org.javacore.pattern.filter
* Description:
* Author:znq
* Date 19/1/8 下午2:57
*/
public interface Criteria {


    List<Person> meetCriteria(List<Person> persons);
}
