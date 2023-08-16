package org.pahappa.systems.namemis.core.services.impl;

import org.pahappa.systems.namemis.core.services.GenericService;
import org.pahappa.systems.namemis.core.services.ProductService;
import org.pahappa.systems.namemis.models.product.Product;
import org.pahappa.systems.namemis.utils.Validate;
import org.sers.webutils.model.exception.OperationFailedException;
import org.sers.webutils.model.exception.ValidationFailedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl extends GenericServiceImpl<Product> implements ProductService {

    @Override
    public Product saveInstance(Product entityInstance) throws ValidationFailedException, OperationFailedException {
        if(entityInstance == null){
            throw new ValidationFailedException("Product details not found");
        }
        return save(entityInstance);
    }

    @Override
    public boolean isDeletable(Product instance) throws OperationFailedException {
        return false;
    }
}
