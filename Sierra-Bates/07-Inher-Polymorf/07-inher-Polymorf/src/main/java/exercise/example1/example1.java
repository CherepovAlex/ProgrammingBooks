package exercise.example1;

public class example1 {
    public static void main(String[] args) {

    }
}

class Doctor {
    boolean worksAtHospital;
    void treatPatient(){
        System.out.println("Doctor works");
    }
}

class FamilyDoctor extends Doctor {
    boolean makesHouseCalls;
    void giveAdvice() {
        System.out.println("FamilyDoctor giveAdvice");
    }
}

class Surgeon extends Doctor {
    @Override
    void treatPatient() {
        System.out.println("Surgeon works");
    }

    void makeIncision() {
        System.out.println("Surgeon make incision");
    }
}
