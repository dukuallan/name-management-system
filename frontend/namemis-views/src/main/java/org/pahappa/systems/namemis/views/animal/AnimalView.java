package org.pahappa.systems.namemis.views.animal;

import com.googlecode.genericdao.search.Search;
import org.pahappa.systems.namemis.core.services.AnimalService;
import org.pahappa.systems.namemis.models.animal.Animal;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;
import org.sers.webutils.client.views.presenters.PaginatedTableView;
import org.sers.webutils.model.RecordStatus;
import org.sers.webutils.server.core.service.excel.reports.ExcelReport;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;
import org.sers.webutils.server.core.utils.DateUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.print.attribute.standard.DateTimeAtCreation;
import java.util.Date;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "animalView")
@SessionScoped
public class AnimalView extends PaginatedTableView<Animal, AnimalView, AnimalView> {
    private AnimalService animalService;


    @PostConstruct
    public void init(){
        animalService = ApplicationContextProvider.getBean(AnimalService.class);
        reloadFilterReset();
    }

    @Override
    public void reloadFromDB(int i, int i1, Map<String, Object> map) throws Exception {
        super.setDataModels(animalService.getInstances(new Search().addFilterEqual(
                "recordStatus", RecordStatus.ACTIVE),i, i1));
    }

    @Override
    public void reloadFilterReset(){
        super.setTotalRecords(animalService.countInstances(new Search().addFilterEqual(
                "recordStatus", RecordStatus.ACTIVE)));
        try {
            super.reloadFilterReset();
        } catch (Exception e) {
            throw new RuntimeException(e);
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
    public List<Animal> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        return getDataModels();
    }

    public void deleteAnimal(Animal animal){
        try{
            animalService.deleteInstance(animal);
            super.reloadFilterReset();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
