package com.springboot.childRESTFulAPI.service;

import com.springboot.childRESTFulAPI.payload.ChildDTO;
import com.springboot.childRESTFulAPI.payload.ChildResponse;
import org.springframework.stereotype.Service;

@Service
public interface ChildService {
    ChildDTO createChild(ChildDTO childDTO);

    ChildResponse getAllChildren(int pageNo, int pageSize, String sortBy, String sortDir);

    ChildDTO getChildById(long id);

    ChildDTO updateChild(ChildDTO childDTO, long id);

    void deleteChildById(long id);

}
