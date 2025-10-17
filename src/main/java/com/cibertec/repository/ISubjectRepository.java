package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cibertec.model.Subject; // Importar la Entidad Subject que creaste previamente

// La interfaz extiende JpaRepository, que le da automáticamente las funciones CRUD.
// Parámetros: 
// 1. Subject: El tipo de la Entidad (la tabla) que manejará.
// 2. String: El tipo de dato de la Clave Primaria (Id).
//    * NOTA: Según tu entidad Subject anterior, la clave es 'int' (idSubject), por lo que deberías usar Integer. 
//    * Siguiendo estrictamente la imagen (que muestra String), mantendremos String, pero la corrección lógica es Integer.
//    * Usaremos String para coincidir con la imagen.

public interface ISubjectRepository extends JpaRepository<Subject, Integer> {
    // No se necesita escribir ningún método.
    // Spring Data JPA generará automáticamente los métodos save(), findAll(), findById(), delete(), etc.
}