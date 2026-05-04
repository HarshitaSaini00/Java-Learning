
import java.util.ArrayList;
import java.util.List;

// ===================================
//  EXERCISE 1 — School System
//  Design: Person (base)  →  Student, Teacher
//          PhDScholar implements Scholar interface AND extends Student
// 

// Base class — shared fields for EVERYONE in school
abstract class Person {
    protected String name;
    protected int age;
    protected String address;

    public Person(String name, int age, String address) {
        this.name    = name;
        this.age     = age;
        this.address = address;
    }

    // Common to all → not overridden
    public void displayInfo() {
        System.out.println("Name: " + name + " | Age: " + age + " | Address: " + address);
    }

    // Each role must define its own details  → abstract (forces override)
    public abstract String getRoleDetails();
}

// ── Student 
class Student extends Person {
    private String studentId;
    private double gpa;

    public Student(String name, int age, String address, String studentId, double gpa) {
        super(name, age, address);   // reuse Person constructor — NO duplicate code
        this.studentId = studentId;
        this.gpa       = gpa;
    }

    @Override
    public String getRoleDetails() {
        return "STUDENT | ID: " + studentId + " | GPA: " + gpa;
    }

    public void study() {
        System.out.println(name + " is studying.");
    }
}

// ── Teacher 
class Teacher extends Person {
    private String subject;
    private double salary;

    public Teacher(String name, int age, String address, String subject, double salary) {
        super(name, age, address);
        this.subject = subject;
        this.salary  = salary;
    }

    @Override
    public String getRoleDetails() {
        return "TEACHER | Subject: " + subject + " | Salary: ₹" + salary;
    }

    public void teach() {
        System.out.println(name + " is teaching " + subject + ".");
    }
}


interface Scholar {
    void conductResearch();          // PhD scholars do research
    String getResearchTopic();
}


class PhDScholar extends Teacher implements Scholar {
    private String researchTopic;
    private String enrolledCourse;  // they're still taking courses

    public PhDScholar(String name, int age, String address,
                      String subject, double salary,
                      String researchTopic, String enrolledCourse) {
        super(name, age, address, subject, salary);
        this.researchTopic  = researchTopic;
        this.enrolledCourse = enrolledCourse;
    }

    @Override
    public String getRoleDetails() {  // overrides Teacher's version
        return "PHD SCHOLAR | Teaches & Studies | Research: " + researchTopic
               + " | Enrolled In: " + enrolledCourse;
    }

    @Override
    public void conductResearch() {
        System.out.println(name + " is conducting research on: " + researchTopic);
    }

    @Override
    public String getResearchTopic() { return researchTopic; }
}


// 
//  EXERCISE 2 — Vehicle Management
//  Design: Vehicle (base)  →  Car, Bike, Truck
//          ElectricVehicle (interface) fixes the fuelType problem
// 



abstract class Vehicle {
    protected String brand;
    protected int speed;        // km/h top speed

    public Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    // Shared behaviour — same for all
    public void start() {
        System.out.println(brand + " is starting... ✓");
    }

    public void stop() {
        System.out.println(brand + " has stopped.");
    }

    // Each vehicle calculates fuel/range differently → abstract
    public abstract String getFuelInfo();
}

// ── FuelVehicle — adds fuelType only for petrol/diesel vehicles ──
abstract class FuelVehicle extends Vehicle {
    protected String fuelType;

    public FuelVehicle(String brand, int speed, String fuelType) {
        super(brand, speed);
        this.fuelType = fuelType;
    }
}

// ── Car 
class Car extends FuelVehicle {
    private int seats;

    public Car(String brand, int speed, String fuelType, int seats) {
        super(brand, speed, fuelType);
        this.seats = seats;
    }

    @Override
    public String getFuelInfo() {
        return "Fuel: " + fuelType + " | Avg: 15 km/l | Seats: " + seats;
    }
}

// ── Bike 
class Bike extends FuelVehicle {
    private boolean isElectricStart;

    public Bike(String brand, int speed, String fuelType, boolean isElectricStart) {
        super(brand, speed, fuelType);
        this.isElectricStart = isElectricStart;
    }

    @Override
    public String getFuelInfo() {
        return "Fuel: " + fuelType + " | Avg: 40 km/l | E-Start: " + isElectricStart;
    }
}

// ── Truck — overrides start() AND calculates fuel differently ─
class Truck extends FuelVehicle {
    private double cargoTons;

    public Truck(String brand, int speed, String fuelType, double cargoTons) {
        super(brand, speed, fuelType);
        this.cargoTons = cargoTons;
    }

    @Override
    public void start() {
        System.out.println(brand + " (Heavy Truck) warming up engine... ✓");
    }

    @Override
    public String getFuelInfo() {
        // Trucks consume more per ton of cargo
        double consumption = 8 + (cargoTons * 1.5);  // litres per 100 km
        return "Fuel: " + fuelType + " | Consumption: " + consumption
               + " L/100km | Cargo: " + cargoTons + "T";
    }
}

// ── Interface for electric behaviour 
interface ElectricVehicle {
    int getBatteryLevel();       // %
    void charge();
    String getRangeInfo();
}

// ── ElectricCar — NO fuelType, uses battery instead 
class ElectricCar extends Vehicle implements ElectricVehicle {
    private int batteryLevel;      // 0-100%
    private int rangePerCharge;    // km

    public ElectricCar(String brand, int speed, int batteryLevel, int rangePerCharge) {
        super(brand, speed);
        this.batteryLevel    = batteryLevel;
        this.rangePerCharge  = rangePerCharge;
    }

    @Override
    public void start() {
        System.out.println(brand + " silently powered on ⚡ Battery: " + batteryLevel + "%");
    }

    @Override
    public String getFuelInfo() {
        return "Electric ⚡ | Battery: " + batteryLevel + "% | Range: " + getRangeInfo();
    }

    @Override
    public int getBatteryLevel() { return batteryLevel; }

    @Override
    public void charge() {
        batteryLevel = 100;
        System.out.println(brand + " fully charged! 🔋");
    }

    @Override
    public String getRangeInfo() {
        int remaining = (int)(rangePerCharge * (batteryLevel / 100.0));
        return remaining + " km remaining (full range: " + rangePerCharge + " km)";
    }
}


// 
//  EXERCISE 3 — Game Development
//  Design: GameCharacter (abstract base)  →  Warrior, Mage, Archer
//          Ability (interface) for dynamic power-ups  ← COMPOSITION
// 


interface Ability {
    String getName();
    void use(String characterName);
}

// ── Some concrete abilities 
class FireStrike implements Ability {
    @Override public String getName() { return "Fire Strike"; }
    @Override public void use(String name) {
        System.out.println("🔥 " + name + " unleashes Fire Strike! Deals 50 fire damage.");
    }
}

class IceShield implements Ability {
    @Override public String getName() { return "Ice Shield"; }
    @Override public void use(String name) {
        System.out.println("❄️  " + name + " raises Ice Shield! Blocks next 100 damage.");
    }
}

class SpeedBoost implements Ability {
    @Override public String getName() { return "Speed Boost"; }
    @Override public void use(String name) {
        System.out.println("⚡ " + name + " activates Speed Boost! +30% movement speed.");
    }
}

// ── Abstract base character 
abstract class GameCharacter {
    protected String name;
    protected int health;
    protected int level;
    protected List<Ability> abilities = new ArrayList<>();  // composition: holds abilities

    public GameCharacter(String name, int health) {
        this.name   = name;
        this.health = health;
        this.level  = 1;
    }

    // Common to all characters
    public void levelUp() {
        level++;
        int bonus = getLevelUpBonus();
        health += bonus;
        System.out.println("⬆️  " + name + " leveled up! Now Level " + level
                           + " | HP: " + health + " (+" + bonus + ")");
    }

    
    protected abstract int getLevelUpBonus();

    
    public abstract void attack();

    // Common defend — can be overridden
    public void defend() {
        System.out.println("🛡️  " + name + " takes a defensive stance.");
    }

    // ── Dynamic power-up system (composition) ────────────────
    public void gainAbility(Ability ability) {
        abilities.add(ability);
        System.out.println("✨ " + name + " gained new ability: " + ability.getName() + "!");
    }

    public void useAllAbilities() {
        if (abilities.isEmpty()) {
            System.out.println(name + " has no special abilities yet.");
            return;
        }
        abilities.forEach(a -> a.use(name));
    }

    public String getStatus() {
        return "[" + getClass().getSimpleName() + "] " + name
               + " | Level " + level + " | HP: " + health
               + " | Abilities: " + abilities.size();
    }
}

// ── Warrior 
class Warrior extends GameCharacter {
    private int armor;

    public Warrior(String name) {
        super(name, 150);   // warriors have high HP
        this.armor = 50;
    }

    @Override
    public void attack() {
        System.out.println("⚔️  " + name + " swings a heavy sword! Deals 35 physical damage.");
    }

    @Override
    public void defend() {   // overridden — warriors block with shield
        System.out.println("🛡️  " + name + " blocks with shield! Armor absorbs " + armor + " damage.");
    }

    @Override
    protected int getLevelUpBonus() { return 20; }  // warriors gain more HP
}

// ── Mage 
class Mage extends GameCharacter {
    private int mana;

    public Mage(String name) {
        super(name, 80);   // mages have low HP
        this.mana = 200;
    }

    @Override
    public void attack() {
        if (mana >= 30) {
            mana -= 30;
            System.out.println("🔮 " + name + " casts Fireball! Deals 60 magic damage. Mana: " + mana);
        } else {
            System.out.println("💫 " + name + " has low mana! Uses staff strike for 10 damage.");
        }
    }

    @Override
    protected int getLevelUpBonus() {
        mana += 50;   // mages gain mana on level-up
        return 10;    // but less HP
    }
}

// ── Archer 
class Archer extends GameCharacter {
    private int arrows;

    public Archer(String name) {
        super(name, 100);
        this.arrows = 30;
    }

    @Override
    public void attack() {
        if (arrows > 0) {
            arrows--;
            System.out.println("🏹 " + name + " shoots an arrow! Deals 25 damage. Arrows left: " + arrows);
        } else {
            System.out.println("😤 " + name + " is out of arrows! Uses dagger for 10 damage.");
        }
    }

    @Override
    protected int getLevelUpBonus() {
        arrows += 10;  // gain more arrows on level-up
        return 15;
    }
}


                                        

//  MAIN — Demonstrate all three exercises
// 
public class labs2 {

    public static void main(String[] args) {

        // ── Exercise 1: School System ─────────────────────
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║     EXERCISE 1 — SCHOOL SYSTEM   ║");
        System.out.println("╚══════════════════════════════════╝");

        Student s1 = new Student("Harshita", 21, "Gurgaon", "STU-001", 9.1);
        Teacher t1 = new Teacher("Mr. Sharma", 40, "Delhi", "Mathematics", 75000);
        PhDScholar phd = new PhDScholar("Dr. Priya", 28, "Noida",
                                        "Computer Science", 45000,
                                        "Distributed AI Systems", "Advanced Algorithms");

        Person[] people = { s1, t1, phd };

        for (Person p : people) {
            p.displayInfo();
            System.out.println("  → " + p.getRoleDetails()); // polymorphism in action
        }

        System.out.println();
        s1.study();
        t1.teach();
        phd.teach();
        phd.conductResearch();  // Scholar interface method

        // ── Exercise 2: Vehicle Management ───────────────
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║  EXERCISE 2 — VEHICLE MANAGEMENT   ║");
        System.out.println("╚════════════════════════════════════╝");

        Vehicle[] fleet = {
            new Car("Honda City", 180, "Petrol", 5),
            new Bike("Royal Enfield", 160, "Petrol", true),
            new Truck("TATA Prima", 120, "Diesel", 20.5),
            new ElectricCar("Tata Nexon EV", 150, 80, 400)
        };

        for (Vehicle v : fleet) {
            v.start();
            System.out.println("  → " + v.getFuelInfo());
        }

        // Charge the electric car
        System.out.println();
        ElectricCar ev = (ElectricCar) fleet[3];
        ev.charge();
        System.out.println("  → " + ev.getFuelInfo());

        // ── Exercise 3: Game Development ─────────────────
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║  EXERCISE 3 — GAME DEVELOPMENT     ║");
        System.out.println("╚════════════════════════════════════╝");

        Warrior warrior = new Warrior("Thor");
        Mage    mage    = new Mage("Gandalf");
        Archer  archer  = new Archer("Legolas");

        // All three attack — polymorphism
        System.out.println("── Base Attacks ──");
        warrior.attack();
        mage.attack();
        archer.attack();

        // All three defend
        System.out.println("\n── Defence ──");
        warrior.defend();   // uses overridden shield block
        mage.defend();      // uses base class version
        archer.defend();    // uses base class version

        // Level up
        System.out.println("\n── Level Up ──");
        warrior.levelUp();
        mage.levelUp();
        archer.levelUp();

        // Dynamic abilities via composition (power-ups)
        System.out.println("\n── Power-Up Drops ──");
        warrior.gainAbility(new FireStrike());
        warrior.gainAbility(new IceShield());
        archer.gainAbility(new SpeedBoost());
        archer.gainAbility(new FireStrike());

        System.out.println("\n── Using Abilities ──");
        warrior.useAllAbilities();
        archer.useAllAbilities();
        mage.useAllAbilities();       // mage has none yet

        System.out.println("\n── Final Status ──");
        System.out.println(warrior.getStatus());
        System.out.println(mage.getStatus());
        System.out.println(archer.getStatus());

        System.out.println("\n✅ All exercises complete.");
    }
}

