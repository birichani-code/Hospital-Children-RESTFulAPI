package com.springboot.childRESTFulAPI.repository;

import com.springboot.childRESTFulAPI.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
}
