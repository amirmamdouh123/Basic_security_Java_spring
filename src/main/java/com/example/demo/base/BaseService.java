package com.example.demo.base;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class BaseService<T extends BaseEntity,Repo extends baseRepo<T>>{

    @Autowired
    protected Repo repo;

    public List<T> getAllEntitys(){
        return repo.findAll();
    }


//    public List<T> getAllEntitysSorted(String direction ,String order_attribute) {
//
//        if(!order_attribute.isEmpty()){ //lw user didn't specify order_attribute
//
//            if (direction.equals("DESC")) {
//                return repo.getAllEntitysSorted(Sort.by(Sort.Direction.DESC, order_attribute));//Sort.by("firstName")
//            }
//            return repo.getAllEntitysSorted(Sort.by(order_attribute));//Sort.by("firstName")
//
//        }
//        return repo.getAllEntitysSorted(Sort.by("id"));//Sort.by("id")
//    }



//    public Page<EntityProjection> getAllEntitysPagination(int page , int sizePages, Boolean isAsc, String column) {
//        Sort.Direction direction;
//        if(isAsc){
//            direction =Sort.Direction.ASC;
//        }
//        else{
//            direction = Sort.Direction.DESC;
//        }
//        Pageable pageable= PageRequest.of(page,sizePages, direction,column);
//
//        return EntityRepo.getAllEntitysPagination(pageable);//Sort.by("firstName")
//    }






//    public Entity findbyDepartment (id id){
//        Optional<Entity> Entity = EntityRepo.findbyDepartmentID(id);
//        return Entity.orElseThrow(() -> new EntityNotFoundException(id));
//    }










    public T getObjectById (Long id){
        Optional<T> object = repo.findById(id);
        return object.orElseThrow(() -> new RuntimeException());
    }


    public void createObject (T object){
        Object x =repo.save(object);
        //return (id) x.getId();
    }

//    private void setNewEmpVacationBalance (Entity Entity){
//        Entity.setVacationBalance(21);
//    }

    public void updateEntity (Long id, T object){
        if (id == null) throw new RuntimeException("Entity id is missing");
        repo.save(object);
    }

    public void deleteEntity (Long id){
        if (id == null) throw new RuntimeException("Entity id is missing");
        repo.deleteById(id);
    }





}
