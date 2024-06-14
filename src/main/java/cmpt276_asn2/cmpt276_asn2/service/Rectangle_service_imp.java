package cmpt276_asn2.cmpt276_asn2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpt276_asn2.cmpt276_asn2.models.Rectangle;
import cmpt276_asn2.cmpt276_asn2.models.RectangleRepository;


@Service
public class Rectangle_service_imp implements Rectangle_service{
    @Autowired
    private RectangleRepository rectangle_repo;

   
    @Override
    public List<Rectangle> getAllRectangles(){
        return rectangle_repo.findAll();
    }

    @Override
    public void saveRectangle(Rectangle rectangle){
        this.rectangle_repo.save(rectangle);
    }

    @Override
    public Rectangle getRectangleById(Integer id){
        Optional<Rectangle> optional = rectangle_repo.findById(id);
        Rectangle rectangle = null;
        if(optional.isPresent()){
            rectangle = optional.get();
        }
        else {
            throw new RuntimeException("Rectangle not found for id::"+id);
        }
        return rectangle;
    }
    @Override
    public void deleteRectangleById(Integer id){
        this.rectangle_repo.deleteById(id);
    }
}