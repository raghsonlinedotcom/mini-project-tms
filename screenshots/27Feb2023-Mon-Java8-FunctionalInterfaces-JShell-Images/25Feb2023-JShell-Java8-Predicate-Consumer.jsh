Predicate<String> isShorter = (x) -> x.length() < 10;
String s = "Java";
println s;
System.out.println(s);
s
s;
s.length();
s = "Java";
isShorter.test("Java");
isShorter.test("Java is great!");
Predicate<String> hasCharA = x -> x.contains("a");
hasCharA.test("Java");
hasCharA.test("Ruby");
hasCharA.test("JAVA");
class Person
{
    String name;
    int age;
    char gender;
    
    @Override
    public String toString()
    {
        System.out.println("[Person] hashCode=" + this.hashCode() + ", name=" + name + ", age="+ age + ", gender = "+ gender);
    }
}
class Person
{
    String name;
    int age;
    char gender;
    
    @Override
    public String toString()
    {
        return "[Person] hashCode=" + this.hashCode() + ", name=" + name + ", age="+ age + ", gender = "+ gender;
    }
}
class Person
{
    String name;
    int age;
    char gender;
    public Person(String name, int age, char gender) {
      this.name = name;
      this.age= age;
      this.gender= gender;
}   
    @Override
    public String toString()
    {
        return "[Person] hashCode=" + this.hashCode() + ", name=" + name + ", age="+ age + ", gender = "+ gender;
    }
}
Person rama = new Person("Rama", 24, 'M');
Person theju = new Person("Theju", 23, 'F');
Person karthik = new Person("Karthik", 21, 'M');
Person arun = new Person("Arun", 24,'M');
List<Person> personList = Arrays.asList(rama, theju, karthik, arun);
personList;
personList.stream().count();
personList.size();
personList.stream().filter(x -> x.gender=='F').count();
personList.stream().filter(x -> x.gender=='F').forEach(System.out::println);
personList.stream().filter(x -> x.gender=='M').forEach(System.out::println);
public class CollectionUtil
{
    public static List<Person> getAllMales(List<Person> personList)
    {
        List<Person> maleList = new ArrayList<Person>();
        
        for(Person p : personList)
        {
            if(p.gender=='M')
            {
                maleList.add(p);
            }
        }
        
        return maleList;
    }
    
    public static List<Person> getAllFemales(List<Person> personList)
    {
        List<Person> femaleList = new ArrayList<Person>();
        
        for(Person p : personList)
        {
            if(p.gender=='F')
            {
                femaleList.add(p);
            }
        }
        
        return femaleList;
    }
}
CollectionUtil.getAllMales(personList);
CollectionUtil.getAllFemales(personList);
public class StreamUtil
{
    public static List<Person> getFilteredPerson(List<Person> personList, Predicate<Person> personPredicate)
    {
        List<Person> filteredPersonList = new ArrayList<Person>();
                
        for(Person p : personList)
        {
            if(personPredicate.test(p))
            {
                filteredPersonList.add(p);
            }
        }
        return filteredPersonList;
    }
}
Predicate<Person> malePredicate = p -> p.gender=='M';
Predicate<Person> femalePredicate = p -> p.gender=='F';
StreamUtil.getFilteredPerson(personList, malePredicate);
StreamUtil.getFilteredPerson(personList, femalePredicate);
personList.stream().filter(p -> p.gender=='M').forEach(System.out::println);
personList.stream().filter(malePredicate).forEach(System.out::println);
personList.stream().filter(femalePredicate).forEach(System.out::println);
/vars
/history
/vars
/methos
/methods
/types
/save -history ~/raghs/scripts/25Feb2023-JShell-Java8-Predicate.jsh
Predicate<Integer> isOdd = n -> n%2==1;
isOdd.test(1);
isOdd.test(2);
isOdd.test(3);
isOdd.test(0);
personList.stream().filter(femalePredicate).count();
personList.stream().filter(femalePredicate).forEach(System.out::println);
personList.stream().filter(malePredicate).forEach(System.out::println);
public class Student 
{
    private String name;
    private int m1, m2, m3;
    private int total;
    private float avg;
    private boolean passed;
    
    public Student(String name, int m1, int m2, int m3)
    {
        this.name=name;
        this.m1=m1;
        this.m2=m2;
        this.m3=m3;
    }
    
    @Override
    public String toString()
    {
        return "[Student]  hashcode="+this.hashCode()+", name="+name +", m1="+m1+",m2="+m2+",m3="+m3+",total="+total+", avg="+avg+", passed?"+passed;
    }
}
Student s1 = new Student("Varun", 45, 67,81);
Student s2 = new Student("Gayathri", 35, 29, 45);
Student s3 = new Student("Rahul", 22, 22, 11);
public class Student 
{
    private String name;
    private int m1, m2, m3;
    private int total;
    private float avg;
    private boolean passed;
    
    public Student(String name, int m1, int m2, int m3)
    {
        this.name=name;
        this.m1=m1;
        this.m2=m2;
        this.m3=m3;
    }
    
    @Override
    public String toString()
    {
        return "[Student]  hashcode="+this.hashCode()+", name="+name +", m1="+m1+",m2="+m2+",m3="+m3+",total="+total+", avg="+avg+", passed?"+passed;
    }
}
public class Student 
{
    private String name; private char gender;
    private int m1, m2, m3;
    private int total;
    private float avg;
    private boolean passed;
    
    public Student(String name, char gender, int m1, int m2, int m3)
    {
        this.name=name;
        this.m1=m1;
        this.m2=m2;
        this.m3=m3;
    }
    
    @Override
    public String toString()
    {
        return "[Student]  hashcode="+this.hashCode()+", name="+name +", m1="+m1+",m2="+m2+",m3="+m3+",total="+total+", avg="+avg+", passed?"+passed;
    }
}
public class Student 
{
    private String name; private char gender;
    private int m1, m2, m3;
    private int total;
    private float avg;
    private boolean passed;
    
    public Student(String name, char gender, int m1, int m2, int m3)
    {
        this.name=name;this.gender=gender;
        this.m1=m1;
        this.m2=m2;
        this.m3=m3;
    }
    
    @Override
    public String toString()
    {
        return "[Student]  hashcode="+this.hashCode()+", name="+name +", m1="+m1+",m2="+m2+",m3="+m3+",total="+total+", avg="+avg+", passed?"+passed;
    }
}
public class Student 
{
    private String name; private char gender;
    private int m1, m2, m3;
    private int total;
    private float avg;
    private boolean passed;
    
    public Student(String name, char gender, int m1, int m2, int m3)
    {
        this.name=name;this.gender=gender;
        this.m1=m1;
        this.m2=m2;
        this.m3=m3;
    }
    
    @Override
    public String toString()
    {
        return "[Student]  hashcode="+this.hashCode()+", name="+name +",gender="+gender+",m1="+m1+",m2="+m2+",m3="+m3+",total="+total+", avg="+avg+", passed?"+passed;
    }
}
s1
Student s1 = new Student("Varun", 'M', 45, 67,81);
Student s2 = new Student("Gayathri", 'F', 35, 29, 45);
Student s3 = new Student("Rahul", 'M' , 22, 22, 11);
s1
s2
s3
/types
/vars
List<Student> studentList = Arrays.asList(s1,s2,s3);
studentList
studentList.stream().count();
studentList.stream().filter(s -> s.gender=='M').count();
public class Student 
{
    String name; char gender;
    int m1, m2, m3;
    int total;
    float avg;
    boolean passed;
    
    public Student(String name, char gender, int m1, int m2, int m3)
    {
        this.name=name;this.gender=gender;
        this.m1=m1;
        this.m2=m2;
        this.m3=m3;
    }
    
    @Override
    public String toString()
    {
        return "[Student]  hashcode="+this.hashCode()+", name="+name +",gender="+gender+",m1="+m1+",m2="+m2+",m3="+m3+",total="+total+", avg="+avg+", passed?"+passed;
    }
}
s1
Student s1 = new Student("Varun", 'M', 45, 67,81);
Student s2 = new Student("Gayathri", 'F', 35, 29, 45);
Student s3 = new Student("Rahul", 'M' , 22, 22, 11);
List<Student> studentList = Arrays.asList(s1,s2,s3);
s1
s2
s3
studentList
studentList.stream().count();
studentList.size();
studentList.stream().filter(s -> s.gender=='M').count();
studentList.stream().filter(s -> s.gender=='M').forEach(System.out::println);
studentList.stream().filter(s -> s.gender=='F').forEach(System.out::println);
studentList.stream().filter(malePredicate).count();
Predicate<Student> maleStudent = s -> s.gender=='M';
Predicate<Student> femaleStudent = s -> s.gender=='F';
studentList.stream().filter(maleStudent).count();
studentList.stream().filter(maleStudent).forEach(System.out::println);
studentList.stream().filter(femaleStudent).count();
studentList.stream().filter(femaleStudent).forEach(System.out::println);
Consumer<Student> computeTotal = s -> s.total=s.m1+s.m2+s.m3;
computeTotal.accept(s1);
s1
Consumer<Student> calculateButDontUpdateTotal = s -> System.out.println(s.m1+s.m2+s.m3);
calculateButDontUpdateTotal(s2);
calculateButDontUpdateTotal.apply(s2);
calculateButDontUpdateTotal.acept(s2);
calculateButDontUpdateTotal.accept(s2);
s2
Consumer<Student> computeAvg = s -> s.avg = s.total/3;
s1
s2
s3
computeAvg.accept(s1);
s1
/types
/vars
s1
s2
s3
Consumer<Student> computePassStatus = s -> s.passed = (s.avg >=35.0);
computePassStatus.accept(s1);
s1
/vars
studentList
studenList.stream().forEach(System.out::println);
studentList.stream().forEach(System.out::println);
computePassStatus.accept(s2);
computePassStatus.accept(s3);
studentList.stream().forEach(System.out::println);
/vars
Consumer<Student> computeTotalAvgPassStatus = s -> {
    s.total = s.m1 + s.m2 + s.m3;
    s.avg = s.total / 3;
    s.passed = (s.avg>=35.0);
    System.out.println("Total, Avg, Pass Status are computed for the student - " + s.name);
}
studentList
studentList.stream().forEach(System.out::println)
computeTotalAvgPassStatus.accept(s2);
computeTotalAvgPassStatus.accept(s3);
studentList.stream().forEach(System.out::println)
/vars
/methods
/types
/save -history ~/raghs/scripts/25Feb2023-JShell-Java8-Predicate-Consumer.jsh
Student s4 = new Student("Priya", 'F', 25, 38, 47);
studentList;
studentList.stream().forEach(System.out::println);
studentList.add(s4);
s4
studentList
studentList.add(s4)
List<Student> studentList = Arrays.asList(s1,s2,s3,s4);
studentList
studentList.stream().forEach(System.out::println);
/vars
computeTotal.accept(s4).andThen(computeAvg).andThen(computePassStatus);
computeTotal.andThen(s4).andThen(computeAvg).andThen(computePassStatus);
computeTotal.andThen(computeAvg).andThen(computePassStatus).accept(s4);
s4
studentList.stream().forEach(System.out::println);
personList;
personList.stream().forEach(System.out::println);
personList.stream().filter(malePredicate).forEach(System.out::println);
Predicate<Person> ageMoreThan22Predicate = p -> p.age>22;
personList
personList.
stream().
filter(malePredicte).
count();
personList.
stream().
filter(malePredicate).
count();
personList.stream().filter(malePredicate).forEach(System.out::println);
personList.stream().filter(malePredicate).filter(ageMoreThan22Predicate).forEach(System.out::println);
personList.stream().filter(malePredicate.and(ageMoreThan22Predicate)).forEach(System.out::println);
personList.stream().forEach(System.out::println);
personList.stream().filter(ageMoreThan22Predicate).forEach(System.out::println);
/vars
/types
/methods
/save -history ~/raghs/scripts/25Feb2023-JShell-Java8-Predicate-Consumer.jsh
