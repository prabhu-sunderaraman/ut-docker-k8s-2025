package com.indium.utspringbootrestapi.controller;

import com.indium.utspringbootrestapi.dto.CalcOperationDto;
import com.indium.utspringbootrestapi.dto.CalcOperationResultDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc")
public class CalcController {

    @GetMapping("/sum/{num1}/{num2}")
    public int add(@PathVariable int num1, @PathVariable int num2) {
        return num1 + num2;
    }

    @PostMapping("/product")
    public int multiply(@RequestParam int num1, @RequestParam int num2) {
        return num1 * num2;
    }

    @PostMapping("/difference")
    public int subtract(@RequestBody CalcOperationDto calcOperationDto) {
        return calcOperationDto.num1() - calcOperationDto.num2();
    }

    @GetMapping("/quotient/{num1}/{num2}")
    public CalcOperationResultDto divide(@PathVariable int num1, @PathVariable int num2) {
        return new CalcOperationResultDto(num1, num2, num1 / num2);
    }
}
