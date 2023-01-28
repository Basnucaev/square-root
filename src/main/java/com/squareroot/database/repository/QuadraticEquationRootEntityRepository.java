package com.squareroot.database.repository;

import com.squareroot.database.entity.QuadraticEquationRoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuadraticEquationRootEntityRepository extends JpaRepository<QuadraticEquationRoot, Long> {
    QuadraticEquationRoot findByCoefficientAAndCoefficientBAndCoefficientC(double coefficientA,
                                                                           double coefficientB,
                                                                           double coefficientC);
}
