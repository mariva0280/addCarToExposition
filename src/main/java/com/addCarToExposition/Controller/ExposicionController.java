package com.addCarToExposition.Controller;

import com.addCarToExposition.Domain.Exposicion;
import com.addCarToExposition.Service.ExposicionService;
import com.addCarToExposition.Service.ExpositionExistsException;
import com.addCarToExposition.Service.ExpositionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController

public class ExposicionController {
    @Autowired
    private ExposicionService exposicionService;

    @PostMapping("/exposiciones")
    public ResponseEntity<String> addExposition(@RequestBody ExposicionInput exposicion) {

        try{
            exposicionService.addExposition(exposicion);

        }catch (ExpositionExistsException e){
            String errorMessage = "Exposition with the same code already exists";
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(errorMessage);
        }
        return ResponseEntity.ok().build();
    }
    @PostMapping("exposiciones/{codExpo}/coches/{cocheId}")
    public ResponseEntity<String>addCocheToExposicion(@PathVariable int codExpo, @PathVariable int cocheId, @RequestBody CarInput coche){
        try{
            exposicionService.addCocheToExposicion(codExpo,cocheId,coche);
            return ResponseEntity.ok().build();
        }catch (ExpositionNotFoundException e){
            String errorMessage = "Exposition not found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
    @GetMapping("/exposiciones")
    public ResponseEntity<List<ExposicionCodOutput>>getExposiciones() {
        List<ExposicionCodOutput> exposiciones = exposicionService.getExposiciones();
        return ResponseEntity.ok(exposiciones);
    }
    @GetMapping("/exposiciones/{codExpo}/coches")
    public ResponseEntity<List<CarOutput>>listCarsExposicion(@PathVariable int codExpo){
        try{
            Exposicion exposicion = exposicionService.findExpoByCodExpo(codExpo);
            if(exposicion != null){
                List<CarOutput> coches = new ArrayList<>();
                for(CarInput carInput : exposicion.getCoches().values()){
                    coches.add(new CarOutput(carInput.getMatricula(),carInput.getModelo(),carInput.getMarca(),carInput.getAnyo()));
                }
                return ResponseEntity.ok(coches);
            }else{
                return ResponseEntity.notFound().build();
            }
        } catch (InvalidCarFieldException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

    }

}
