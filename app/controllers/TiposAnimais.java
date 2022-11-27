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

    }
    public static void editarTipoAnimal(Long id) {
		TipoAnimal tipoAnimalEditObj = TipoAnimal.findById(id);
		renderTemplate("TiposAnimais/formulario.html", tipoAnimalEditObj);
	}
    
    public static void listarTiposAnimais(){
        String termoRecebido = params.get("termoPesquisadoFront");
		
		List<TipoAnimal> tipoAnimalListObj = Collections.EMPTY_LIST;
		if (termoRecebido == null || termoRecebido.isEmpty()) {
			tipoAnimalListObj = TipoAnimal.findAll();
		} else {
			tipoAnimalListObj = TipoAnimal.find("lower(descricaoString) like ?1", 
					"%" + termoRecebido.toLowerCase() + "%").fetch();
		}
		render(tipoAnimalListObj, termoRecebido);
    }

    public static void removerTipoAnimal(Long id) {
        TipoAnimal tipoAnimalRemObj = TipoAnimal.findById(id);
        tipoAnimalRemObj.delete();
        listarTiposAnimais();
    }
    
    public static void detalharTipoAnimal(long id) {
        TipoAnimal tipoAnimalDetObj = TipoAnimal.findById(id);
        List<Animal> tipoAnimalListDetObj = Animal.find("(lower(tipoAnimal) like ?1) AND statusObj = ?2", 
        "%" + tipoAnimalDetObj.descricaoString.toLowerCase() + "%",
        StatusExclusaoAnimalEnum.ONINTERFACE).fetch();
        render(tipoAnimalDetObj, tipoAnimalListDetObj);
    }
    
}
