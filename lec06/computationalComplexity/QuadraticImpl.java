public class Quadratic {

  public static boolean hasDuplicates(int[] arr) {
    int n = arr.length; //a 1

    for (int i = 0; i < n; i++) { 
      //b. (int i = 0) 1
      //c. (i < n - 1) 1
      //d. (i++) 1

      for (int j = i + 1; j < n; j++) { 
        //e. (int j = i + 1) 1
        //f. (j < n) 1
        //g. j++ 1

        if (arr[i] == arr[j]) { // h. 1
          return true; //i. 1
        }

      }
    }

    return false;  //j. 1

    //How many times does a occur? 1
    //How many times does b occur? 1
    //How many times does c occur? n+1
    //How many times does d occur? n
    //How many times does e occur? n
    //How many times does f occur? n*(n)
    //How many times does g occur? n*(n-1)
    //How many times does h occur? n*(n-1)
    //How many times does i occur? n*(n-1)
    //How many times does j occur? 1

    //put it all together... (1 + 1 + n + 1 + n + n + n^2 + n^2 - n + n^ - n + n^2 - n + 1)
    //                       4 + 3n^2
    //                       ==> O(On^2)

    //Best case? (1 + 1 + 1 + 0 + 1 + 1 + 0 + 1 + 1 + 0) = 7 => O(1)
  }



}

