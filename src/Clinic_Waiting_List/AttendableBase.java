package Clinic_Waiting_List;


public abstract class AttendableBase implements Attendable {

    private String name;
    private int age;


    public AttendableBase(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name == null || name.isEmpty()) {
            IO.println("Name is required.");
        } else {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            IO.println("Invalid age");
        }
    }

    @Override
    public abstract void printAllInfo();

    @Override
    public abstract String getPriority();

    @Override
    public abstract int getWaitMinutes();
}

