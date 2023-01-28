package com.squareroot.controller;

import com.squareroot.database.entity.QuadraticEquationRoot;
import com.squareroot.dto.QuadraticEquationRootsDto;
import com.squareroot.service.MathService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class MathController {
    private final MathService mathService;

    @GetMapping("/quadraticEquation")
    public QuadraticEquationRootsDto getQuadraticEquationRoots(Double a, Double b, Double c) {
        QuadraticEquationRoot root = mathService.calculateQuadraticEquation(a, b, c);
        return new QuadraticEquationRootsDto(root.getRootOne(), root.getRootTwo());
    }
}