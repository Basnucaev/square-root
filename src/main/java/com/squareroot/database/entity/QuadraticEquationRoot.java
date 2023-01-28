package com.squareroot.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"coefficient_a", "coefficient_b", "coefficient_c"})})
public class QuadraticEquationRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "coefficient_a")
    private double coefficientA;
    @Column(name = "coefficient_b")
    private double coefficientB;
    @Column(name = "coefficient_c")
    private double coefficientC;
    private double rootOne;
    private double rootTwo;

    public QuadraticEquationRoot(double coefficientA, double coefficientB, double coefficientC) {
        this.coefficientA = coefficientA;
        this.coefficientB = coefficientB;
        this.coefficientC = coefficientC;
    }

    public QuadraticEquationRoot(double coefficientA, double coefficientB, double coefficientC, double rootOne,
                                 double rootTwo) {
        this.coefficientA = coefficientA;
        this.coefficientB = coefficientB;
        this.coefficientC = coefficientC;
        this.rootOne = rootOne;
        this.rootTwo = rootTwo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof QuadraticEquationRoot root)) {
            return false;
        }

        if (Double.compare(root.getCoefficientA(), getCoefficientA()) != 0) {
            return false;
        }
        if (Double.compare(root.getCoefficientB(), getCoefficientB()) != 0) {
            return false;
        }
        if (Double.compare(root.getCoefficientC(), getCoefficientC()) != 0) {
            return false;
        }
        if (Double.compare(root.getRootOne(), getRootOne()) != 0) {
            return false;
        }
        if (Double.compare(root.getRootTwo(), getRootTwo()) != 0) {
            return false;
        }
        return getId().equals(root.getId());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId().hashCode();
        temp = Double.doubleToLongBits(getCoefficientA());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getCoefficientB());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getCoefficientC());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getRootOne());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getRootTwo());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
