// package com.spring.TecSUS.service.serviceImpl;

// import org.springframework.stereotype.Service;

// @Service
// public class FileServiceImpl {
//     @Autowired
//     private FileRepository fileRepository;

//     public File saveFile(MultipartFile file) {
//         String nomeTipoResidencia = file.getOriginalFilename();

//         try {
//             File file = new File(nomeTipoResidencia, file.getContentType(), file.getBytes());
//             return fileRepository.save(file);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//         return null;
//     }

//     public file getFile(Integer id){
//         return fileRepository.findById(id);
//     }
// }
