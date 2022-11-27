package jobs;

import models.TipoAnimal;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class inicializador extends Job{
    
    @Override
    public void doJob() throws Exception {
       if (TipoAnimal.count() == 0){
        TipoAnimal tipoAnimalObj1 = new TipoAnimal();
        tipoAnimalObj1.descricaoString = "Cachorro";
        tipoAnimalObj1.save();

        TipoAnimal tipoAnimalObj2 = new TipoAnimal();
        tipoAnimalObj2.descricaoString = "Gato";
        tipoAnimalObj2.save();

        TipoAnimal tipoAnimalObj3 = new TipoAnimal();
        tipoAnimalObj3.descricaoString = "Cobra";
        tipoAnimalObj3.save();

        TipoAnimal tipoAnimalObj4 = new TipoAnimal();
        tipoAnimalObj4.descricaoString = "Jacare";
        tipoAnimalObj4.save();

        TipoAnimal tipoAnimalObj5 = new TipoAnimal();
        tipoAnimalObj5.descricaoString = "Hamister";
        tipoAnimalObj5.save();

        TipoAnimal tipoAnimalObj6 = new TipoAnimal();
        tipoAnimalObj6.descricaoString = "Coelho";
        tipoAnimalObj6.save();

        TipoAnimal tipoAnimalObj7 = new TipoAnimal();
        tipoAnimalObj7.descricaoString = "Bovino";
        tipoAnimalObj7.save();

        System.out.println("O banco foi preenchido com sucesso!!!");
       }
    }
}
