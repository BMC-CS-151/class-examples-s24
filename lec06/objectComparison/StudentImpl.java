class Student implements Comparable {
  private String name;
  private double gpa;
  private String dorm;

  public Student(String name, double gpa, String dorm) {
    this.name = name;
    this.gpa = gpa;
    this.dorm = dorm;
  }

  public Student() {}

  public String getName() {
    return name;
  }

  public double getGpa() {
    return gpa;
  }

  public String toString() {
    return name + " " + gpa + " " + dorm;
  }

  public String getDorm() {
    return dorm;
  }

  public boolean equals(Student s2) {
    return this.name.equals(s2.getName()) && this.gpa == s2.getGpa() && this.dorm == s2.getDorm();
  }

  public int compareTo(Object o) {
    Student s2 = (Student) o;
    if (this.gpa == s2.getGpa()) {
      return 0;
    } else if (this.gpa < s2.getGpa()) {
      return -1;
    } else {
      return 1;
    }
  }

}

