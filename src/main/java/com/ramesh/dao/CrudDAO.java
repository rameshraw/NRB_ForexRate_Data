package com.ramesh.dao;

import java.sql.SQLException;

public interface CrudDAO<T> {
    int save(T t)throws SQLException,ClassNotFoundException;
    

    
}
