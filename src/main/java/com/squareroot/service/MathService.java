package com.squareroot.service;

import static java.util.Objects.nonNull;

import com.squareroot.database.entity.QuadraticEquationRoot;
import com.squareroot.database.repository.QuadraticEquationRootEntityRepository;
import com.squareroot.exception.QuadraticEquationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MathService {
    private final QuadraticEquationRootEntityRepository repository;

    public QuadraticEquationRoot calculateQuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            throw new QuadraticEquationException("The \"a\" can't be null");
        }

        QuadraticEquationRoot quadraticEquation = repository
                .findByCoefficientAAndCoefficientBAndCoefficientC(a, b, c);
        if (nonNull(quadraticEquation)) {
            return quadraticEquation;
        } else {
            quadraticEquation = new QuadraticEquationRoot(a, b, c);
        }

        b = -b;
        double discriminant = Math.pow(b, 2) - 4 * a * c;
        double rootOne, rootTwo;
        if (discriminant < 0) {
            throw new QuadraticEquationException("Could not find the roots of this expression");
        } else if (discriminant == 0) {
            rootOne = -b / (2 * a);
            quadraticEquation.setRootOne(rootOne);
        } else if (discriminant > 0) {
            rootOne = (-b + Math.sqrt(discriminant)) / (a * 2);
            rootTwo = (-b - Math.sqrt(discriminant)) / (a * 2);
            quadraticEquation.setRootOne(rootOne);
            quadraticEquation.setRootTwo(rootTwo);
        }
        return repository.save(quadraticEquation);
    }
}