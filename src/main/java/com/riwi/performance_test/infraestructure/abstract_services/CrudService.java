package com.riwi.performance_test.infraestructure.abstract_services;

import org.springframework.data.domain.Page;

import com.riwi.performance_test.utils.enums.SortType;

public interface CrudService <RQ,RS,ID> {

    public RS create (RQ request);

    public RS get ( ID id);

    public RS update(ID id);

    public void delete (ID id);

    public Page<RS> getAll(int  page, int size, SortType sort);
    
}

