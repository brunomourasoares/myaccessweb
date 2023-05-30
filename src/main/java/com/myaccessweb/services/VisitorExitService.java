package com.myaccessweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myaccessweb.repositories.VisitorExitRepository;

@Service
public class VisitorExitService {

    @Autowired
    private VisitorExitRepository visitorExitRepository;

    /*@Transactional(readOnly = true)
    public Page<VisitorDTO> findAllPaged(PageRequest pageRequest) {
        Page<Visitor> list = visitorRepository.findAll(pageRequest);
        return list.map(x -> new VisitorDTO(x));
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        Category entity = obj.orElseThrow(() -> new ResourceNotFoundException("ID " + id + " not found!"));
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        Category entity = new Category();
        BeanUtils.copyProperties(dto, entity);
        categoryRepository.save(entity);
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO update(Long id, CategoryDTO dto) {
        try {
            Category entity = categoryRepository.getReferenceById(id);
            entity.setName(dto.getName());
            entity = categoryRepository.save(entity);
            return new CategoryDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("ID "+ id + " not found!");
        }
    }

    public void delete(Long id) {
        try {
            categoryRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation, have product in this category!");
        }
    }

    public boolean LocateById(Long id) {
        if (!categoryRepository.existsById(id)) {
            return false;
        }
        else {
            return true;
        }
    }*/

}
