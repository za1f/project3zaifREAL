public class People {
    private String name, gender, desc, weakness, strengths;
    private int age, money;

    public People(String name, String gender, int age, String desc, String weakness, String strengths, int money) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.desc = desc;
        this.strengths = strengths;
        this.weakness = weakness;
        this.money = money;
    }

    public String CharacterInfo(){
        return "Name: " + name + "\n" + "Gender: " + gender + "\n" + "Age: " + age + "\n" + "Story: " + desc + "\n" + "Strengths: " + strengths + "\n" + "Weakness: " + weakness + "\n" + "Amount needed: " + money;
    }

}