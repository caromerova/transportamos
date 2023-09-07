package com.example.pruebafinal.controladores;

import com.example.pruebafinal.modelos.Mercancia;
import com.example.pruebafinal.servicios.MercanciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mercancia")
public class MercanciaControlador {

    @Autowired
    MercanciaServicio mercanciaServicio;


    @PostMapping
    public ResponseEntity<?> registrarMercancia(@RequestBody Mercancia datosMercancia){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercanciaServicio.registrarEmpresa(datosMercancia));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }




    @PutMapping("{iupMercancia}")
    public  ResponseEntity<?> editarMercancia(@RequestBody Mercancia datosNuevosMercancia, @PathVariable Integer iupMercancia){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercanciaServicio.editarMercancia( iupMercancia, datosNuevosMercancia));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }





    @GetMapping("{iup}")
    public ResponseEntity<?> buscarUnaMercancia(@PathVariable Integer iup){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercanciaServicio.buscarMercanciaPorId(iup));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }




    @GetMapping
    public ResponseEntity<?> buscarTodasMercancia(){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercanciaServicio.buscarTodasLasMercancias());
        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }






    @DeleteMapping("{iup}")
    public ResponseEntity<?> borrarMercancia(@PathVariable Integer iup){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercanciaServicio.eliminarMercancia(iup));
        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
}


