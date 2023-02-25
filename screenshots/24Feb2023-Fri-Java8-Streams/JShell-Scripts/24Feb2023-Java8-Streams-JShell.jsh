intList.size();
List<String> namesList =  Arrays.asList("Raghavan", "Rama", "Arun", "Thejaswini", "Karthik HK");
namesList.size();
class Person {
    String name;
    int age;
    
    public Person(String name, int age)
    {
        this.name=name;
        this.age=age;
    }
    
    @Override
    public String toString()
    {
        return "[Person] hashcode=" + this.hashCode() +", name=" + name +", age="+ age;
    }
}
Person raghs = new Person("Raghavan", 41);
Person arun = new Person("Arun", 24);
List<Person> personList = Arrays.asList(raghs, arun);
personList.size();
personList.stream();
personList.stream().count();
namesList.stream().count();
intList.stream().count();
intList.stream().reduce(0, (x,y) -> (x+y));
intList;
public int sum(int x, int y) {
    return x + y;
}
int sum = sum(3, 4);
intList.stream().reduce(0, (x,y) -> Integer.sum(x,y));
intList.stream().reduce(0, Integer::sum);
intList.stream().reduce(Integer::sum);
intList.stream().reduce(Integer::sum).get();
intList.stream().reduce((x,y) -> x+y);
List<Integer> emptyList = new ArrayList<Integer>();
emptyList.stream().reduce((x,y) -> x+y);
emptyList.stream().reduce((x,y) -> x+y).get();
emptyList.stream().reduce((x,y) -> x+y).orElse(0);
Stream<Integer> marksList = Stream.of(48, 35, 71, 90, 81);
marksList.count();
marksList.reduce(0, (x,y) -> x + y);
List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
intList.stream().filter(x -> x%2==1);
intList;
intList.stream().filter(x -> x%2==1).count();
intList;
intListStream;
intListStream.count();
intListStream;
intListStream.count();
Stream<Integer> intListStream = intList.stream();
intListStream.count();
ageStream.count();
ageStream.sum();
ageStream.min();
ageStream.min();
ageStream.max();
ageStream.min().orElse(0);
IntStream ageStream = IntStream.of(41, 20, 23, 24, 25);
ageStream.min().getAsInt();
numList.distinct();
numList.distinct().count();
numList.distinct().count();
numList.distinct().count();
numList.distinct().sorted();
numList.distinct().sorted().forEach(x -> System.out.println(x));
numList.distinct().forEach(x -> System.out.println(x));
numList.forEach(x -> System.out.println(x));
numList.sorted().forEach(x -> System.out.println(x));
numList.distinct().sorted().limit(3).forEach(x -> System.out.println(x));
numList.distinct().sorted().limit(3).forEach(System.out::println);
IntStream numList = IntStream.of(1, 1, 2, 3, 4, 5, 5, 6, 3, 2, 8, 7);
numList.distinct().sorted().limit(3).forEach(System.out::println);