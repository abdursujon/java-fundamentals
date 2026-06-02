import java.util.Objects;

public class EqualsHashCode {
    String name;
    int age;

    EqualsHashCode(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EqualsHashCode )) return false;
        EqualsHashCode  e = (EqualsHashCode ) o;
        return age == e.age && Objects.equals(name, e.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
