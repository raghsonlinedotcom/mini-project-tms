# Learning Notes 19 Nov 2022 Monday

1. Property File separated for dbconfig.
2. Added a new property `jdbc.url` in the `dbconfig.properties`
3. Add a mode flag (Dev/Prod) in the `config.properties`

## Use Case

We conditionally placed the values inside a `.jsp` file based on the flag defined in the `config.properties` file `app.mode` if it is defined as `Dev`.

## Scenario 1 - Happy Path

Define the flag as `app.mode=Dev`

```properties
app.mode=Dev
```

Result - the values are present in the UI input as `Dev` in the `create.jsp` file

## Scenario 2 - Happy Path

Define the flag as `app.mode=QA` in the config file.

```properties
app.mode=QA
```

Result - the values are NOT present in the UI input in the `create.jsp` file

## Scenario 3 - Question?

In the config file we have commented the entry itself.

```properties
#app.mode=Dev
#app.mode=QA
```
> Note: It is neither `Dev` nor `QA`, literally the flag is missing.

1. Option #1 - It will show the values as if the flag was present as `Dev`
2. Option #2 - It will NOT show the values as if the flag was present with `QA` ( something other than `Dev`)
3. Option #3 - It will throw an error because the flag was missing.

### Answer

Option #2 - The absence of the flag returns `null` in the runtime. Hence the flow

```
create.jsp -> AppUtil.java -> PropertyUtil.java
```

is clearly orchestrated without any break. The property value is null and hence the boolean value will be `false`, thus NO values are displayed in the UI page `create.jsp`.

## Scenario 4 - Question?

In the config file we have an entry but with the empty value.

```properties
#app.mode=Dev
#app.mode=QA
app.mode=
```

1. Option #1 - It will show the values as if the flag was present as `Dev`
2. Option #2 - It will NOT show the values as if the flag was present with `QA` ( something other than `Dev`)
3. Option #3 - It will throw an error because the flag was missing.

## Result

Option #2 - same as Scenario #3.
