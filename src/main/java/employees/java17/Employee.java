package employees.java17;

import java.math.BigDecimal;

record  Employee(String name, String surname,
                 Position position,
                 BigDecimal salaryPerHour) {


    public String getFullName() {
        return name + " " + surname;
    }

    @Override
    public String toString() {
        return getFullName() + " is working as a " + position.getDesc() + " with salary per hour: " + salaryPerHour.toPlainString() + " PLN";
    }
}
