
上来就不考虑N方的方法了，这种一般如果不是N方的话就要 logN或者 N， 

* logN 和查找排序什么的类似，暂时不考虑

* N 这个，一般是找规律，找特点，很经典的方法是左边遍历一次，右边遍历一次，然后求出一些条件。最后一次给出结果。试着往这个方向走走。

* N 这个，还有一个方法是，左右向中间遍历。这题的解题方法在这里。

    * 这题确实用反证法说明比较好。 现在是i j两个index, 一个从左，一个从右。S(i,j) 为i,j 围成的面积。
    现在考虑挪i ,j 哪一个。如果a[j]比较小，那么就挪j。
    S(i,j)的面积取决于a[j]的大小。因为 i,j之间不存在一个a[x]使得S(x,j)的面积大于S(i,j)。因为如果a[x]>a[j]则，短板是a[j]，
    矩形的横轴变短了，纵轴没有变，则面积必然变小，不能变大；如果a[x]<=a[j]则a[x]是短板，则横轴纵轴都变小了，S(x,j)肯定小。
    所以，没有必要验证ij之间是否有x，使得S(x,j)的面积比当前面积大。所以就要验证S(i, x)之间是否有更大的面积。
    
    * 现在还需要考虑的问题是a[i] == a[j]的情况。这个可以i j 都向中间缩小。