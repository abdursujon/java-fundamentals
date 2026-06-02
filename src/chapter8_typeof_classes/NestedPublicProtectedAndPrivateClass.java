public class NestedPublicProtectedAndPrivateClass implements InterfaceInJava{
    public class Teacher {
        String name;

        public Teacher(String name) {
            this.name = name;
        }
    }

    /**
     * Accessible inside the same class
     * Accessible in the same package (like default)
     * Accessible in subclasses even in different packages
     * Not accessible by unrelated classes outside package
     */
    protected class History {
        String moduleName;
        int moduleId;

        History(String moduleName, int moduleId) {
            this.moduleName = moduleName;
            this.moduleId = moduleId;
        }
    }

    /**
     * Accessible only inside the same class
     * Not visible to subclasses
     * Not visible to other classes in same package
     * Not accessible outside at all
     */
    private class HistoryMarks {
        int studentId;
        int studentMarks;

        HistoryMarks(int id, int mark) {
            this.studentId = id;
            this.studentMarks = mark;
        }
    }

    @Override
    public void typeOfClass() {
        System.out.println("I am an example nested public class. " +
                "I have public, private and protected class inside me.");
    }

    @Override
    public void speak() {

    }

    @Override
    public void speakTwo() {

    }

    @Override
    public void speakThree() {

    }

    @Override
    public void speakFour() {

    }

    public static void main(String[] args) {
        NestedPublicProtectedAndPrivateClass n = new NestedPublicProtectedAndPrivateClass();
        Teacher t = n.new Teacher("Sujon");
        History h = n.new History("World War II", 44);
        HistoryMarks hm = n.new HistoryMarks(2, 44);
        n.typeOfClass();
    }
}

class TestNestedClasses {
    public static void main(String[] args) {
        NestedPublicProtectedAndPrivateClass n = new NestedPublicProtectedAndPrivateClass();
        NestedPublicProtectedAndPrivateClass.Teacher t = n.new Teacher("Sujon");
        System.out.println(t.name);
        NestedPublicProtectedAndPrivateClass.History h = n.new History("World War II", 44);
        System.out.println("Module Name: " + h.moduleName + ". Module ID: " + h.moduleId);
        // Not allowed since this class is private
        // NestedPublicProtectedAndPrivateClass.HistoryMarks hm = n.new HistoryMarks(2, 44);
    }
}