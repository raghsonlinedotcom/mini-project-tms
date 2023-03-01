public class Person
{
    String name;
    int age;
    char gender;
    String city;
    String skillset;
    boolean vaccinated;
    
    public Person(String name, int age, char gender, String city, String skillset, boolean vaccinated)
    {
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.city=city;
        this.skillset=skillset;
        this.vaccinated=vaccinated;
    }
    
    Consumer<Person> vaccinateConsumer = c -> c.vaccinated=true;
    
    Supplier<Boolean> isVaccinated = () -> this.vaccinated;
    
    @Override
    public String toString()
    {
        return "[Person] hashCode="+this.hashCode() + ", name=" + name + ", age=" + age + ", gender=" + gender + ", city="+city + ",vaccinated ? " + vaccinated;
    }
    
    public String getName() { return this.name;}
    public int getAge() { return this.age;}
    public char getGender() { return this.gender;}
    public String getCity() { return this.city;}
    public String getSkillset() { return this.skillset;}
    public boolean isVaccinated() { return this.vaccinated;}
}
/edit
Person rama = new Person("Rama", 24, 'M', "Hyderabad", "C, Java, Databases", true);
rama
Person theju = new Person("Theju", 23, 'F', "Belgaum", "C, C++, Java", true);
Person sravanthi = new Person("Sravanthi", 23, 'F', "Vizag", "C, Java, Python", false);
Person kavana = new Person("Kavana", 21, 'F', "Bengaluru", ".Net, Java, Databases", false);
Person arun = new Person("Arun", 24, 'M', "Hyderabad", "C,C++, Java, Cloud", true);
Person karthik = new Person("Karthik", 22, 'M', "Hassan", "C,C++, Java, Cloud", false);
List<Person> personList = Arrays.asList(arun, theju, sravanthi, kavana, arun, karthik);
personList;
personList.stream().forEach(System.out::println);
personList.stream().count();
personList.size();
personList.stream().allMatch(p -> p.vaccinated).count();
personList.stream().allMatch(p -> p.vaccinated);
personList.stream().filter(p -> p.vaccinated).count();
personList.stream().filter(p -> p.vaccinated).forEach(System.out::println);
personList.stream().filter(p -> !p.vaccinated).forEach(System.out::println);
personList.stream().noneMatch(p -> p.age>40);
/vars
List<Person> personList = Arrays.asList(arun, theju, sravanthi, kavana, rama, karthik);
personList;
personList.size();
personList.stream().count();
Stream<Person> personStream = personList.stream();
personStream.count();
Stream<Person> personStream = personList.stream();
personStream.count();
personList.stream().count();
personList.stream().allMatch(x -> x.vaccinated);
personList.stream().filter(p -> p.vaccinated).count();
personList.stream().filter(p -> !p.vaccinated).count();
personList.stream().filter(p -> p.vaccinated).forEach(System.out::println);
personList.stream().filter(p -> !p.vaccinated).forEach(System.out::println);
Predicate<Person> vaccinatedPerson = p -> p.vaccinated;
personList.stream().filter(vaccinatedPerson).forEach(System.out::println);
personList.stream().filter(!vaccinatedPerson).forEach(System.out::println);
personList.stream().filter(vaccinatedPerson).forEach(System.out::println);
personList.stream().filter(vaccinatedPerson.negate()).forEach(System.out::println);
personList.stream().allMatch(vaccinatedPerson);
personList.stream().anyMatch(vaccinatedPerson);
personList.stream().forEach(System.out::println);
personList.stream().anyMatch(p -> p.city.equals("Delhi"));
personList.stream().noneMatch(p -> p.city.equals("Delhi"));
personList.stream().forEach(System.out::println);
personList.stream().forEach(x -> System.out::println);
personList.stream().forEach(x -> System.out.println(x));
List<Integer> numList = Arrays.asList(2, 1, 4, 5, 3, 6, 8, 0, 9);
List<String> progLangList = Arrays.asList("C", "C++", "Java", ".NET", "Ruby", "PHP", "Python", "Pascal");
List<Integer> numList = Arrays.asList(2, 1, 4, 5, 3, 6, 8, 0, 9, 2, 1, 3);
numList.count();
numList.stream().count();
numList.stream().forEach(System.out::print);
numList.stream().forEach(System.out::println);
numList.stream().distinct().forEach(System.out::println);
numList.stream().distinct().limit(5).forEach(System.out::println);
numList.stream().distinct().limit(0).forEach(System.out::println);
numList.stream().distinct().limit(-1).forEach(System.out::println);
IntStream numListStream =  numList.stream().distinct();
IntStream numListStream =  numList.stream();
IntStream numListStream =  IntStream.of(2, 1, 4, 0, 6, 7, 3, 2, 1, 0, 9, 5);
numListStream.min();
numListStream.min().get();
numListStream.min().getAsInt();
IntStream numListStream =  IntStream.of(2, 1, 4, 0, 6, 7, 3, 2, 1, 0, 9, 5);
numListStream.min().getAsInt();
IntStream numListStream =  IntStream.of(2, 1, 4, 0, 6, 7, 3, 2, 1, 0, 9, 5);
numListStream.max().getAsInt();
numList.stream().forEach(System.out::println);
numList.stream().distinct().forEach(System.out::println);
numList.stream().distinct().min(Comparator::new).forEach(System.out::println);
numList.stream().distinct().forEach(System.out::println);
Comparator<Integer> numComparator = new Comparator<Integer>() {
    @Override
    public int compare(Integer n1, Integer n2)
    {
        if(n1==n2) return 0;
        if(n1>n2) return 1;
        if(n1<n2) return -1;
        return 0;
    }
}
numList.stream().distinct().max(numComparator).forEach(System.out::println);
numList.stream().distinct().max(numComparator);
numList.stream().distinct().max(numComparator).get();
Comparator<Integer> numComparator = new Comparator<Integer>() {
    @Override
    public int compare(Integer n1, Integer n2)
    {
        if(n1==n2) return 0;
        if(n1>n2) return 1;
        if(n1<n2) return -1;
        return 0;
    }
}
numList.stream().distinct().min(numComparator).get();
numList.stream().distinct().max(numComparator).get();
personList;
personList.stream().forEach(System.out::println);
personList.stream().map(p -> p.getAge()).forEach(System.out::println);
personList.stream().map(p -> p.getAge()).disinct().forEach(System.out::println);
personList.stream().map(p -> p.getAge()).forEach(System.out::println);
personList.stream().map(p -> p.getAge()).distinct().forEach(System.out::println);
personList.stream().map(p -> p.getAge()).max();
personList.stream().map(p -> p.getAge()).sum();
personList.stream().mapToInt(p -> p.getAge()).max();
personList.stream().mapToInt(p -> p.getAge());
personList.stream().mapToInt(p -> p.getAge()).sum();
numList.stream().forEach(System.out::println);
numList.stream().distinct().forEach(System.out::println);
numList.stream().distinct().sorted().forEach(System.out::println);
numList.stream().distinct().sorted().skip(3).forEach(System.out::println);
namesList.stream().forEach(System.out::println);
/names
/vars
progLangList.stream().forEach(System.out::println);
progLangList.stream().sorted().forEach(System.out::println);
Comparator<String> lengthBasedComparator = new Comparator<String>() {
    @Override
    public int compare(String s1, String s2)
    {
        if(s1.length()==s2.length()) return 0;
        if(s1.length()<s2.length()) return 1;
        if(s1.length()>s2.length()) return -1;
        return 0;
    }
}
progLangList.stream().sorted(lengthBasedComparator).forEach(System.out::println);
/save -history ~/raghs/official/training/SketchWow-Images-Docs/28Feb2023-Tue-Java8-Stream-APIs/28Feb2023-JShell-Java8-Stream-APIs.jsh
personList;
personList.stream().findAny();
personList.stream().findAny().get();
personList.stream().findFirst();
personList.stream().findFirst().get();
personList.stream().forEach(System.out::println);
personList.parallelStream().forEach(System.out::println);
personList.stream().findAny().get();
personList.stream().findFirst().get();
numList;
numList.stream().findAny();
numList.stream().findAny().get();
Stream.empty();
Stream.empty().findAny();
Stream.empty().findAny().get();
Stream.empty().findFirst();
Stream.empty().findFirst().get();
class FunExerciseStreamFindAny
{
    List<Integer> numList = Arrays.asList(2, 1, 0, 4, 2, 1, 5,8, 6, 9, 7, 3, 0);
   
    public static boolean findAnyReturnsADiffValue()
    {
        int numArray[] = new int[100]{};
            
        for(int i = 0 ; i < 100; i++)
        {
            numArray[i] = numList.stream().findAny().get();
        }
        System.out.println("numArray length : " + numArray.length);
        
        int count = Stream.of(numArray).distinct().count();
        
        System.out.println("distinct element count in Array : " + count);
        
        System.out.println("Unique Array Elements sorted...");
        System.out.println("---------------------------------");
        
        Stream.of(numArray).distinct().sorted().forEach(System.out::println);
        
        return count>1;
    }
    
    public static void main(String... args)
    {
        boolean result = FunExerciseStreamFindAny.findAnyReturnsADiffValue();
        System.out.println("result ? " + result);
    }
}
class FunExerciseStreamFindAny
{
    List<Integer> numList = Arrays.asList(2, 1, 0, 4, 2, 1, 5,8, 6, 9, 7, 3, 0);
   
    public static boolean findAnyReturnsADiffValue()
    {
        int numArray[] = new int[100];
            
        for(int i = 0 ; i < 100; i++)
        {
            numArray[i] = numList.stream().findAny().get();
        }
        System.out.println("numArray length : " + numArray.length);
        
        int count = Stream.of(numArray).distinct().count();
        
        System.out.println("distinct element count in Array : " + count);
        
        System.out.println("Unique Array Elements sorted...");
        System.out.println("---------------------------------");
        
        Stream.of(numArray).distinct().sorted().forEach(System.out::println);
        
        return count>1;
    }
    
    public static void main(String... args)
    {
        boolean result = FunExerciseStreamFindAny.findAnyReturnsADiffValue();
        System.out.println("result ? " + result);
    }
}
class FunExerciseStreamFindAny
{
    List<Integer> numList = Arrays.asList(2, 1, 0, 4, 2, 1, 5,8, 6, 9, 7, 3, 0);
   
    public static boolean findAnyReturnsADiffValue()
    {
        int numArray[] = new int[100];
            
        for(int i = 0 ; i < 100; i++)
        {
            numArray[i] = numList.stream().findAny().get();
        }
        System.out.println("numArray length : " + numArray.length);
        
        long count = Stream.of(numArray).distinct().count();
        
        System.out.println("distinct element count in Array : " + count);
        
        System.out.println("Unique Array Elements sorted...");
        System.out.println("---------------------------------");
        
        Stream.of(numArray).distinct().sorted().forEach(System.out::println);
        
        return count>1;
    }
    
    public static void main(String... args)
    {
        boolean result = FunExerciseStreamFindAny.findAnyReturnsADiffValue();
        System.out.println("result ? " + result);
    }
}
class FunExerciseStreamFindAny
{
    static List<Integer> numList = Arrays.asList(2, 1, 0, 4, 2, 1, 5,8, 6, 9, 7, 3, 0);
   
    public static boolean findAnyReturnsADiffValue()
    {
        int numArray[] = new int[100];
            
        for(int i = 0 ; i < 100; i++)
        {
            numArray[i] = numList.stream().findAny().get();
        }
        System.out.println("numArray length : " + numArray.length);
        
        long count = Stream.of(numArray).distinct().count();
        
        System.out.println("distinct element count in Array : " + count);
        
        System.out.println("Unique Array Elements sorted...");
        System.out.println("---------------------------------");
        
        Stream.of(numArray).distinct().sorted().forEach(System.out::println);
        
        return count>1;
    }
    
    public static void main(String... args)
    {
        boolean result = FunExerciseStreamFindAny.findAnyReturnsADiffValue();
        System.out.println("result ? " + result);
    }
}
FunExerciseStreamFindAny.findAnyReturnsADiffValue();
numList.stream().forEach(System.out::println);
numList.parallelStream().forEach(System.out::println);
numList.stream();
numList.parallelStream();
numList.parallelStream().forEach(System.out::println);
numList.stream().forEach(System.out::println);
Stream.of(3, 6, 9, 1, 8, 6, 4, 2).forEach(System.out::println);
Arrays.asList(1,2,3,4,5,6).stream().forEach(System.out::println);
int[] intArray = new int[] {2, 4, 6, 8};
Arrays.stream(intArray);
Arrays.stream(intArray).stream();
Arrays.stream(intArray).forEach(System.out::println);
Arrays.stream(intArray).findAny();
personList;
personList.stream().forEach(System.out::println);
personList.stream().map(x -> x.age).forEach(System.out::println);
personList.stream().map(x -> x.age).count();
personList.stream().map(x -> x.age).sum();
IntStream ageStream = personList.stream().map(x -> x.age);
personList.stream().map(x -> x.age).count();
personList.stream().map(x -> x.age).forEach(System.out::println);
IntStream ageStream = personList.stream().mapToInt(x -> x.age);
ageStream.sum();
personList.stream().mapToInt(x -> x.age).sum();
personList.stream().map(x -> x.age).forEach(System.out::println);
personList.stream().map(x -> x.age).collect(Collectors.toList());
List<Integer> ageList = personList.stream().map(x -> x.age).collect(Collectors.toList());
ageList.class
ageList.type
/types
/vars
personList.stream().map(x -> x.age).forEach(System.out::println);
List<Integer> ageList = personList.stream().map(x -> x.age).collect(Collectors.toList());
ageList.size();
personList.stream().map(x -> x.age).forEach(System.out::println);
personList.stream().map(x::age).forEach(System.out::println);
personList.stream().map(x::getAge).forEach(System.out::println);
personList.stream().map(x-> x.getAge).forEach(System.out::println);
personList.stream().map(x-> x.getAge()).forEach(System.out::println);
personList.stream().map(Person::getAge).forEach(System.out::println);
personList.stream().map(x -> x.age).forEach(System.out::println);
personList.stream().map(Person::getAge).forEach(System.out::println);
personList.stream().map(Person::getAge).collect(Collectors.toList());
personList.stream().map(Person::getAge).collect(Collectors.toList()).forEach(System.out::print);
personList.stream().map(Person::getAge).collect(Collectors.toList()).collect(Collectors.joining(", "));
personList.stream().map(Person::getAge).collect(Collectors.toList());
personList.stream().map(Person::getAge).collect(Collectors.toList()).collect(Collectors.joining(", "));
personList.stream().map(Person::getAge).collect(Collectors.toList());
personList.stream().map(Person::getAge).collect(Collectors.toList()).forEach(System.out::print);
personList.stream().map(Person::getAge).collect(Collectors.joining(", "));
personList.stream().map(Person::getName).collect(Collectors.joining(", "));
personList.stream().map(Person::getName).forEach(System.out.println);
personList.stream().map(Person::getName).forEach(System.out::println);
personList.stream().map(Person::getName).collect(collectors.toList());
personList.stream().map(Person::getName).forEach(System.out::println);
personList.stream().map(Person::getName).collect(Collectors.toList());
personList.stream().map(Person::getName).collect(Collectors.toList()).forEach(System.out::print);
personList.stream().map(Person::getName).collect(Collectors.joining(", "));
personList.stream().map(Person::getAge);
personList.stream().map(Person::getAge).forEach(x -> System.out.println(x + ", of type : "+ x.class));
personList.stream().map(Person::getAge).forEach(x -> System.out.println(x.class));
Function<Object, String> getClassFunction = x -> System.out.println(x + ", is of type : " + x.class.getName());
Function<Object, String> getClassFunction = x -> x + ", " + x.getClass().getName();
/save -history ~/raghs/official/training/SketchWow-Images-Docs/01Mar2023-Wed-Java8-StreamsAPI-JDBC/01Mar2023-Wed-JShell-Java8-StreamsAPI-findAny-findAll-empty-parallel-collectors.jsh
Function<Object, String> getClassFunction = x -> x + ", " + x.getClass().getName();
getClassFunction("Java");
getClassFunction.apply("Java");
Function<Object, String> getClassFunction = x -> x + ", " + x.getClass().getName();
getClassFunction.apply("Java");
getClassFunction.apply(9);
personList.stream().map(Person::getName).collect(Collectors.joining(", "));
personList.stream().map(Person::getAge).collect(Collectors.joining(", "));
personList.stream().map(Person::getAge);
personList.stream().map(Person::getAge).map(getClassFunction);
personList.stream().map(Person::getAge).map(getClassFunction).forEach(System.out::println);
personList.stream().map(Person::getAge).map(x -> String.valueOf(x)).map(getClassFunction).forEach(System.out::println);
personList.stream().map(Person::getAge).map(x -> String.valueOf(x)).collect(Collectors.joining(", "));
Stream.of("One", "Two", "Three", "Four");
Stream.of("One", "Two", "Three", "Four").count();
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length() > 3).count();
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length() > 3).forEach(System.out::println);
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length() >= 3).forEach(System.out::println);
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length() < 3).forEach(System.out::println);
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length() < 3).peek(e -> System.out.println("Filtered value : " + e));
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length() < 3).peek(e -> System.out.println("Filtered value : " + e)).forEach(System.out::println);
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length() < 3).peek(e -> System.out.println("Filtered value : " + e));
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length() < 3).peek(e -> System.out.println("Filtered value : " + e)).count();
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length() > 3).peek(e -> System.out.println("Filtered value : " + e)).forEach(System.out::println);
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length() > 3).peek(e -> System.out.println("Filtered value : " + e));
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length() > 3).peek(e -> System.out.println("Filtered value : " + e)).forEach(System.out::println);
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length() > 3).peek(e -> System.out.println("Filtered value : " + e)).map(String::toUpperCase).peek(e -> System.out.println("Mapped Value : " + e));
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length() > 3).peek(e -> System.out.println("Filtered value : " + e)).map(String::toUpperCase).peek(e -> System.out.println("Mapped Value : " + e)).forEach(System.out::println);
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length()>3).map(x -> String::toUpperCase).forEach(x -> System.out.println("Mapped Value : " + x);
);
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length()>3).map(x -> String::toUpperCase).forEach(x -> System.out.println("Mapped Value : " + x));
);
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length()>3).map(x -> String::toUpperCase).forEach(System.out::println);
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length()>3).map(String::toUpperCase).forEach(System.out::println);
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length()>3).map(String::toUpperCase).peek(e ->  System.out.println("Mapped Value : " + e).
);forEach(System.out::println);
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length()>3).map(String::toUpperCase).peek(e ->  System.out.println("Mapped Value : " + e)).forEach(System.out::println);
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length()>3).map(String::toUpperCase).forEach(System.out::println);
Stream.of("One", "Two", "Three", "Four").filter(e -> e.length()>3).map(String::toUpperCase).peek(e ->  System.out.println("Mapped Value : " + e)).forEach(System.out::println);
/save -history ~/raghs/official/training/SketchWow-Images-Docs/01Mar2023-Wed-Java8-StreamsAPI-JDBC/01Mar2023-Wed-JShell-peek-CollectorsJoiningWithFunction.jsh
