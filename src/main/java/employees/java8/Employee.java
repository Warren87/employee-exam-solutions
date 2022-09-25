package employees.java8;

import java.math.BigDecimal;

class Employee {

    final String fullName;

    Position position;

    BigDecimal salaryPerHour;

    public Employee(String name, String surname, Position position, BigDecimal salaryPerHour) {
        this.fullName = name + " " + surname;
        this.position = position;
        this.salaryPerHour = salaryPerHour;
    }

    public Position getPosition() {
        return position;
    }

    public String getFullName() {
        return fullName;
    }

    public BigDecimal getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSalaryPerHour(BigDecimal salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    @Override
    public String toString() {
        return fullName + " is workin as a " + position.getDesc() + " with salary per hour: " + salaryPerHour.toPlainString() + " PLN";
    }
}
