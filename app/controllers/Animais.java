package controllers;

import java.io.ObjectInputFilter.Status;
import java.util.Collections;
import java.util.List;

import models.Animal;
import models.StatusExclusaoAnimalEnum;
import models.TipoAnimal;
import play.mvc.Controller;

public class Animais extends Controller {
    public static void formulario(){
        List<TipoAnimal> tipoAnimalListObj = TipoAnimal.findAll();
        render(tipoAnimalListObj);
    }

    public static void salvarAnimal(Animal animalObj){
        animalObj.save();
        listarAnimais();

    }
    public static void editarAnimal(Long id) {
        List<TipoAnimal> tipoAnimalListObj = TipoAnimal.findAll();
		Animal animalEditObj = Animal.findById(id);
		renderTemplate("Animais/formulario.html", animalEditObj, tipoAnimalListObj);
	}
    
    public static void listarAnimais(){
		List<Animal> animalListObj = Animal.find("statusObj = ?1",StatusExclusaoAnimalEnum.ONINTERFACE).fetch();
		render(animalListObj);
    }

    public static void removerAnimal(Long id) {
        Animal animalRemObj = Animal.findById(id);
        animalRemObj.statusObj = StatusExclusaoAnimalEnum.OFFINTERFACE;
        animalRemObj.save();
        listarAnimais();
    }
    
    public static void detalharAnimal(long id) {
        Animal animalDetObj = Animal.findById(id);
        render(animalDetObj);
    }
    
}
