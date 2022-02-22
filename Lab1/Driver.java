package Lab2;

public class Driver {

    public static void main(String[] args) {
        Model myself = new Model();
        myself.setFirstName("Helena");
        myself.setLastName("Prado");
        myself.setSmokes(false);
        myself.setCanTravel(true);
        myself.setWeight(130.00);
        myself.setHeight(68);
        myself.printDetails();

        System.out.println(myself.getFirstName());
        System.out.println(myself.getLastName());
        System.out.println(myself.isSmokes());
        System.out.println(myself.isCanTravel());
        System.out.println(myself.getWeight());
        System.out.println(myself.getHeight());

        myself.displayModelDetails();


    }
}
