public class Example {

  public static double arrayMax(double[] data) {
    //What is the number of operations in each line? (concretely)

    int n = data.length; //a. 1
    double currentMax = data[0]; //b. 1

    for (int i=1; i < n; i++) { //NOTICE THE i=1
      //c. (int i = 1)  1
      //d. (i < n) 1
      //e. (i++) 1

      if (data[i] > currentMax) { //f. 1
        currentMax = data[i]; //g. 1
      }

    }

    //How many times does c occur? 1
    //How many times does d occur? n
    //How many times does e occur? n-1
    //How many times does f occur? n-1
    //How many times does g occur? n-1

    //what is the complexity for the entire loop? 
    //1 + n + n - 1 + n - 1 + n - 1 =  4n-2

    return currentMax; //h. 1
  }


  //Let's put it all together!
  // 1 + 1 + 4n -2 + 1 = 4n + 1

  //Now, what is it in Big O notation?
  // O(n)
  //Is this worst case? yes.
  //What about best case? 1 + 1 + (1 + n + n-1 + n-1) + 1 = 
  //                      1 + 1 + (3n - 1) + 1 = 3n + 2

}
