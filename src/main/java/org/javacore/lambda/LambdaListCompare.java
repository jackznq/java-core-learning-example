package org.javacore.lambda;

/*
 * Copyright [2015] [Jeff Lee]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * List 比较器
 * <p>
 * Created by bysocket on 16/7/12.
 */
public class LambdaListCompare {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(3);
        list.add(6);

//        list.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1, o2);
//            }
//        });
        List<Integer> collect = list.stream().filter(param -> param < 6).collect(Collectors.toList());
        collect.forEach(a ->
            System.out.println(a)
        );

        System.out.println();
        /** Lambda表达式格式:
         * (Type1 param1, Type2 param2, ..., TypeN paramN) -> {
         *  statment1;
         *  statment2;
         *  ...
         *  return statmentM;
         * }
         */
//        list.sort(((o1, o2) -> {
//            return Integer.compare(o1, o2);
//        }));

        // 简写Lambda表达式
        list.sort(Comparator.comparingInt(o -> o));

        System.out.println(list.toString());


        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println(sumValue);
    }
}
