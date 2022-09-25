package employees

import java.math.BigDecimal

data class Employee(private val name: String,
                    private val surname: String,
                    val position: Position,
                    val salaryPerHour: BigDecimal
) {

    val fullName = "$name $surname"

    override fun toString() = "$fullName is working as a ${position.positionName} with salary per hour: $salaryPerHour PLN"

}


