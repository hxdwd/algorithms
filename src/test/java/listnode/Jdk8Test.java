package listnode;

import lombok.Builder;
import lombok.Data;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * testing
 *
 * @author huangxiaodong
 * @date 2021/6/27  0:03
 */
public class Jdk8Test {


//    @Test
//    public void test() {
//        Person person = new Person();
//        person.setName("hxd");
////        person.setSex("woman");
//        Person newOne = Optional.ofNullable(person.getSex()).map(sex -> {
//            person.setSex(sex);
//            return person;
//        }).orElseGet(() -> {
//            person.setSex("man");
//            return person;
//        });
//        System.out.println(newOne);
//
//    }
//
//    @Test
//    public void testMap() {
//
//        List<Person> list = Arrays.asList(
//                Person.builder().name("hxd").sex("man").build(),
//                Person.builder().name("wsh").sex("sex").build());
//
//
//    }
//
//
//    @Data
//    @Builder
//    static class Person {
//        String name;
//        String sex;
//
//        public Person() {
//
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getSex() {
//            return sex;
//        }
//
//        public void setSex(String sex) {
//            this.sex = sex;
//        }
//
//        @Override
//        public String toString() {
//            return "Person{" +
//                    "name='" + name + '\'' +
//                    ", sex='" + sex + '\'' +
//                    '}';
//        }
//    }
}
