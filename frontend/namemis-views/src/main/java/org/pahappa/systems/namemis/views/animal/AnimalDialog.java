package org.pahappa.systems.namemis.views.animal;

import org.pahappa.systems.namemis.core.services.AnimalService;
import org.pahappa.systems.namemis.models.animal.Animal;
import org.pahappa.systems.namemis.security.HyperLinks;
import org.pahappa.systems.namemis.views.dialogs.DialogForm;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "animalDialog")
@SessionScoped
public class AnimalDialog extends DialogForm<Animal> {
    AnimalService animalService;


    public AnimalDialog() {
        super(HyperLinks.ANIMAL_DIALOG, 700, 300);
    }

    @PostConstruct
    public void init(){
        animalService = ApplicationContextProvider.getBean(AnimalService.class);
    }

    @Override
    public void persist() throws Exception {
       this.animalService.saveInstance(super.model);
    }

    @Override
    public void resetModal(){
        super.resetModal();
        super.model = new Animal();
    }


}
