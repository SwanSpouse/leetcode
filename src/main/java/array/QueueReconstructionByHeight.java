package array;

import utils.Print;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {

    public static class Person {
        int height;
        int count;

        Person(int height, int count) {
            this.height = height;
            this.count = count;
        }

        @Override
        public String toString() {
            return "{" + height + "," + count + "}";
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) {
            return people;
        }
        List<Person> persons = new LinkedList<Person>();
        for (int i = 0; i < people.length; i++) {
            persons.add(new Person(people[i][0], people[i][1]));
        }

        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.count != o2.count) {
                    return o1.count - o2.count;
                }
                return o1.height - o2.height;
            }
        });

        List<Person> ret = new LinkedList<>();
        for (int i = 0; i < persons.size(); i++) {
            if (i == 0 || persons.get(i).count == 0) {
                ret.add(persons.get(i));
                continue;
            }
            Person p = persons.get(i);
            int count = 0;
            int curIndex = 0;
            while (curIndex < ret.size() && count <= p.count) {
                if (ret.get(curIndex).height >= p.height) {
                    if (count == p.count && ret.get(curIndex).height >= p.height) {
                        break;
                    }
                    count += 1;
                }
                curIndex += 1;
            }
            ret.add(curIndex, p);
        }

        int[][] retArr = new int[people.length][people[0].length];
        for (int i = 0; i < ret.size(); i++) {
            retArr[i][0] = ret.get(i).height;
            retArr[i][1] = ret.get(i).count;
        }
        return retArr;
    }

    public static void main(String[] args) {
        Print.Print2DArr(new QueueReconstructionByHeight().reconstructQueue(new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2},
        }));
    }
}
