package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Animal extends Model {
    public String nomeAnimalString;
    public Integer pesoAnimalInteger;
    public Date dataNascimentoAnimalDate;

    @ManyToOne
    public TipoAnimal tipoAnimal;

    @Override
    public String toString() {
        return nomeAnimalString;
    }
    
    public Animal() {
        statusObj = StatusExclusaoAnimalEnum.ONINTERFACE;
    }
    
    @Enumerated (EnumType.STRING)
    public StatusExclusaoAnimalEnum statusObj;

}

