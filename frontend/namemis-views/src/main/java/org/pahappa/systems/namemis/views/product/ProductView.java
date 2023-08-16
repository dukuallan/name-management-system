package org.pahappa.systems.namemis.views.product;

import com.googlecode.genericdao.search.Search;
import lombok.Getter;
import lombok.Setter;
import org.pahappa.systems.namemis.core.services.ProductService;
import org.pahappa.systems.namemis.models.product.Product;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;
import org.sers.webutils.client.views.presenters.PaginatedTableView;
import org.sers.webutils.server.core.service.excel.reports.ExcelReport;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;


@ManagedBean(name = "productView")
@SessionScoped
public class ProductView extends PaginatedTableView<Product, ProductView, ProductView> {

    ProductService productService;

    @PostConstruct
    public void init(){
        productService = ApplicationContextProvider.getBean(ProductService.class);
        reloadFilterReset();
    }

    @Override
    public void reloadFromDB(int i, int i1, Map<String, Object> map) throws Exception {
        System.out.println("one " + productService.getInstances(new Search(),i, i1));
        super.setDataModels(productService.getInstances(new Search(),i, i1));
    }

   @Override
    public void reloadFilterReset(){
        //return such as 1/100 in the records from the db
       System.out.println("shjskakak " + productService.countInstances(new Search()));
       super.setTotalRecords(productService.countInstances(new Search()));
       try{
           super.reloadFilterReset();
       }catch (Exception e){
           e.printStackTrace();
       }


    }

    public void deleteProduct(Product product){
        try{
            productService.deleteInstance(product);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public List<ExcelReport> getExcelReportModels() {
        return null;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public List<Product> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        return getDataModels();
    }
}
