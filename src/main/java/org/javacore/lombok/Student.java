package org.javacore.lombok;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * lombok 测试
 * Created by ddfhznq on 2017/12/26.
 */
@Data
@ToString
public class Student {

    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String name;

    @Setter
    @Getter
    private String certNo;

}
