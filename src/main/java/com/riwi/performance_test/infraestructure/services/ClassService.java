// package com.riwi.performance_test.infraestructure.services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Sort;
// import org.springframework.stereotype.Service;

// import com.riwi.performance_test.api.dtos.request.StudentRequest;
// import com.riwi.performance_test.api.dtos.response.StudentResponse;
// import com.riwi.performance_test.domain.entities.StudentEntity;
// import com.riwi.performance_test.domain.repositories.ClassRepository;
// import com.riwi.performance_test.domain.repositories.StudentRepository;
// import com.riwi.performance_test.infraestructure.abstract_services.IClassService;
// import com.riwi.performance_test.infraestructure.helpers.ServiceHelper;
// import com.riwi.performance_test.infraestructure.helpers.mappers.ClassMapper;
// import com.riwi.performance_test.infraestructure.helpers.mappers.StudentMapper;
// import com.riwi.performance_test.utils.enums.SortType;

// import lombok.AllArgsConstructor;

// @Service
// @AllArgsConstructor
// public class ClassService {

//     private final IClassService service;

//     @Autowired
//     private final ClassMapper classMapper;
//     @Autowired
//     private final ClassRepository classRepository;
//     @Autowired
//     private final ServiceHelper serviceHelper;

//     @Override
//     public StudentResponse create(StudentRequest request) {
//         StudentEntity student = this.studentMapper.requestToEntity(request);
//         return this.studentMapper.entityToResponse(this.studentRepository.save(student));
//     }

//     @Override
//     public StudentResponse get(Long id) {
//         return this.studentMapper.entityToResponse(this.serviceHelper.find(id, studentRepository, "student"));
//     }

//     @Override
//     public StudentResponse update(StudentRequest request, Long id) {
//         StudentEntity student = this.serviceHelper.find(id, studentRepository, "student");

//         student = this.studentMapper.requestToEntity(request);
//         student.setId(id);
 
//         return this.studentMapper.entityToResponse(this.studentRepository.save(student));
//     }

//     @Override
//     public void delete(Long id) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'delete'");
//     }

//     @Override
//     public Page<StudentResponse> getAll(int page, int size, SortType sort) {
//         if (page <0) page = 0;

//         PageRequest pagination = null;

//         switch (sort) {
//             case NONE -> pagination = PageRequest.of(page, size);
    
//             case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            
//             case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());  
//         }

//         return this.studentRepository.findAll(pagination)
//                 .map(student -> this.studentMapper.entityToResponse(student));
//     }

// }
