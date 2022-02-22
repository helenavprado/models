package Lab2;

/**
 * @author helena
 */

public class Model {
    public static final int INCHES_PER_FOOT = 12;
    public static final double POUNDS_PER_KG = 2.2046;
    public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
    public static final int TALL_INCHES = 67;
    public static final double THIN_POUNDS = 140.0;
    public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
    public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
    public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;
    private String firstName;
    private String lastName;
    private int height;
    private double weight;
    private boolean canTravel;
    private boolean smokes;


    public Model() {

    }

    /**
     * @param firstName
     * @param lastName
     * @param height
     * @param weight
     * @param canTravel
     * @param smokes
     */


    public void secondConstructor(String firstName, String lastName, int height, double weight, boolean canTravel, boolean smokes) {
        setFirstName(firstName);
        setLastName(lastName);
        setHeight(height);
        setWeight(weight);
        setCanTravel(canTravel);
        setSmokes(smokes);
    }

    /**
     * @param firstName
     * @param lastName
     * @param inchesHeight
     * @param poundsWeight
     */
    public void thirdConstructor(String firstName, String lastName, int inchesHeight, double poundsWeight) {
        this.firstName = firstName;
        this.lastName = lastName;
        height = inchesHeight;
        weight = poundsWeight;
        canTravel = true;
        smokes = false;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() >= 3 && firstName.length() <= 20) {
            this.firstName = firstName;
        } else {
            System.out.println("insert a valid first name");
        }

    }

    public void setLastName(String lastName) {
        if (lastName.length() >= 3 && lastName.length() <= 20) {
            this.lastName = lastName;
        } else {
            System.out.println("insert a valid last name");
        }
    }

    public void setHeight(int height) {
        if (height <= 84 && height >= 24) {
            this.height = height;
        } else {
            System.out.println("insert valid height");
        }
    }

    public void setWeight(double weight) {
        if (weight >= 80 && weight <= 280) {
            this.weight = weight;
        } else {
            System.out.println("insert valid weight");
        }
    }

    public void setCanTravel(boolean canTravel) {
        this.canTravel = canTravel;
    }

    public void setSmokes(boolean smokes) {
        this.smokes = smokes;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isCanTravel() {
        return canTravel;
    }

    public boolean isSmokes() {
        return smokes;
    }


    public String getHeightInFeetAndInches() {
        int feet = height / INCHES_PER_FOOT;
        int inches = height % INCHES_PER_FOOT;
        String result = " ";
        if (inches == 0) {
            result = String.format("%d feet", feet);
        } else if (inches == 1) {
            result = String.format("%d feet and %d inch", feet, inches);
        } else {
            result = String.format("%d feet and %d inches", feet, inches);
        }
        return result;

    }

    public long getWeightKg() {
        long weightKg = (long) (POUNDS_PER_KG * weight);
        long result = Math.round(weightKg);
        return result;
    }

    public void printDetails() {
        System.out.println(String.format("Name: %s %s\nHeight: %d inches\nWeight: %.2f pounds\n", getFirstName(), getLastName(), getHeight(), getWeight()));
        if (canTravel == true) {
            System.out.println("Does travel");
        } else {
            System.out.println("Does not travel");
        }

        if (smokes == true) {
            System.out.println("Does smoke");
        } else {
            System.out.println("Does not smoke");
        }

    }

    public int calculatePayDollarsPerHour() {
        int totalBonus;
        int totalPay = BASE_RATE_DOLLARS_PER_HOUR;
        boolean validBodyBonus;
        if (height >= TALL_INCHES && weight < THIN_POUNDS) {
            validBodyBonus = true;
        } else {
            validBodyBonus = false;
        }

        if (canTravel == true && validBodyBonus == true) {
            totalBonus = BASE_RATE_DOLLARS_PER_HOUR + TALL_THIN_BONUS_DOLLARS_PER_HOUR + TRAVEL_BONUS_DOLLARS_PER_HOUR;
        } else if (canTravel == true && validBodyBonus == false) {
            totalBonus = BASE_RATE_DOLLARS_PER_HOUR + TRAVEL_BONUS_DOLLARS_PER_HOUR;
        } else if (canTravel == false && validBodyBonus == true) {
            totalBonus = BASE_RATE_DOLLARS_PER_HOUR + TALL_THIN_BONUS_DOLLARS_PER_HOUR;
        } else {
            totalBonus = BASE_RATE_DOLLARS_PER_HOUR;
        }

        if (smokes == true) {
            totalPay = totalBonus - SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
        } else {
            totalPay = totalBonus;
        }

        return totalPay;

    }

    public void displayModelDetails(){
        String heightConversion = getHeightInFeetAndInches();
        int payment = calculatePayDollarsPerHour();
        String stringTravel = " ";
        String stringSmoke = " ";
        if (canTravel == true){
            stringTravel = "yep";
        } else {
            stringTravel = "nope";
        }

        if (smokes == true){
            stringSmoke = "yep";
        } else {
            stringSmoke = "nope";
        }

        System.out.println(String.format("Name: %s %s\nHeight: %s \nWeight: %.1f pounds\nTravels: %s\nSmokes: %s\nHourly rate: %d", getFirstName(), getLastName(), heightConversion, getWeight(), stringTravel, stringSmoke, payment ));
    }

}


