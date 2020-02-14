package array;

import utils.Print;

public class DistributeCandiesToPeople {

    public int findX(int candies) {
        int x = 1;
        while ((x + 1) * (x + 2) <= candies * 2) {
            x += 1;
        }
        return x;
    }

    public int[] distributeCandies(int candies, int num_people) {
        if (num_people == 1) {
            return new int[]{candies};
        }
        int[] ret = new int[num_people];
        int x = findX(candies);

        for (int i = 0; i < num_people; i++) {
            int count = x / num_people;
            count += x % num_people > i ? 1 : 0;

            if (count == 1) {
                ret[i] = i + 1;
            } else {
                ret[i] = (i + 1 + i + 1 + num_people * (count - 1)) * count / 2;
            }

        }
        ret[x % num_people] += candies - (1 + x) * x / 2;

        return ret;
    }

    public static void main(String[] args) {
        Print.printArr(new DistributeCandiesToPeople().distributeCandies(7, 4));
        Print.printArr(new DistributeCandiesToPeople().distributeCandies(10, 3));
    }
}
