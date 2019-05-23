package com.freelancer.Freelancerbe.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.freelancer.Freelancerbe.model.entities.SubCategory;
import com.freelancer.Freelancerbe.model.repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public ArrayList<Object> getAllCategoriesAndSubcategories() {
        HashMap<Long, Object> subCategoryWithParents = new HashMap<>();
        List<SubCategory> subCategories = subCategoryRepository.findAllByIdGreaterThan(0L);
        for (SubCategory sc : subCategories) {
            if (subCategoryWithParents.containsKey(sc.getCategory().getId())) {
                ((ArrayList) ((HashMap<String, Object>)subCategoryWithParents.get(sc.getCategory().getId())).get("subcategories"))
                    .add(new HashMap<String, Object>(){{
                        put("id", sc.getId());
                        put("name", sc.getName());
                    }});
            } else {
                subCategoryWithParents.put(
                    sc.getCategory().getId(),
                    new HashMap<String, Object>(){{
                        put("id", sc.getCategory().getId());
                        put("name", sc.getCategory().getName());
                        put("subcategories", new ArrayList<HashMap>(){{
                            add(
                                new HashMap<String, Object>(){{
                                    put("id", sc.getId());
                                    put("name", sc.getName());
                                }}
                            );
                        }});
                    }}
                );
            }
        }

        ArrayList<Object> arList = new ArrayList<>();
        for (Map.Entry<Long, Object> map : subCategoryWithParents.entrySet()) {
            arList.add(map.getValue());
        }

        return arList;
    }
}