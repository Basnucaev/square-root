package com.squareroot.service;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.squareroot.database.entity.QuadraticEquationRoot;
import com.squareroot.database.repository.QuadraticEquationRootEntityRepository;
import com.squareroot.exception.QuadraticEquationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MathServiceTest {
    private MathService mathService;

    @Mock
    private QuadraticEquationRootEntityRepository repository;

    @BeforeEach
    void setUp() {
        mathService = new MathService(repository);
    }

    @Test
    void shouldReturnRootsByTheesCoefficients() {
        // given
        long id = 1L;
        double a = 5, b = 6, c = 1;
        double rootOne = 0.2;
        double rootTwo = 1;
        QuadraticEquationRoot expected = new QuadraticEquationRoot(id, a, b, c, rootOne, rootTwo);
        when(repository.save(any())).thenReturn(new QuadraticEquationRoot(id, a, b, c, rootOne, rootTwo));

        // when
        QuadraticEquationRoot result = mathService.calculateQuadraticEquation(a, b, c);

        // then
        verify(repository, atMostOnce()).save(any());
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldThrowQuadraticEquationExceptionWhenCoefficientAZero() {
        double a = 0, b = 6, c = 1;
        assertThatThrownBy(() -> mathService.calculateQuadraticEquation(a,b,c))
                .isInstanceOf(QuadraticEquationException.class)
                .hasMessage("The \"a\" can't be null");
    }

    @Test
    void shouldThrowQuadraticEquationExceptionWhenNoRootFound() {
        double a = 12, b = 6, c = 1;
        assertThatThrownBy(() -> mathService.calculateQuadraticEquation(a,b,c))
                .isInstanceOf(QuadraticEquationException.class)
                .hasMessage("Could not find the roots of this expression");

    }
}