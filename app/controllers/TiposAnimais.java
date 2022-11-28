package controllers;

import java.io.ObjectInputFilter.Status;
import java.util.Collections;
import java.util.List;

import models.Animal;
import models.TipoAnimal;
import models.StatusExclusaoAnimalEnum;
import play.mvc.Controller;

public class TiposAnimais extends Controller {
    public static void formulario(){
        render();
    }

    public static void salvarTipoAnimal(TipoAnimal tipoAnimalObj){
        tipoAnimalObj.save();
        listarTiposAnimais();

    }
    public static void editarTipoAnimal(Long id) {
        TipoAnimal tipoAnimalEditObj = TipoAnimal.findById(id);
		renderTemplate("TiposAnimais/formulario.html", tipoAnimalEditObj);
	}
    
    public static void listarTiposAnimais(){
		
		List<TipoAnimal> tipoAnimalListObj = TipoAnimal.findAll();
		render(tipoAnimalListObj);
    }

    public static void removerTipoAnimal(Long id) {
        TipoAnimal tipoAnimalRemObj = TipoAnimal.findById(id);
        tipoAnimalRemObj.delete();
        listarTiposAnimais();
    }
    
    public static void detalharTipoAnimal(long id) {
        TipoAnimal tipoAnimalDetObj = TipoAnimal.findById(id);
        
        List<Animal> animaisPorTipoListDetObj = Animal.find("(lower(tipoAnimal.descricaoString) like ?1) AND statusObj = ?2", 
        "%" + tipoAnimalDetObj.descricaoString.toLowerCase() + "%",
        StatusExclusaoAnimalEnum.ONINTERFACE).fetch();
        render(tipoAnimalDetObj, animaisPorTipoListDetObj);
    }
    
}
