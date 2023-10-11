package com.addCarToExposition.Service;

import com.addCarToExposition.Controller.CarInput;
import com.addCarToExposition.Controller.ExposicionCodOutput;
import com.addCarToExposition.Controller.ExposicionInput;
import com.addCarToExposition.Controller.ExposicionOutput;
import com.addCarToExposition.Domain.Exposicion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ExposicionService {
    private Map<Integer,Exposicion> exposiciones = new HashMap<>();

    public void addExposition(ExposicionInput input) throws ExpositionExistsException {

        Exposicion exposicion = new Exposicion(input.getCodExpo(),input.getNombre());
        if(exposiciones.containsKey(exposicion.getCodExpo())){
            throw new ExpositionExistsException("The exposition already exists");
        }
        exposiciones.put(exposicion.getCodExpo(),exposicion);
    }

    public void addCocheToExposicion(int codExpo, int cocheId, CarInput cocheInput) throws ExpositionNotFoundException {
        Exposicion exposicion = findExpoByCodExpo(codExpo);
        if(exposicion != null) {
            exposicion.addCocheExpo(cocheId,cocheInput);
        }else {
            throw new ExpositionNotFoundException("Exposition not found");
        }
    }

    public List<ExposicionCodOutput> getExposiciones() {
        List<ExposicionCodOutput> expositionOutput = new ArrayList<>();
        for(Exposicion exposicion : exposiciones.values()) {
            expositionOutput.add(new ExposicionCodOutput(exposicion.getCodExpo()));
        }
        return expositionOutput;
    }
    public Exposicion findExpoByCodExpo(int codExpo) {
        for(Exposicion exposicion : exposiciones.values()) {
            if(exposicion.getCodExpo() == codExpo){
                return exposicion;
            }
        }
        return null;
    }


}
