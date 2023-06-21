package com.rhars.BookCentral.services;

import com.rhars.BookCentral.controllers.AnnotationController;
import com.rhars.BookCentral.dataVO.AnnotationVO;
import com.rhars.BookCentral.mapper.DozerMapper;
import com.rhars.BookCentral.models.Annotation;
import com.rhars.BookCentral.repositories.AnnotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AnnotationService {

    @Autowired
    private AnnotationRepository repository;
    public List<AnnotationVO> findAll(){
        return DozerMapper.parseListObject(repository.findAll(), AnnotationVO.class);
    }

    public AnnotationVO findById(Long id) {
        return DozerMapper.parseObject(repository.findById(id).get(), AnnotationVO.class);
    }

    public AnnotationVO save(AnnotationVO annotationVO) {
        if(verifyAnnotation(annotationVO))
        {
            var annotation = repository.save(DozerMapper.parseObject(annotationVO, Annotation.class));
            return DozerMapper.parseObject(annotation, AnnotationVO.class);
        }
        return null;
    }

    public AnnotationVO update(AnnotationVO annotationVO) {
        var dbAnnotation = repository.findById(annotationVO.getId());
        if(dbAnnotation.isPresent() && verifyAnnotation(annotationVO)) {
            var annotation = repository.save(DozerMapper.parseObject(annotationVO, Annotation.class));
            return DozerMapper.parseObject(annotation, AnnotationVO.class);
        }
        return null;
    }

    public String delete(Long id) {
        var dbAnnotation = repository.findById(id);
        if(dbAnnotation.isPresent()) {
            repository.deleteById(id);
            return "Annotation with id " + id + " has been deleted!";
        }
        return "ID " + id + " not found!";
    }
    private boolean verifyAnnotation(AnnotationVO annotationVO) {
        if( !annotationVO.getBody().isBlank() && !annotationVO.getBody().isEmpty() &&
                (annotationVO.getPage() > 0) && !annotationVO.getTitle().isEmpty()) {
            return true;
        }
        return false;
    }


}
