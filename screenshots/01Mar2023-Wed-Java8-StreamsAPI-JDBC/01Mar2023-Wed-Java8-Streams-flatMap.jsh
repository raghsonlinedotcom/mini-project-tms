Stream.of("a", "b")
  .map(String::toUpperCase)
  .collect(Collectors.toList());
List<String> numList = List.of(1);
List<String> numList = List.Of(1);
List<String> numList = Arrays.asList(1);
List<String> numList = Arrays.asList("1");
List<String> num2List = Arrays.astList("2");
List<String> num2List = Arrays.asList("2");
numList
num2List
numList.stream().forEach(System.out::println);
num2List.stream().forEach(System.out::println);
List<List<String>> listNumList = new ArrayList<ArrayList<String>>();
ArrayList<ArrayList<String>> listNumList = new ArrayList<ArrayList<String>>();
listNumList = Arrays.asList(numList, num2List);
List<List<String>> listNumList = Arrays.asList(numList, num2List);
numList
num2List
listNumList
List<String> wordList = Arrays.asList("One", "Two");
List<String> word2List = Arrays.asList("Three", "Four");
wordList
word2List
wordList.stream().map(String::toUpperCase);
wordList.stream().map(String::toUpperCase).forEach(System.out::println);
word2List.stream().map(String::toUpperCase).forEach(System.out::println);
List<List<String>> ListWordList = Arrays.asList(wordList, word2List);
ListWordList.stream().forEach(System.out::println);
ListWordList.stream().map(String::toUpperCase).forEach(System.out::println);
ListWordList.stream().flatMap(String::toUpperCase).forEach(System.out::println);
ListWordList.stream().flatMap(Collections::stream);
ListWordList.stream().flatMap(Collections::stream).collect(Collectors.toList());
ListWordList.stream().flatMap(Collection::stream);
ListWordList.stream().flatMap(Collection::stream).collect(Collectors.toList());
ListWordList.stream().forEach(System.out::println);
ListWordList.stream().flatMap(Collection::stream);
ListWordList.stream().flatMap(Collection::stream).collect(Collectors.toList());
ListWordList.stream().flatMap(Collection::stream).map(String::toUpperCase).collect(Collectors.toList());
ListWordList.stream().flatMap(Collection::stream).map(String::toUpperCase).forEach(System.out::println);
ListWordList.stream().flatMap(Collection::stream).map(String::toUpperCase).collect(Collectors.joining(", "));
ListWordList.stream().filter(e -> e.length() >3);
ListWordList.stream().flatMap(Collection::stream).filter(e -> e.length()>3).forEach(System.out::println);
/save -history ~/raghs/official/training/SketchWow-Images-Docs/01Mar2023-Wed-Java8-StreamsAPI-JDBC/01Mar2023-Wed-Java8-Streams-flatMap.jsh
