public class Person {
  
    private String name;
    private int age;
    private boolean isMale;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

  
    public void setGender(boolean isMale) {
        this.isMale = isMale;
    }

    public String getGender() {
        return isMale ? "Male" : "Female";
    }

   
    public static void main(String[] args) {
    
        Person person = new Person();

      
        person.setName("dwiii");
        person.setAge(20);
        person.setGender(false);

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Gender: " + person.getGender());
    }
} 