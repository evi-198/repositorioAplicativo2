package com.cibertec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue; // ¡Importar esto!
import jakarta.persistence.GenerationType; // ¡Importar esto!

@Entity // Marca la clase como una entidad persistente para JPA
@Table(name = "Subject") // Especifica que esta clase mapea la tabla "Subject" en la base de datos
public class Subject {
    
	@Id 
    private int idSubject;
    private String code;
    private String name;
    private String level;
    private String teacher;

    // -- Constructor vacío (es requerido por la especificación JPA) --
    public Subject() {
    }

    // -- Getter para idSubject --
    public int getIdSubject() {
        return idSubject;
    }

    // -- Setter para idSubject --
    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    // -- Sobreescritura del método toString() para fines de depuración/log --
    @Override
    public String toString() {
        return "Subject [idSubject=" + idSubject + ", code=" + code + ", name=" + name + ", level=" + level
                + ", teacher=" + teacher + "]";
    }
    
    // -- Getters y Setters para los demás campos (debes añadirlos para completar la clase) --
    
    // Getter y Setter para 'code'
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    // Getter y Setter para 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter y Setter para 'level'
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    // Getter y Setter para 'teacher'
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}