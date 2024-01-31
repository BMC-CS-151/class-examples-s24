public class Person {

  private String name;
  //TODO 0: Notice this!
  private Address address;

  public Person(String name, String street, String city, String state) {
    this.name = name;
    this.address = new Address(street, city, state);
  }

  //TODO 4: we can access private member variables of the inner class
  public String getState() {
      return this.address.state;
  }

      private class Address { 

        private String street;
        private String city;
        private String state;

        public Address(String street, String city, String state) {
          this.street = street;
          this.city = city;
          this.state = state;
        }

        //TODO 1: We can access members of the outer class! (Even private!)
        public String getName() { 
            return Person.this.name;
        }
      }

  public static void main(String[] args) {
    Person person = new Person("John Doe", "123 Main St", "Philadelphia", "PA");
    
    //TODO 2: are these ok?
    //Address addy1 = new Address("123 Main St", "Philadelphia", "PA");
    Address addy2 = person.new Address("123 Main St", "Philadelphia", "PA");
    //TODO 3: What if we make Address private? Still ok :) 
  }
}
