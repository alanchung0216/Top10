package com.basic;

/*
this link is best and talk about equals and why hashcode. 
it’s a little long but excellent. it has code too.
http://www.javaworld.com/article/2072762/java-app-dev/object-equality.html


 */

// below is good but not great
/** 
 * Person class with equals and hashcode implementation in Java
 * @author Javin Paul
 */
class Person {
    private int id;
    private String firstName;
    private String lastName;

    public int getId() { return id; }
    public void setId(int id) { this.id = id;}

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Person guest = (Person) obj;
        return id == guest.id
                && (firstName == guest.firstName 
                     || (firstName != null && firstName.equals(guest.getFirstName())))
                && (lastName == guest.lastName 
                     || (lastName != null && lastName .equals(guest.getLastName())));
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + id;
        result = prime * result
                + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }
    
}


//Read more: http://javarevisited.blogspot.com/2011/02/how-to-write-equals-method-in-java.html#ixzz4CQkwquRA
public class Equal_Hashcode_demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
