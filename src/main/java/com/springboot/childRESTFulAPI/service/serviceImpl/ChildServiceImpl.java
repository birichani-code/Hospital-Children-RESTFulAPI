package com.springboot.childRESTFulAPI.service.serviceImpl;

import com.springboot.childRESTFulAPI.exception.ResourceNotFoundException;
import com.springboot.childRESTFulAPI.model.Child;
import com.springboot.childRESTFulAPI.payload.ChildDTO;
import com.springboot.childRESTFulAPI.payload.ChildResponse;
import com.springboot.childRESTFulAPI.repository.ChildRepository;
import com.springboot.childRESTFulAPI.service.ChildService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

public class ChildServiceImpl implements ChildService {
    private ChildRepository childRepository;

    private ModelMapper mapper;

    public ChildServiceImpl(ChildRepository childRepository, ModelMapper mapper) {
        this.childRepository = childRepository;
        this.mapper = mapper;
    }

    @Override
    public ChildDTO createChild(ChildDTO childDTO) {

            // convert DTO to entity
            Child child  = mapToEntity(childDTO);
            Child newChild = childRepository.save(child);

            // convert entity to DTO
            ChildDTO childResponse = mapToDTO(newChild);
            return childResponse;
    }

    @Override
    public ChildResponse getAllChildren(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Child> childPage = childRepository.findAll(pageable);

        // get content for page object
        List<Child> listOfChildren = childPage.getContent();

        List<ChildDTO> content= listOfChildren.stream().map(child -> mapToDTO(child)).collect(Collectors.toList());

        ChildResponse childResponse = new ChildResponse();
        childResponse.setContent(content);
        childResponse.setPageNo(childPage.getNumber());
        childResponse.setPageSize(childPage.getSize());
        childResponse.setTotalElements(childPage.getTotalElements());
        childResponse.setTotalPages(childPage.getTotalPages());
        childResponse.setLast(childPage.isLast());

        return childResponse;
    }

    @Override
    public ChildDTO getChildById(long id) {
        Child child  = childRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("child", "id", id));
        return mapToDTO(child);
    }

    @Override
    public ChildDTO updateChild(ChildDTO childDTO , long id) {
        // get child by id from the database
        Child child  = childRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("child", "id", id));


       child.setName(childDTO.getName());
       child.setAgeOfMother(childDTO.getAgeOfMother());
       child.setGender(childDTO.getGender());
       child.setMaritalStatus(childDTO.getMaritalStatus());
       child.setDateOfBirth(childDTO.getDateOfBirth());
       child.setPlaceOfBirth(childDTO.getPlaceOfBirth());
       child.setRegistrationNumber(childDTO.getRegistrationNumber());
       child.setOccupation(childDTO.getOccupation());
       child.setWeight(childDTO.getWeight());

        Child updatedChild = childRepository.save(child);
        return mapToDTO(updatedChild);
    }

    @Override
    public void deleteChildById(long id) {
        // get child by id from the database
        Child child  = childRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Child", "id", id));
        childRepository.delete(child);
    }

    // convert Entity into DTO
    private ChildDTO mapToDTO(Child child){
        ChildDTO childDTO  = mapper.map(child, ChildDTO.class);
        return childDTO;
    }

    // convert DTO to entity
    private Child mapToEntity(ChildDTO childDTO){
        Child child = mapper.map(childDTO, Child.class);
        return child;
    }
}
