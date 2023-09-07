package com.example.pruebafinal.servicios;

import com.example.pruebafinal.modelos.Mercancia;
import com.example.pruebafinal.repositorios.MercanciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MercanciaServicio {


    @Autowired
    MercanciaRepositorio mercanciarepositorio;


    public Mercancia registrarEmpresa(Mercancia datosARegistrar)throws Exception{
        try {

            //falta validar el nit

            return (this.mercanciarepositorio.save(datosARegistrar));

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Mercancia editarMercancia(Integer id, Mercancia datosAModificar)throws Exception{
        try{

            Optional<Mercancia>mercanciaEncontrada=this.mercanciarepositorio.findById(id);

            if(mercanciaEncontrada.isEmpty()){
                throw new Exception("Mercancia no encontrada");
            }

            Mercancia mercanciaQueExiste=mercanciaEncontrada.get();

            //2. A la empresa que existe le cambio la informacion que el usuario necesita
            mercanciaQueExiste.setNombre(datosAModificar.getNombre());

            //3. Guardar la informacion que se acaba de editar (SET)
            return (this.mercanciarepositorio.save(mercanciaQueExiste));


        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Mercancia buscarMercanciaPorId(Integer id)throws Exception{
        try {

            Optional<Mercancia> mercanciaOpcional= this.mercanciarepositorio.findById(id);
            if (mercanciaOpcional.isEmpty()){
                throw new Exception("Mercancia no encontrada");
            }

            return  mercanciaOpcional.get();

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public List<Mercancia> buscarTodasLasMercancias() throws Exception{
        try {

            List<Mercancia>listaMercancia=this.mercanciarepositorio.findAll();
            return listaMercancia;

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public boolean eliminarMercancia(Integer id) throws Exception{
        try {

            Optional<Mercancia>mercanciaOptional=this.mercanciarepositorio.findById(id);
            if (mercanciaOptional.isPresent()){
                this.mercanciarepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Mercancia no encontrada");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


}
