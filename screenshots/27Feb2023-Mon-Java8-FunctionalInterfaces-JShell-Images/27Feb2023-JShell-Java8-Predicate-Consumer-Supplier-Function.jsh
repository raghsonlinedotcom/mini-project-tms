Supplier<Date> currentDateSupplier = () -> new Date();
currentDateSupplier.get();
Supplier<String> adminEmailSupplier = () -> "admin@example.com";
adminEmailSupplier.get();
Supplier<LocalDateTime> localDateTimeSupplier = () -> LocalDateTime.now();
import java.time.LocalDateTime;
Supplier<LocalDateTime> localDateTimeSupplier = () -> LocalDateTime.now();
localDateTimeSupplier.get();
/edit
rama.genderSupplier.get();
Person rama = new Person("Rama", 24, 'M');
Person theju = new Person("Theju", 23, 'F');
Person karthik = new Person("Karthik", 21, 'M');
Person arun = new Person("Arun", 24,'M');
Person manju = new Person("Manju", 10, 'M');
List<Person> personList = Arrays.asList(rama, theju, karthik, arun, manju);
personList.stream().count();
personList.size();
personList.stream().filter(x -> x.gender=='F').count();
personList.stream().filter(x -> x.gender=='F').forEach(System.out::println);
personList.stream().filter(x -> x.gender=='M').forEach(System.out::println);
rama.genderSupplier.get();
theju.genderSupplier.get();
theju.isMinorSupplier.get();
manju.isMinorSupplier.get();
/save -history ~/raghs/official/training/SketchWow-Images-Docs/27Feb2023-Mon-Java8-FunctionalInterfaces-JShell-Images/27Feb2023-JShell-Java8-Predicate-Consumer-Supplier.jsh
Function<String, Integer> strLenFunction = (x) -> x.length();
strLenFunction.apply("Java");
strLenFunction.apply("Raghavan");
Function<String, Boolean> isVowelFunctionFlav1 = (s) -> {
    boolean hasCharA = s.contains('a');
    boolean hasCharE = s.contains('
Function<String, Boolean> isVowelFunctionFlav1 = (s) -> {
    s=s.toLowerCase();boolean hasCharA = s.contains('a');
    boolean hasCharE = s.contains('
Function<String, Boolean> isVowelFunctionFlav1 = (s) -> {
    s=s.toLowerCase();
    boolean hasCharA = s.contains('a');
    boolean hasCharE = s.contains('e');
    boolean hasCharI = s.contains('i');
    boolean hasCharO = s.contains('o');
    boolean hasCharU = s.contains('u');
    
    return hasCharA || hasCharE || hasCharI || hasCharO || hasCharU;
}
Function<String, Boolean> isVowelFunctionFlav1 = (s) -> {
    s=s.toLowerCase();
    boolean hasCharA = s.contains("a");
    boolean hasCharE = s.contains("e");
    boolean hasCharI = s.contains("i");
    boolean hasCharO = s.contains("o");
    boolean hasCharU = s.contains("u");
    
    return hasCharA || hasCharE || hasCharI || hasCharO || hasCharU;
}
isVowelFunctionFlav1.apply("Java");
isVowelFunctionFlav1.apply("Ruby");
isVowelFunctionFlav1.apply("Python");
isVowelFunctionFlav1.apply("Fly");
/save -history ~/raghs/official/training/SketchWow-Images-Docs/27Feb2023-Mon-Java8-FunctionalInterfaces-JShell-Images/27Feb2023-JShell-Java8-Predicate-Consumer-Supplier-Function.jsh
