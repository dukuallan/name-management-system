package org.pahappa.systems.namemis.core.services.impl;

import org.pahappa.systems.namemis.core.services.AnimalService;
import org.pahappa.systems.namemis.models.animal.Animal;
import org.pahappa.systems.namemis.utils.Validate;
import org.sers.webutils.model.exception.OperationFailedException;
import org.sers.webutils.model.exception.ValidationFailedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AnimalServiceImpl extends GenericServiceImpl<Animal> implements AnimalService {

    @Override
    public Animal saveInstance(Animal entityInstance) throws ValidationFailedException, OperationFailedException {
        if(entityInstance == null){
            throw new ValidationFailedException("Animal details not found");
        }
        return save(entityInstance);
    }

    @Override
    public boolean isDeletable(Animal instance) throws OperationFailedException {
        return true;
    }
}
