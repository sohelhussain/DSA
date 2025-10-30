# Comparator
## sort by second digit

```
package heap;
import java.util.*;
public class Comp {
    public static void main(String[] args) {
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if(a % 10 > b % 10) return 1; // we need to compare second digite.
                return -1;
            }
        };

        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(8);
        list.add(20);
        list.add(60);
        list.add(50);

        Collections.sort(list, comp);
        System.out.println(list);
    }
}
```
# sort by age
```
package heap;

import java.util.*;

class Employees {
    int age;
    String name;

    Employees(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Employees{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Comp {
    public static void main(String[] args) {
        Comparator<Employees> comp = new Comparator<Employees>() {
            @Override
            public int compare(Employees a, Employees b) {
                if(a.age > b.age) return 1;
                return -1;
            }
        };

        List<Employees> list = new ArrayList<>();
        list.add(new Employees(24, "himashu"));
        list.add(new Employees(25, "mayank"));
        list.add(new Employees(12, "sohel"));
        list.add(new Employees(20, "kaif"));

        Collections.sort(list, comp);
        System.out.println(list);
    }
}

```
---
# Comparable
when we use Comparable that take a authority to sorte by own them self
our class sort by them self
```
package heap;

import java.util.*;

class Employees implements Comparable<Employees> {
    int age;
    String name;

    Employees(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Employees{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employees that) {  // just like this
        if(this.age > that.age) return 1;
        return -1;
    }
}

public class Comp {
    public static void main(String[] args) {

        List<Employees> list = new ArrayList<>();
        list.add(new Employees(24, "himashu"));
        list.add(new Employees(25, "mayank"));
        list.add(new Employees(12, "sohel"));
        list.add(new Employees(20, "kaif"));

        Collections.sort(list); // when we use comparable interface we don't need to pass compartaer(this is third person)
        System.out.println(list);
    }
}

```
