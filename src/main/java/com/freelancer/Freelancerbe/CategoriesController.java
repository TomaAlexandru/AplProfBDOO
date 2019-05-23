package com.freelancer.Freelancerbe;

import com.freelancer.Freelancerbe.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CategoriesController {

    @Autowired
    private SubCategoryService subCategoryService;

    @CrossOrigin
    @RequestMapping("/categories")
    public ResponseEntity<ArrayList> getTopCategories() {
        ArrayList categories = subCategoryService.getAllCategoriesAndSubcategories();
        return ResponseEntity.status(HttpStatus.OK).body(new ArrayList(categories.subList(0,10)));
    }
}
